## Калькулятор отпускных  ##
Данный проект предназначен для вступительных испытаний УЦ Neoflex 2024.
В данном проекте реализован один API: `/calculate`.
При его использовании есть возможность передать следующие параметры:
* avg_salary - средняя зарплата за 12 мес
* vacation_days_amount - количество дней отпуска
* vacation_date_from - дата ухода в отпуск (необязательный параметр)  
### Postman ###
Ниже представлены варианты запросов из *Postman*  
#### С указанием даты ухода в отпуск:  ####
http://localhost:8080/calculate?avg_salary=30000&vacation_days_amount=14&vacation_date_from=2024-03-27    

![image](https://github.com/dfilippov02/vacation-pay-calculator/assets/164752579/18df6fc9-4d68-415a-b22b-1dcb52f9fd8b)

#### Без указания даты ухода в отпуск:  ####
http://localhost:8080/calculate?avg_salary=30000&vacation_days_amount=14&vacation_date_from=2024-03-27    

![image](https://github.com/dfilippov02/vacation-pay-calculator/assets/164752579/ab79c940-48d8-4a90-9628-fce75fc43634)

