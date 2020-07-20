package org.matsim.run;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Node;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigGroup;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.VspExperimentalConfigGroup;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.population.routes.NetworkRoute;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.pt.transitSchedule.api.*;
import org.matsim.pt.utils.TransitScheduleValidator;
import org.matsim.vehicles.VehicleType;
import org.matsim.vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.Collections;

import static org.apache.commons.collections.CollectionUtils.size;

public class RunHomework2 {
    //Logger will write info in the console
    private final static Logger LOG = Logger.getLogger(RunHomework2.class);

    public static void main(String[] args) {
        //Config config = ConfigUtils.loadConfig("input/berlin-v5.5-1pct.config.xml");
        Config config = ConfigUtils.loadConfig("../equil/config.xml");

        //config.controler().setOutputDirectory("output-berlin-v5.5-1pct");
        config.controler().setOutputDirectory("../equil/output");
        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setLastIteration(0);

        // trying to bypass out of memory & consistency errors
        //config.global().setNumberOfThreads(2);
        config.vspExperimental().setVspDefaultsCheckingLevel(VspExperimentalConfigGroup.VspDefaultsCheckingLevel.ignore);
        ConfigUtils.addOrGetModule(config, BerlinExperimentalConfigGroup.class).setPopulationDownsampleFactor(0.1);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        //=== HW2 STARTING FROM THERE
        // Network creation
        //creating a list of nodes to connect
        ArrayList<Node> nodesNewLine = new ArrayList<>();
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_070101000010", Node.class))); //Breitenbachplatz (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_070101000093", Node.class))); //Walter Schreiber Platz (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_060063101841", Node.class))); //Feuerbachstrasse (S-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_060058102521", Node.class))); //Priesterweg (S-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_070101002392", Node.class))); //Ullsteinstrasse (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("pt_070101003046", Node.class))); //Blaschkoallee (U-Bahn)

        /*
        ArrayList<Node> nodesNewLine = new ArrayList<>();
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("1", Node.class))); //Breitenbachplatz (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("3", Node.class))); //Walter Schreiber Platz (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("5", Node.class))); //Feuerbachstrasse (S-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("6", Node.class))); //Priesterweg (S-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("11", Node.class))); //Ullsteinstrasse (U-Bahn)
        nodesNewLine.add(scenario.getNetwork().getNodes().get(Id.create("7", Node.class))); //Blaschkoallee (U-Bahn)*/

        // creating a list of links & setting links parameters
        //ArrayList<Link> linksNewLine = new ArrayList<>();
        ArrayList<Id<Link>> linkIdsNewLine = new ArrayList<>();
        for (int ii=0; ii<=size(nodesNewLine)-2; ii++){
            Node node1 = nodesNewLine.get(ii);
            Node node2 = nodesNewLine.get(ii+1);
            scenario.getNetwork().addLink(scenario.getNetwork().getFactory().createLink(Id.createLinkId("linkNewLine"+(ii+1)), node1, node2));
            scenario.getNetwork().getLinks().get(Id.get("linkNewLine"+(ii+1), Link.class)).setAllowedModes(Collections.singleton("pt"));
            linkIdsNewLine.add(scenario.getNetwork().getLinks().get(Id.createLinkId("linkNewLine"+(ii+1))).getId());
        }

        //creating a list of transitStopFacilities
        ArrayList<TransitStopFacility> transitStopFacilitiesToCopy = new ArrayList<>();
        //<stopFacility id="000005100145.1" x="4666062.467169285" y="5921353.057346253" linkRefId="pt_41483" name="Szczecin, Gumience" stopAreaId="000005100145" isBlocking="false">
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070101000010", TransitStopFacility.class)));
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070101001100", TransitStopFacility.class)));
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070101001392", TransitStopFacility.class)));
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070101002392", TransitStopFacility.class)));
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070101000010", TransitStopFacility.class)));
        transitStopFacilitiesToCopy.add(scenario.getTransitSchedule().getFacilities().get(Id.get("070201075301", TransitStopFacility.class)));

        //Adding each transit Stop to the TransitSchedule and to a transitStopFacilities list
        ArrayList<TransitStopFacility> newTransitStopFacilities = new ArrayList<>();
        for (int ii=0; ii<transitStopFacilitiesToCopy.size()-1;ii++) {
            scenario.getTransitSchedule().addStopFacility(scenario.getTransitSchedule().getFactory().createTransitStopFacility(Id.create("newStopFacility"+(ii+1),
                    TransitStopFacility.class),
                    transitStopFacilitiesToCopy.get(ii).getCoord(), transitStopFacilitiesToCopy.get(ii).getIsBlockingLane()));
            scenario.getTransitSchedule().getFacilities().get(Id.get("newStopFacility"+(ii+1), TransitStopFacility.class)).
                    setLinkId(linkIdsNewLine.get(ii));
            scenario.getTransitSchedule().getFacilities().get(Id.get("newStopFacility"+(ii+1), TransitStopFacility.class)).
                    setName(transitStopFacilitiesToCopy.get(ii).getName());
            scenario.getTransitSchedule().getFacilities().get(Id.get("newStopFacility"+(ii+1), TransitStopFacility.class)).
                    setStopAreaId(transitStopFacilitiesToCopy.get(ii).getStopAreaId());
            newTransitStopFacilities.add(scenario.getTransitSchedule().getFacilities().get(Id.get("newStopFacility"+(ii+1), TransitStopFacility.class)));
        }

        /*
        //creating transit route stops
        TransitRouteStop transitRouteStop = scenario.getTransitSchedule().getFactory().createTransitRouteStop(transitStopFacilities, 1.,2.);*/

        //creating list of transit route stops
        ArrayList<TransitRouteStop> listTransitRouteStop = new ArrayList<>();
        for (int ii=0; ii<=size(newTransitStopFacilities)-1; ii++){
            listTransitRouteStop.add(scenario.getTransitSchedule().getFactory().createTransitRouteStop(newTransitStopFacilities.get(ii), 1.,2.));
        }

        // creating network route
        NetworkRoute networkRoute = new NetworkRoute();
        networkRoute.setLinkIds(linkIdsNewLine.get(0), linkIdsNewLine, linkIdsNewLine.get(linkIdsNewLine.size() - 1));
        //creating new transit route and setting params
        TransitRoute newTransitRouteUBahn = scenario.getTransitSchedule().getFactory().createTransitRoute(Id.create("newTransitRouteUBahn",
            TransitRoute.class), networkRoute, listTransitRouteStop,"pt");
        newTransitRouteUBahn.setTransportMode("rail");

        // create schedule legs
        TransitScheduleFactory tsf = scenario.getTransitSchedule().getFactory();
        for (double ii = (4*60.+30)*60.; ii<(23*60.+59)*60.; ii = ii+(4*30.)) {
            Departure departure = tsf.createDeparture(Id.create("newDep"+ii, Departure.class), ii);
            newTransitRouteUBahn.addDeparture(departure);
        }

        //creating new transit line and adding route
        TransitLine newTransitLineUBahn = scenario.getTransitSchedule().getFactory().createTransitLine(Id.create("newTransitLineUBahn", TransitLine.class));
        newTransitLineUBahn.addRoute(newTransitRouteUBahn);

        // validator
        TransitScheduleValidator.ValidationResult result = TransitScheduleValidator.validateAll(scenario.getTransitSchedule(), scenario.getNetwork());
        for (String error : result.getErrors()) {
            LOG.warn(error);
        }
        for (String warning : result.getWarnings()) {
            LOG.warn(warning);
        }
        for (TransitScheduleValidator.ValidationResult.ValidationIssue issue : result.getIssues()) {
            LOG.warn(issue.getMessage());
        }

        /*add vehicle types
        VehiclesFactory vf = scenario.getVehicles().getFactory();
        {
            VehicleType vehicleType = vf.createVehicleType(Id.create("pedelec",VehicleType.class));
            vehicleType.setMaximumVelocity(10);
            scenario.getVehicles().addVehicleType(vehicleType);
        }
        {
            VehicleType vehicleType = vf.createVehicleType(Id.create("car",VehicleType.class));
            scenario.getVehicles().addVehicleType(vehicleType);
        }
        */

        //===
        Controler controler = new Controler(scenario);

        controler.run();
    }
}