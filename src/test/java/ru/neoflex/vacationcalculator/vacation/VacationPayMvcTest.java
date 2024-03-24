package ru.neoflex.vacationcalculator.vacation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class VacationPayMvcTest {

    public static final String VACATION_PAY_CALCULATION_ENDPOINT = "/calculate";

    @Autowired
    MockMvc mock;

    @Test
    void calculateVacationPayWithoutDateFrom() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .get(VACATION_PAY_CALCULATION_ENDPOINT)
                        .param("avg_salary", "35000.00")
                        .param("vacation_days_amount", "14")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.vacationPay").value(16723.56))
                .andReturn();
    }

    @Test
    void calculateVacationPayWithDateFrom() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .get(VACATION_PAY_CALCULATION_ENDPOINT)
                        .param("avg_salary", "35000.00")
                        .param("vacation_days_amount", "14")
                        .param("vacation_date_from", "2024-02-12")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.vacationPay").value(10750.86))
                .andReturn();
    }
}
