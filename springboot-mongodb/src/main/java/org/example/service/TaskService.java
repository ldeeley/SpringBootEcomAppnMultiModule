package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    TaskRepository taskRepository;

    public Task saveTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(String taskId){
        return taskRepository.findById(taskId).get();
    }

    public Task updateTask(Task task,String taskId){
        Task updatedTask = taskRepository.findById(taskId).get();
        updatedTask.setDescription(task.getDescription());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setStoryPoint(task.getStoryPoint());
        updatedTask.setAssignee(task.getAssignee());
        return taskRepository.save(updatedTask);
    }

    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return "Task deleted "+taskId;
    }



}
