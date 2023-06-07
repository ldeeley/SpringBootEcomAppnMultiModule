package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public Task addNewTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping
    public List<Task> findAllTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task findTaskById(@PathVariable String taskId){
        return taskService.getTask(taskId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@RequestBody Task taskUpdate, @PathVariable String taskId){
        return taskService.updateTask(taskUpdate,taskId);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }

}
