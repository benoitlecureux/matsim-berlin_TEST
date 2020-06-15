package org.matsim.homework.useless;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.scoring.EventsToActivities;
import org.matsim.core.scoring.PersonExperiencedActivity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleActivityHandler {/*

    int[] agents = {413074101, 442774701, 324282301, 234420501, 125330701, 250269501, 156786901, 262729001, 421165201, 412649401, 183627401, 355815401, 174197101, 383511001, 216485701, 242853801, 374091401, 137255001, 177009601, 356503501, 378215101, 456943001, 413016501, 426878401, 14282501, 183014301, 274104201, 240937701, 375770501, 212939601, 447298001, 186618601, 147054601, 287156301, 228488901, 379318001, 388298501, 262419201, 189116801, 350121101, 283507001, 442723901, 253385901, 254067001, 415623501, 325051301, 307601501, 194121501, 397981101, 69639401, 375701201, 326851801, 209611301, 370064601, 403672701, 182016001, 216906901, 427432701, 24045801, 407330201, 291819401, 298604601, 290099101, 310303401, 359604101, 372397801, 404643401, 253937901, 310832101, 184371901, 348477301, 378983101, 251998801, 201400001, 389565101, 219061401, 359295601, 362732801, 372784101, 272110501, 235056901, 61641301, 315554201, 194236501, 137118101, 338980001, 203869801, 281737301, 347050501, 189376301, 261649301, 428640201, 190321601, 324045801, 354297501, 354257801, 184655601, 171961401, 324713201, 456309201, 16435201, 240778301, 196535701, 401832901, 329723001, 411688801};
    private Map<Id<Person>, Activity> activities = new HashMap();

    @Override
    public void handleEvent(ActivityEndEvent event) {
        Activity activity = (Activity)this.activities.get(event.getPersonId());
        if (activity == null) {
            Activity firstActivity = PopulationUtils.createActivityFromLinkId(event.getActType(), event.getLinkId());
            firstActivity.setFacilityId(event.getFacilityId());
            activity = firstActivity;
        }

        activity.setEndTime(event.getTime());
        Iterator var5 = this.activityHandlers.iterator();

        while(var5.hasNext()) {
            EventsToActivities.ActivityHandler activityHandler = (EventsToActivities.ActivityHandler)var5.next();
            activityHandler.handleActivity(new PersonExperiencedActivity(event.getPersonId(), activity));
        }

        this.activities.remove(event.getPersonId());

        for(int i =0; i<agents.length-1;i++){
            String agentsToString = String.valueOf(agents[i]);
            if(event.getLinkId().equals(Id.createPersonId(agentsToString))){
                affectedVehicles.add(linkEnterEvent.getVehicleId().toString());
            }
        }
    }*/
}