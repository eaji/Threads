import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class HorseRace {
    static int numHorse = 0;
    static int healthyHorse = 0;

    public static void main (String [] args) {
]        Random randomGenerator = new Random();
        Scanner input = new Scanner(System.in);
        int counter = 0;

        do {
            System.out.print("Enter number of horses: ");
            while (!input.hasNextInt()) {
                input.next();
            }
            numHorse  = input.nextInt();
        } while (numHorse < 2);
            input.nextLine();

        Horse [] horseArray = new Horse[numHorse];
        List<String> healthyHorses = new ArrayList<>();
        List<Integer> numHealthyHorses = new ArrayList<>();


        while (counter < horseArray.length) {

            System.out.print("Name of horse " + (counter + 1) + ": ");
            String horseName = input.nextLine();
            String warCry = "*****************" + horseName + " says Yahoo! Finished!";

            int healthCondition = randomGenerator.nextInt(2);

            if (healthCondition == 1) {
                healthyHorses.add(horseName);
                numHealthyHorses.add(counter);
                horseArray[counter] = new Horse(warCry);
                horseArray[counter].setName(horseName);  
                System.out.println(horseArray[counter]);
            }
            counter++;
        }

        healthyHorses.forEach(horse -> System.out.println(horse.toUpperCase() + " - Healthy horse."));

        if(healthyHorses.size() >= 2) {
            System.out.println("...Barn to Gate...");
            for (int i = 0; i < healthyHorses.size(); i++) { 
                horseArray[numHealthyHorses.get(i)].start();
            }
        }
        else {
            System.out.println("Insufficient healthy horses to join the race. Race next time.");
        }

    }


}
