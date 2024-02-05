package FD_RD;

import java.util.Scanner;

abstract class Account {
    double interestRate, amount;

    abstract double claculateInterest();
}

class FDAccount extends Account {
    int numOfDay, age;
    double InterestRate;

    @Override
    double claculateInterest() {
        double InterestRate = 0;
        if (amount <= 0 || numOfDay <= 0 || age <= 0) {
            throw new IllegalArgumentException("Invalid input values. Please enter positive values.");
        }

        if (amount <= 10000000) {
            if (numOfDay >= 7 && numOfDay <= 14) {
                InterestRate = age >= 60 ? 5.00 : 4.50;
            } else if (numOfDay >= 15 && numOfDay <= 29) {
                InterestRate = age >= 60 ? 5.25 : 4.75;
            } else if (numOfDay >= 30 && numOfDay <= 45) {
                InterestRate = age >= 60 ? 6.00 : 5.50;
            } else if (numOfDay >= 45 && numOfDay <= 60) {
                InterestRate = age >= 60 ? 7.50 : 7.00;
            }
            else if (numOfDay >= 61 && numOfDay <= 184) {
                InterestRate = age >= 60 ? 8.00 : 7.50;
            }
            else if (numOfDay >= 185 && numOfDay <= 365) {
                InterestRate = age >= 60 ? 8.50 : 8.00;
            }
            
        }
        else{
            if (numOfDay >= 7 && numOfDay <= 14) {
                InterestRate = 6.50;
            } else if (numOfDay >= 15 && numOfDay <= 29) {
                InterestRate = 6.75;
            } else if (numOfDay >= 30 && numOfDay <= 44) {
                InterestRate = 6.75;
            } else if (numOfDay >= 45 && numOfDay <= 60) {
                InterestRate = 8;
            }
            else if (numOfDay >= 61 && numOfDay <= 184) {
                InterestRate = 8.50;
            }
            else if (numOfDay >= 185 && numOfDay <= 365) {
                InterestRate = 10.00;
            }
        }

        return (InterestRate * amount * numOfDay) / (365 * 100);
    }
}

class SBAccount extends Account {
    @Override
    double claculateInterest() {
    if (amount <= 0) {
        throw new IllegalArgumentException("Invalid input values. Please enter positive values.");
    }
    interestRate = 4;
    return (amount*interestRate)/100;
    }
}

class RDAccount extends Account{
    int noOfMonths;
    double monthlyAmount;

    @Override
    double claculateInterest() {
        double calculatedinterest = 0;
        if (amount <= 0 && noOfMonths<=0 && monthlyAmount<=0) {
            throw new IllegalArgumentException("Invalid input values. Please enter positive values.");
        }
        if (noOfMonths == 6) {
            interestRate = monthlyAmount >= 10000 ? 8.00 : 7.50;
        } else if (noOfMonths == 9) {
            interestRate = monthlyAmount >= 10000 ? 8.50 : 8.00;
        }
        // Implement similar logic for other maturity periods
        // ...

        calculatedinterest = (monthlyAmount * noOfMonths * (noOfMonths + 1) * interestRate) / (2 * 100);
        return calculatedinterest;
    }
    
}

public class fd{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator for SB");
            System.out.println("2. Interest Calculator for FD");
            System.out.println("3. Interest Calculator for RD");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    SBAccount sb = new SBAccount();

                    System.out.print("Enter the SB amount : ");
                    sb.amount = scanner.nextInt();

                    System.out.println("Your interest amount for SB is : " + sb.claculateInterest() + "\n");
                    break;

                case 2:
                    FDAccount fd = new FDAccount();

                    System.out.print("Enter the FD amount : ");
                    fd.amount = scanner.nextDouble();

                    System.out.print("Enter the No. of Days : ");
                    fd.numOfDay = scanner.nextInt();

                    System.out.print("Enter your age : ");
                    fd.age = scanner.nextInt();

                    System.out.println("Your interest amount for FD is : " + fd.claculateInterest() + "\n");
                    break;

                case 3:
                    RDAccount rd = new RDAccount();

                    System.out.print("Enter the monthly amount : ");
                    rd.monthlyAmount = scanner.nextDouble();

                    System.out.print("Enter the number of months (6 or 9): ");
                    rd.noOfMonths = scanner.nextInt();

                    System.out.print("Your interest amount for RD is : " + rd.claculateInterest() + "\n");

                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nothing");
                    break;
            }
            
        }
    }
}