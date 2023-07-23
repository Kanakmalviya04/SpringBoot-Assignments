package com.kanakM.Expensetracker.service;

import com.kanakM.Expensetracker.Expense;
import com.kanakM.Expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        // Additional validation and business logic can be added here
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByDateAndTime(Long userId, LocalDate date, LocalTime time) {
        if (time != null) {
            return expenseRepository.findByUserIdAndDateAndTime(userId, date, time);
        } else {
            return expenseRepository.findByUserIdAndDate(userId, date);
        }
    }

    // Implement methods for updating, deleting expenses, and generating reports here
}
