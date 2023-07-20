package com.kanakM.ToDo.App.Controller;

import com.kanakM.ToDo.App.Entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<Todo> myTodos;

    public TodoController() {
        myTodos = new ArrayList<>();
    }

    @GetMapping("todos")
    public List<Todo> getAllTodos()
    {
        return myTodos;
    }

    @GetMapping("todo/done")
    public List<Todo> getDoneTodos()
    {
        List<Todo> doneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos){
            if(myTodo.isTodoDoneStatus()){
                doneTodos.add(myTodo);
            }
        }
        return doneTodos;
    }

    @GetMapping("todo/undone")
    public List<Todo> getUndoneTodos()
    {
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos){
            if(!myTodo.isTodoDoneStatus()){
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
        myTodos.add(todo);
        return "Todo Added";
    }

    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status){

        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodo.setTodoDoneStatus(status);
                return "Todo updated for todo ID: " + todoId;
            }
        }
        return "Todo not found for todo ID: " + todoId;
    }

    @DeleteMapping("todo")
    public String removeTodo(@RequestParam Integer todoId){
        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodos.remove(myTodo);
                return "Todo removed for todo ID: " + todoId;
            }
        }
        return "Todo : " + todoId + " not deleted as doesn't Exist";
    }
}
