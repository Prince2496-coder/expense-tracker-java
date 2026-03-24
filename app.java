import java.util.*;

class Expense {
  double amount;
  String category;
  String description;

  public Expense(double amount, String category, String description) {
    this.amount = amount;
    this.category = category;
    this.description = description;
  }
}

public class app {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Expense> list = new ArrayList<>();
    while (true) {
      System.out.println("\n===== MENU =====");
      System.out.println("1. Add Expense");
      System.out.println("2. View Expense");
      System.out.println("3. Total Expense");
      System.out.println("4. Filter by Category");
      System.out.println("5. Exit");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.println("\nEnter amount");
          double amount = sc.nextDouble();
          sc.nextLine();

          System.out.println("Enter category");
          String category = sc.nextLine();

          System.out.println("Enter discription");
          String description = sc.nextLine();
          list.add(new Expense(amount, category, description));
          System.out.println("----------------------");

          break;

        case 2:
          if (list.isEmpty()) {
            System.out.println("No expenses added yet");
          } else {

            for (Expense e : list) {
              System.out
                  .println("Amount : " + e.amount + " Category : " + e.category + "  Description : " + e.description);
            }
          }
          System.out.println("----------------------");
          break;

        case 3:
          if (list.isEmpty()) {
            System.out.println("No expenses to calculate");
          } else {
            double total = 0;
            for (Expense e : list) {
              total += e.amount;
            }
            System.out.println("Total Amount: " + total);
          }
          System.out.println("----------------------");
          break;

        case 4:
          System.out.println("Enter category you want to filter:");
          String filter = sc.nextLine();

          boolean found = false;

          for (Expense e : list) {
            if (e.category.equalsIgnoreCase(filter)) {
              System.out.println("Amount: " + e.amount +
                  " Category: " + e.category +
                  " Description: " + e.description);
              found = true;
            }
          }

          if (!found) {
            System.out.println("No expense found for category: " + filter);
          }
          System.out.println("----------------------");

          break;
        case 5:
          System.out.println("Exiting..");
          System.out.println("----------------------");

          return;

        default:
          System.out.println("Invalid choice. Please try again.");
          System.out.println("----------------------");

      }
    }
  }
}