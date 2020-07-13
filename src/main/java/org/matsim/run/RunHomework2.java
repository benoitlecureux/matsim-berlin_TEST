package org.matsim.run;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.PlanElement;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.PlanCalcScoreConfigGroup;
import org.matsim.core.config.groups.PlansCalcRouteConfigGroup;
import org.matsim.core.config.groups.QSimConfigGroup;
import org.matsim.core.config.groups.StrategyConfigGroup;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.replanning.strategies.DefaultPlanStrategiesModule;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.collections.CollectionUtils;
import org.matsim.vehicles.VehicleType;
import org.matsim.vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.Objects;

public class RunHomework2 {
    public static void main(String[] args) {
        Config config = ConfigUtils.loadConfig("input/berlin-v5.5-1pct.config.xml");

        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setLastIteration(3);
        config.controler().setOutputDirectory("output-berlin-v5.5-1pct");

        Scenario scenario = ScenarioUtils.loadScenario(config);

        //Network creation

        ArrayList<Link> newlinks = new ArrayList<Link>;
        for (int ii=0; ii<=size(newlinks)-1; ii++){
            scenario.getNetwork().addLink(newlinks[ii]);
        }

        //make network multimodal
        for(Link link : scenario.getNetwork().getLinks().values()){
            link.setAllowedModes(CollectionUtils.stringToSet("car,pedelec"));
        }
        for ( int ii=2 ; ii<=19; ii++ ) {
            if (ii == 6 || ii == 15) {
                continue;
            }
            Link link = scenario.getNetwork().getLinks().get(Id.createLinkId(ii));
            Objects.requireNonNull(link);
            link.setAllowedModes(CollectionUtils.stringToSet("pedelec"));
        }

        //add vehicle types
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

        //===
        org.matsim.core.controler.Controler controler = new Controler(scenario);

        controler.run();
    }
}