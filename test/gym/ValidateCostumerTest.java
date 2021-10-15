package gym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCostumerTest {

    @Test
    void hasCustomerHasPaidInTheLastYear() {
        Main.testMode = true;
        assertTrue(ValidateCostumer.hasCustomerHasPaidInTheLastYear("2021-04-03"));
        assertFalse(ValidateCostumer.hasCustomerHasPaidInTheLastYear("2019-04-03"));
    }

}