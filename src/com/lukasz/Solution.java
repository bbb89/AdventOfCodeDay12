package com.lukasz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private List<Set<Integer>> listOfSets;
    private int connectedTo0;
    private int numberOfGroups;

    public Solution(List<Set<Integer>> listOfSets) {
        this.listOfSets = listOfSets;
        Set<Set<Integer>> setOfConnections = fillSetOfConnections();
        numberOfGroups = setOfConnections.size();

    }

    private Set<Set<Integer>> fillSetOfConnections() {
        Set<Set<Integer>> setOfSets = new HashSet<>();
        Set<Integer> foundBefore = new HashSet<>();

        for(int i = 0; i < listOfSets.size(); i++) {
            if(!foundBefore.contains(i)) {
                Set<Integer> connected = findConnected(i, new HashSet<>());
                setOfSets.add(connected);
                foundBefore.addAll(connected);
                if(i == 0) connectedTo0 = connected.size();
            }
        }

        return setOfSets;
    }

    private Set<Integer> findConnected(int id,  Set<Integer> connectedWithId) {
        Set<Integer> connected = connectedWithId;
        connected.add(id);

        for(int i = 0; i < listOfSets.size(); i++) {
            Set<Integer> currentSet = listOfSets.get(i);
            if(currentSet.contains(id)) {
                for (int currentId : currentSet) {
                    if(connected.contains(currentId)) continue;
                    connected.addAll(findConnected(currentId, connected));
                }
            }
        }

        return connected;
    }

    public int getConnectedTo0() {
        return connectedTo0;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }
}
