package gym;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean testMode = false;

    public static void main(String[] args) {
        takeUserInputAndCallMethods();
    }

    public static void takeUserInputAndCallMethods() {
        ArrayList<String> listOfCustomers = new ArrayList<>();
        CustomerList customerList = new CustomerList(new File("src/customers.txt"), listOfCustomers);
        customerList.readCustomerFileAndCreateCustomerList();
        String userInput = "";

        Scanner in = new Scanner(System.in);
        System.out.print("Skriv in kundens namn eller personnummer: ");

        try {
            userInput = in.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Felaktig inmatning!");
            takeUserInputAndCallMethods();
        }

        userInput = userInput.trim();

        boolean customerIsInList = customerList.checkIfCustomerIsInList(userInput);

        if (customerIsInList) {
            int index = CustomerList.getIndex();
            String dateTheCustomerPaid = listOfCustomers.get(index + 1);
            boolean customerHasPaid = ValidateCostumer.hasCustomerHasPaidInTheLastYear(dateTheCustomerPaid);
            if (customerHasPaid) {
                System.out.println("Kunden har betalat");
                SaveTrainingCustomer.saveTrainingCustomer(index, listOfCustomers);
            } else {
                System.out.println("Kunden har ej betalat");
            }

        } else {
            System.out.println("Personen har ej tränat här tidigare!");
        }
        takeUserInputAndCallMethods();
    }
}
