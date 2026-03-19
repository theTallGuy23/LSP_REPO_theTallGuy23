package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task in the Task Management System.
 * Stores task information and allows updating task status.
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with a given ID and description.
     * Default status is set to "OPEN".
     *
     * @param taskId the unique identifier of the task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * Valid values: OPEN, IN_PROGRESS, COMPLETE.
     * If an invalid value is provided, status is set to "UNKNOWN".
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task.
     * Format: taskId description [status]
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
