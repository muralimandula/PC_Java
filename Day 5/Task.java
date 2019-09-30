import java.text.SimpleDateFormat;
import java.util.Date;

class Task {
    private String taskName;
    private String description;
    private Date dueDate;
    private String status;

    
    Task(final String t, final String d, final Date dd, final String s) {
        this.taskName = t;
        this.description = d;
        this.dueDate = dd;
        this.status = s.toLowerCase();
    }

    public String displayTask() {
        return this.taskName + "\t" +  this.description + "\t" +  (this.dueDate.toString()).substring(0,10) + "\t" +  this.status ;
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

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}