package org.matsim.homework;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;

import java.util.Set;


public class EventhandlerHomework_agents {

    public static void main(String[] args){

        String inputFile = "C:/Users/Admin/Documents/Benoit/ENTPE/2A/JAVA/IntelliJ/matsim-berlin_TEST/OUPUTS/output-berlin-v5.2-1pct_V4_150it_1_LANE/berlin-v5.2-1pct.output_events.xml.gz";

        EventsManager eventsManager1 = EventsUtils.createEventsManager();

        SimpleEventHandler_vehicles eventHandlerVehicles = new SimpleEventHandler_vehicles();
        eventsManager1.addHandler(eventHandlerVehicles);

        MatsimEventsReader eventsReader1 = new MatsimEventsReader(eventsManager1);
        eventsReader1.readFile(inputFile);


        Set<String> affectedVehicles = eventHandlerVehicles.getAffectedVehicles();


        EventsManager eventsManager2 = EventsUtils.createEventsManager();

        SimpleEventHandler_agents eventHandlerAgents = new SimpleEventHandler_agents();
        eventsManager2.addHandler(eventHandlerAgents);

        MatsimEventsReader eventsReader2 = new MatsimEventsReader(eventsManager2);
        eventsReader2.readFile(inputFile);


    }
}
