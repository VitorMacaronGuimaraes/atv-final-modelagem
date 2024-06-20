import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DonationManager manager = new DonationManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Donation");
            System.out.println("2. Calculate Total Donations");
            System.out.println("3. Save Donations to File");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline
            
            switch (choice) {
                case 1:
                    System.out.println("Enter donation type:");
                    String type = scanner.nextLine();
                    
                    System.out.println("Enter donation amount:");
                    double amount = scanner.nextDouble();
                    
                    System.out.println("Enter donation date (YYYY-MM-DD):");
                    String dateInput = scanner.next();
                    LocalDate date = LocalDate.parse(dateInput);
                    
                    Donation donation = new Donation(type, amount, date);
                    manager.addDonation(donation);
                    System.out.println("Donation added successfully.");
                    break;
                
                case 2:
                    double total = manager.calculateTotalDonations();
                    System.out.println("Total Donations: " + total);
                    break;
                
                case 3:
                    System.out.println("Enter filename to save donations:");
                    String filename = scanner.next();
                    manager.saveDonationsToFile(filename);
                    System.out.println("Donations saved successfully.");
                    break;
                
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
