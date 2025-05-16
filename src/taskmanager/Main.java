package taskmanager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Task Management App!");
        while (true) {
            // Show menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Insert Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Insert task
                    System.out.println("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    System.out.println("Enter task status: ");
                    String taskStatus = scanner.nextLine();
                    TaskDAO.insertTask(taskName, taskDescription, taskStatus);
                    break;

                case 2:
                    // Read tasks
                    TaskDAO.readTasks();
                    break;

                case 3:
                    // Update task
                    System.out.println("Enter task ID to update: ");
                    int taskIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new task name: ");
                    String newTaskName = scanner.nextLine();
                    System.out.println("Enter new task description: ");
                    String newTaskDescription = scanner.nextLine();
                    System.out.println("Enter new task status: ");
                    String newTaskStatus = scanner.nextLine();
                    TaskDAO.updateTask(taskIdToUpdate, newTaskName, newTaskDescription, newTaskStatus);
                    break;

                case 4:
                    // Delete task
                    System.out.println("Enter task ID to delete: ");
                    int taskIdToDelete = scanner.nextInt();
                    TaskDAO.deleteTask(taskIdToDelete);
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
