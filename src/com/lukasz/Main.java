package com.lukasz;

import java.util.*;

public class Main {

    private static List<Set<Integer>> getInput() {
        List<Set<Integer>> listOfSets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data:");

        String line;
        while((line = scanner.nextLine()) != "") {
            Scanner lineScanner = new Scanner(line);
            if(line.equals("")) break;
            Set<Integer> set = new HashSet<>();
            int currentID = lineScanner.nextInt();
            set.add(currentID);

            lineScanner.next();
            while (lineScanner.hasNext()) {
                String idString = lineScanner.next();
                if(idString.contains(",")) idString = idString.substring(0, idString.indexOf(","));
                currentID = Integer.parseInt(idString);
                set.add(currentID);
            }

            listOfSets.add(set);
        }

        return listOfSets;
    }

    public static void main(String[] args) {
        List<Set<Integer>> listOfSets = getInput();

        Solution solution = new Solution(listOfSets);

        System.out.println("There are " + solution.getConnectedTo0() + " programs in group with 0.");
        System.out.println("There are " + solution.getNumberOfGroups() + " groups.");

    }
}
