package ru.neoflex.vacationcalculator.service.pay;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayCountService {

    public BigDecimal countVacationPay(BigDecimal avgSalary, int vacationDaysAmount) {

        double MONTH_AVG_DAYS = 29.3;
        BigDecimal dailySalary = avgSalary.divide(BigDecimal.valueOf(MONTH_AVG_DAYS), 2, RoundingMode.HALF_EVEN);

        BigDecimal totalVacationPay = dailySalary.multiply(BigDecimal.valueOf(vacationDaysAmount));

        return totalVacationPay;
    }
}
