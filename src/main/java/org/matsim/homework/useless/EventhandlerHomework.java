package org.matsim.homework.useless;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;


public class EventhandlerHomework  {

    public static void main(String[] args){

        String inputFile = "C:/Users/Thien/Desktop/uni/ss2020/matsim/berlin scenario/berlin-v5.2-1pct.output_events.xml.gz";

        EventsManager eventsManager = EventsUtils.createEventsManager();

        SimpleEventHandler eventHandler = new SimpleEventHandler();
        eventsManager.addHandler(eventHandler);

        MatsimEventsReader eventsReader = new MatsimEventsReader(eventsManager);
        eventsReader.readFile(inputFile);

        eventHandler.printVehicle();

    }
}
