package se.lexicon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to Calculex.exe\nCalculex allows you to perform: \nAddition +\nSubtraction -\nMultiplication *\nDivision /");
        while(isRunning){

            // Get first number
            System.out.println("Please enter Number 1: ");
            while(!scanner.hasNextDouble()){
                System.out.println("Please enter a valid number!");
                System.out.println("Number 1: ");
                scanner.next();
            }
             double num1 = scanner.nextDouble();


            // Get operator
            System.out.println("Operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            while(operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                System.out.println("Please enter a valid operator (+, -, *, /)!");
                System.out.println("Operator: ");
                operator = scanner.next().charAt(0);
            }


            // Get second number
            System.out.println("Please enter Number 2: ");
            while(!scanner.hasNextDouble()){
                System.out.println("Please enter a valid number!");
                System.out.println("Number 2: ");
                scanner.next();
            }
            double num2 = scanner.nextDouble();
            performCalculation(num1, num2, operator);

            System.out.println("Do you wish to continue? Y/n");
            String response = scanner.next().toLowerCase();
            isRunning = response.equals("yes") || response.equals("y");

        }

        System.out.println("Thank you for using the calculator. Bye");

    }

    public static void performCalculation(double num1, double num2, char operator){
        double result = 0;
        boolean validCalculation = true;

        switch(operator){
            case '+':
                result = num1 + num1;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 != 0)
                    result = num1 / num2;
                else {
                    System.out.println("Error: Cannot divide by 0");
                    validCalculation = false;
                }
                break;
        }
        if(validCalculation)
            System.out.printf("Result: %.2f%n", result);
    }
}