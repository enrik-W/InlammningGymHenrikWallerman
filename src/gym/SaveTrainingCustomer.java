package gym;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class SaveTrainingCustomer {
    private static ArrayList<String> trainingCustomers = new ArrayList<>();

    public static void saveTrainingCustomer(int index, ArrayList customerList) {
        Path listOfTrainingCustomers;

        if (Main.testMode) {
            listOfTrainingCustomers = Paths.get("test/trainingCustomersTest.txt");
        } else {
            listOfTrainingCustomers = Paths.get("src/trainingCustomers.txt");
        }
        trainingCustomers.add(customerList.get(index).toString());
        trainingCustomers.add(LocalDate.now().toString());
        BufferedWriter buffWriter = null;
        try {
            buffWriter = Files.newBufferedWriter(listOfTrainingCustomers, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (String trainingCustomer : trainingCustomers) {
                buffWriter.write(trainingCustomer);
                buffWriter.newLine();

            }

            buffWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
