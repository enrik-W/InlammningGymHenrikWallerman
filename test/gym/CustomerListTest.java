package gym;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerListTest {

    @Test
    void createCustomerList() {
        ArrayList<String> testCustomerList1 = new ArrayList<>();
        CustomerList testList1 = new CustomerList(new File("test/testList.txt"), testCustomerList1);
        ArrayList<String> comparisonList = new ArrayList<>();
        comparisonList.add("7903111234, John Doe");
        comparisonList.add("2021-06-22");
        comparisonList.add("6811035678, Jane Doe");
        comparisonList.add("2018-10-07");

        testList1.readCustomerFileAndCreateCustomerList();
        assertEquals(testList1.getCustomerList(), comparisonList);
    }

    @Test
    void checkIfCustomerIsInList() {
        ArrayList<String> testCustomerList2 = new ArrayList<>();
        CustomerList testList2 = new CustomerList(new File("test/testList.txt"), testCustomerList2);

        testList2.readCustomerFileAndCreateCustomerList();
        assertTrue(testList2.checkIfCustomerIsInList("John Doe"));
        assertFalse(testList2.checkIfCustomerIsInList("Henrik Wallerman"));
    }
}