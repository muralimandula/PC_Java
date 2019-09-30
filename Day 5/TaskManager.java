class TaskManager {
    Task[] tasksArr;
    int size;

    TaskManager() {
        this.tasksArr = new Task[500];
        this.size = 0;
    }

    public void addTask(Task task) {
        tasksArr[size] = task;
        size++;
    }

    public void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(tasksArr[i].displayTask());
        }
        System.out.println();
    }

    public void displayTaskNames() {    
        for(int i = 0; i < size; i++) {
            System.out.println(i+1 + " " + tasksArr[i].displayTask());
        }
        System.out.println();
    }


    public String removeTask(final int taskIndex) {

        if (taskIndex == 0) {
            return "Cancelled removing Task";
        }

        int i = taskIndex - 1;

        for (int j = i + 1; j < size; j++) {
            tasksArr[i] = tasksArr[j];
            i++;
        }
        tasksArr[size] = null;
        size--;
        return "Task removed...... with the name " + tasksArr[taskIndex - 1].getTaskName();
    }


    public String updateTask(final int taskIndex, final String status) {
        if (taskIndex == 0) {
            return "Cancelled.";
        }
        tasksArr[taskIndex - 1].setStatus(status);
        return "updated successfully";
    }

    public void displayAllPendingIncomplete() {

        int pending = 0;
        for (int i = 0; i < size; i++) {
            if (!(tasksArr[i].getStatus().equals("complete"))) {
                pending++;
                System.out.println(tasksArr[i].displayTask());
            }
        }
        if (pending == 0) {
            System.out.println("No Pending/Incomplete found");
        }
    }


    public void displayOnDate(String date) {
        for (Task var : tasksArr) {
            if (var.getDueDate() == date) {
                System.out.println(var.displayTask());
            }
        }
    }
    


}