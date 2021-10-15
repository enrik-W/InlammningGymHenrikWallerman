package gym;

import java.time.LocalDate;
import java.time.Period;

public class ValidateCostumer {
    public static boolean hasCustomerHasPaidInTheLastYear(String timeTheCustomerPaid) {
        LocalDate currentTime;
        if (Main.testMode) {
            currentTime = LocalDate.parse("2021-10-01");
        } else {
            currentTime = LocalDate.now();
        }

        int numberOfYears;
        Period periodSincePayment;

        LocalDate dateTheCustomerPaid = LocalDate.parse(timeTheCustomerPaid);
        periodSincePayment = Period.between(currentTime, dateTheCustomerPaid);
        numberOfYears = periodSincePayment.getYears();

        return numberOfYears >= 0;
    }

}
