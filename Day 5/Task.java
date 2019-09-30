class Task {
    private String taskName;
    private String description;
    private String dueDate;
    private String status;

    
    Task(final String t, final String d, final String dd, final String s) {
        this.taskName = t;
        this.description = d;
        this.dueDate = dd;
        this.status = s.toLowerCase();
    }

    public String displayTask() {
        return this.taskName + "\t" +  this.description + "\t" +  this.dueDate + "\t" +  this.status ;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}