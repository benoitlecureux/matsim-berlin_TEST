package org.matsim.homework.useless;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.VehicleLeavesTrafficEvent;
import org.matsim.api.core.v01.events.handler.VehicleLeavesTrafficEventHandler;

import java.util.HashSet;
import java.util.Set;


public class SimpleEventHandler_agents implements VehicleLeavesTrafficEventHandler {
    @Override
    public void handleEvent(VehicleLeavesTrafficEvent vehicleLeavesTrafficEvent) {

    }
/*
    Set<String> affectedVehicles = eventHandlerVehicles.getAffectedVehicles();

    Set<String> affectedAgents = new HashSet<>();

    @Override
    public void handleEvent(VehicleLeavesTrafficEvent vehicleLeavesTrafficEvent) {

        for(int i =0; i<affectedVehicles.length-1;i++){
            if(vehicleLeavesTrafficEvent.getLinkId().equals(Id.createLinkId(affectedVehicles[i]))){
                affectedAgents.add(vehicleLeavesTrafficEvent.getPersonId().toString());
            }
        }
    }

    public Set<String> getAffectedVehicles(){
        return affectedVehicles;
    }
 */
}
