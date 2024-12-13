package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void printCoffeDetails(int waterInMachine, int milkInMachine, int coffeeBeansInMachine, int disposableCupsInMachine, int cashInMachine){

        System.out.printf("%d ml of water\n", waterInMachine);
        System.out.printf("%d ml of milk\n", milkInMachine);
        System.out.printf("%d g of coffee beans\n", coffeeBeansInMachine);
        System.out.printf("%d disposable cups\n", disposableCupsInMachine);
        System.out.printf("$%d of money\n", cashInMachine);
    }



    public static void main(String[] args) {
        var scanner = new Scanner(System.in);


        int cashInMachine = 550;
        int waterInMachine = 400;
        int milkInMachine = 540;
        int coffeeBeansInMachine = 120;
        int disposableCupsInMachine = 9;

        int cupsMade = 0;
        while (true){
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            var action = scanner.nextLine();
            if(action.equals("exit")){
                break;
            }
            System.out.println();
            switch (action){
                case "buy":
                    if(cupsMade == 10 ){
                        System.out.println("I need cleaning!");
                        continue;
                    }
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    var option = scanner.nextLine();
                    switch (option){
                        case "back":
                            continue;
                        case "1":
                            if(waterInMachine< 250 ){
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if(coffeeBeansInMachine <16){
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            System.out.println("I have enough resources, making you a coffee!");
                            waterInMachine-=250;
                            coffeeBeansInMachine-=16;
                            cashInMachine+=4;
                            disposableCupsInMachine--;
                            cupsMade++;
                            break;
                        case "2":
                            if(waterInMachine< 350 ){
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if(milkInMachine < 75){
                                System.out.println("Sorry, not enough milk!");
                            }
                            if(coffeeBeansInMachine <20){
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            System.out.println("I have enough resources, making you a coffee!");
                            waterInMachine-=350;
                            milkInMachine-=75;
                            coffeeBeansInMachine-=20;
                            cashInMachine+=7;
                            disposableCupsInMachine--;
                            cupsMade++;
                            break;
                        case "3":
                            if(waterInMachine< 200 ){
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                            if(milkInMachine < 100){
                                System.out.println("Sorry, not enough milk!");
                            }
                            if(coffeeBeansInMachine < 12){
                                System.out.println("Sorry, not enough coffee beans!");
                                break;
                            }
                            System.out.println("I have enough resources, making you a coffee!");
                            waterInMachine-=200;
                            milkInMachine-=100;
                            coffeeBeansInMachine-=12;
                            cashInMachine+=6;
                            disposableCupsInMachine--;
                            cupsMade++;
                            break;
                    }

                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    waterInMachine += scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how many ml of milk you want to add:");
                    milkInMachine += scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffeeBeansInMachine += scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how many disposable cups you want to add:");
                    disposableCupsInMachine+=scanner.nextInt();
                    scanner.nextLine();

                    break;
                case  "take":
                    System.out.printf("I gave you $%d\n",cashInMachine);
                    cashInMachine=0;
                    break;
                case "remaining":
                    printCoffeDetails(waterInMachine,milkInMachine, coffeeBeansInMachine,disposableCupsInMachine,cashInMachine);
                    break;
                case "clean":
                    System.out.println("I have been cleaned!");
                    cupsMade=0;
                    break;
            }
            System.out.println();
        }
    }
}