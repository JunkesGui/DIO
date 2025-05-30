package Challenge2;

import java.util.Scanner;

public class Menu {
    byte selection = 0;
    Car car = new Car();

    Scanner sc = new Scanner(System.in);

    void run() {
        while (selection != 9) {
            System.out.println("=====Car controls=====");
            System.out.println("Select an option:");
            System.out.println("1. Turn On/Off");
            System.out.println("2. Accelerate");
            System.out.println("3. Brake");
            System.out.println("4. Turn Left/Right");
            System.out.println("5. Check speed");
            System.out.println("6. Check gear");
            System.out.println("7. Upshift gear");
            System.out.println("8. Downshift gear");
            System.out.println("9. Exit");
            moveSelection();

            switch (selection){
                case 1:
                    car.turnOnOff();
                    break;
                case 2:
                    car.accelerate();
                    break;
                case 3:
                    car.brake();
                    break;
                case 4:
                    System.out.println("Wich way you want to turn?");
                    String side =sc.nextLine();
                    car.turn(side);
                    break;
                case 5:
                    car.checkSpeed();
                    break;
                case 6:
                    car.checkGear();
                    break;
                case 7:
                    car.upshiftGear();
                    break;
                case 8:
                    car.downshiftGear();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Option not recognized, try again");
                    break;
            }
        }
    }

    private void moveSelection() {
        selection = sc.nextByte();
        sc.nextLine();
    }
}
