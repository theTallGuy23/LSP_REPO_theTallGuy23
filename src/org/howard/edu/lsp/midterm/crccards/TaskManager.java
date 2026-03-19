package org.howard.edu.lsp.midterm.crccards;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Manages a collection of Task objects.
 * Provides functionality to add, find, and filter tasks.
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager with an empty task collection.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws IllegalArgumentException if a duplicate task ID is detected.
     *
     * @param task the task to be added
     * @throws IllegalArgumentException if a task with the same ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its task ID.
     *
     * @param taskId the ID of the task to find
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns a list of tasks that match the specified status.
     *
     * @param status the status to filter tasks by
     * @return a list of tasks with the given status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}
