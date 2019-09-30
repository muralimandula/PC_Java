import java.text.SimpleDateFormat;
import java.util.*;

class Main {
    public static void main(String[] args) {

        TaskManager tm = new TaskManager();
        Scanner scan = new Scanner(System.in);

        System.out.println(" Welcome to toDo list taskManager!! \n");

        boolean flag = true;
        do {
            System.out.println("1. ADD\t2. REMOVE\t3. UPDATE\t4. DISPLAY ALL\t5. DISPLAY PENDING\t6. DISPLAY BY DATE\t7. EXIT");

            String choice = scan.nextLine();            
            switch (choice) {

                case "1":
                    System.out.print("Enter the name of task \t : ");
                    String t = scan.nextLine();

                    System.out.print("Enter task description \t : ");
                    String d = scan.nextLine();

                    /**
                     * Date 
                     */
                    System.out.print("Enter Due Date(dd/mm/yyyy) \t : ");
                    String dd = scan.nextLine();
                    Date inputDate = parseDate(dd);

                    if (inputDate != null){
                        System.out.print("Enter the Status \t : ");
                        String s = scan.nextLine();
                        Task toAdd = new Task(t, d, inputDate, s);
                        tm.addTask(toAdd);
                    } else {
                        System.out.println("Invalid Date format.");
                    }
 
                    break;

                case "2":
                    tm.displayTaskNames();
                    System.out.print("Please enter the task number to be deleted/removed  or 0 to CANCEL. ");
                    int taskNameIndex = Integer.parseInt(scan.nextLine());

                    System.out.println(tm.removeTask(taskNameIndex));
                    break;
                
                case "3":
                    tm.displayTaskNames();
                    System.out.print("Please enter the task number to be updated  or 0 to CANCEL. ");
                    int taskIndex = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the new status : ");
                    String status = scan.nextLine();
                    tm.updateTask(taskIndex, status);
                    break;
                    
                case "4":
                    tm.displayAll();
                    break;

                case "5":
                    tm.displayAllPendingIncomplete();
                    break;

                case "6":
                    System.out.println("Enter the date(dd/mm/yyyy) : ");
                    String dd2 = scan.nextLine();
                    Date inputDate2 = parseDate(dd2);
                    tm.displayOnDate(inputDate2);

                    break;
                    
                case "7":
                    flag = false;
                default:
                    break;
            }
        } while(flag);



        scan.close();
    }


    public static Date parseDate(String dateString) {

        String[] dates = dateString.split("/");
        try {
            Date inputDate = new Date(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));
            return inputDate;
            
        } catch (Exception e) {
            System.out.println("Invalid Date");
            return null;
        }
        
    }
}