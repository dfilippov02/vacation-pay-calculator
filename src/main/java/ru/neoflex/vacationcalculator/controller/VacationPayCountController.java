package ru.neoflex.vacationcalculator.controller;

import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacationcalculator.dto.VacationPayResponse;
import ru.neoflex.vacationcalculator.service.days.VacationDaysCountService;
import ru.neoflex.vacationcalculator.service.pay.VacationPayCountService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@Validated
public class VacationPayCountController {

    VacationPayCountService countService;
    VacationDaysCountService daysCountService;

    public VacationPayCountController(VacationPayCountService countService, VacationDaysCountService daysCountService) {
        this.countService = countService;
        this.daysCountService = daysCountService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculateVacation(@RequestParam(value = "avg_salary") @Min(0) BigDecimal avgSalary,
                                               @RequestParam(value = "vacation_days_amount") @Min(0) int vacationDaysAmount,
                                               @RequestParam(value = "vacation_date_from", required = false) LocalDate dateFrom) {
        if(dateFrom!=null) {
            vacationDaysAmount = daysCountService.calculateVacationPaidDays(dateFrom, vacationDaysAmount);
        }
        return ResponseEntity.ok(new VacationPayResponse(countService.countVacationPay(avgSalary, vacationDaysAmount)));

    }
}
