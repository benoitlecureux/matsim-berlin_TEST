package org.matsim.homework;

import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;

public class RunActivityEndEventListener {
    public static void main(String[] args) {
        String inputFile = "C:/Users/Admin/Documents/Benoit/ENTPE/2A/JAVA/IntelliJ/matsim-berlin_TEST/OUPUTS/output-berlin-v5.2-1pct_V4_150it_1_LANE/berlin-v5.2-1pct.output_events.xml.gz";

        EventsManager eventsManager = EventsUtils.createEventsManager();

        SimpleActivityEndEventHandler eventHandler = new SimpleActivityEndEventHandler();
        eventsManager.addHandler(eventHandler);

        MatsimEventsReader eventsReader = new MatsimEventsReader(eventsManager);
        eventsReader.readFile(inputFile);

        //eventHandler;
    }
}
