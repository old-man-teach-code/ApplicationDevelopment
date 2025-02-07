package com.example.greatetodolist;

public class Task {


    public String taskName; // tên của công việc
    public String taskDescription; // mô tả công việc
    public boolean isCompleted; // Trạng thái công việc (đã hoàn thành hay chưa)
    public int taskPriority; // độ ưu tiên công việc (1-5)

    public Task(String taskName, String taskDescription, boolean isCompleted, int taskPriority)
    {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isCompleted = isCompleted;
        this.taskPriority = taskPriority;
    }
}