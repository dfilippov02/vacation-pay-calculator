package ru.neoflex.vacationcalculator.service.days;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationDaysCountService {

    private static final int CURRENT_YEAR = LocalDate.now().getYear();

    private static final List<LocalDate> holidays = List.of(
            LocalDate.of(CURRENT_YEAR, 1, 1 ),
            LocalDate.of(CURRENT_YEAR, 1, 2 ),
            LocalDate.of(CURRENT_YEAR, 1, 3 ),
            LocalDate.of(CURRENT_YEAR, 1, 4 ),
            LocalDate.of(CURRENT_YEAR, 1, 5 ),
            LocalDate.of(CURRENT_YEAR, 1, 6 ),
            LocalDate.of(CURRENT_YEAR, 1, 7 ),
            LocalDate.of(CURRENT_YEAR, 1, 8 ),
            LocalDate.of(CURRENT_YEAR, 2, 23),
            LocalDate.of(CURRENT_YEAR, 3, 8 ),
            LocalDate.of(CURRENT_YEAR, 5, 1 ),
            LocalDate.of(CURRENT_YEAR, 5, 9 )
    );

    private static final List<DayOfWeek> weekends = List.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    /**
     * Расчет числа оплачиваемых дней с определенной даты
     * @param fromDate - дата, с которой начинается отсчет
     * @param daysAmount - количество дней отпуска
     * @return - количество оплавичаемых дней отпуска
     */
    public int calculateVacationPaidDays(LocalDate fromDate, int daysAmount) {

        // хотелось бы больше конкретики как именно должен производиться расчет с учетом выходных и праздников.
        // здесь предполагается, что выходные и праздники исключаются из числа оплачиваемых дней.

        List<LocalDate> dates = fromDate.datesUntil(fromDate.plusDays(daysAmount))
                .filter(d -> !(holidays.contains(d) || weekends.contains(d.getDayOfWeek())))
                .collect(Collectors.toList());

        return dates.size();
    }
}
