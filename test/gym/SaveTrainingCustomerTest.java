package gym;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

class SaveTrainingCustomerTest {

    @Test
    void saveTrainingCustomer() {
        Main.testMode = true;
        ArrayList<String> testList = new ArrayList<>();
        CustomerList test = new CustomerList(new File("test/testList.txt"), testList);

        test.readCustomerFileAndCreateCustomerList();
        SaveTrainingCustomer.saveTrainingCustomer(0, testList);

        ArrayList<String> testListOfTrainingCustomers = new ArrayList<>();
        CustomerList trainingCustomersListTest = new CustomerList(new File("test/trainingCustomersTest.txt"),
                testListOfTrainingCustomers);
        trainingCustomersListTest.readCustomerFileAndCreateCustomerList();

        ArrayList<String> comparisonList = new ArrayList<>();
        comparisonList.add("7903111234, John Doe");
        comparisonList.add(LocalDate.now().toString());

        assert (trainingCustomersListTest.getCustomerList().equals(comparisonList));

    }

}