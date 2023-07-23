package com.kanakM.Expensetracker.repository;

import com.kanakM.Expensetracker.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserIdAndDate(Long userId, LocalDate date);

    List<Expense> findByUserIdAndDateAndTime(Long userId, LocalDate date, LocalTime time);
}
