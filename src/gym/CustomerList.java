package gym;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CustomerList {
    private final File fileName;
    private final ArrayList<String> customerList;
    private static int index;

    public CustomerList(File fileName, ArrayList<String> customerList) {
        this.fileName = fileName;
        this.customerList = customerList;
    }

    public void readCustomerFileAndCreateCustomerList() {
        String Line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.fileName));
            while ((Line = in.readLine()) != null) {
                this.customerList.add(Line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kunde inte läsa filen!");
        }

    }

    public boolean checkIfCustomerIsInList(String userInput) {
        for (index = 0; index < customerList.size(); index++) {
            if ((customerList.get(index).contains(userInput))) {
                setIndex(index);
                return true;
            }
        }
        return false;
    }

    public ArrayList getCustomerList() {
        return this.customerList;
    }

    public static void setIndex(int i) {
        index = i;
    }

    public static int getIndex() {
        return index;
    }

}
