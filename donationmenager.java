import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private List<Donation> donations;

    public DonationManager() {
        this.donations = new ArrayList<>();
    }

    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    public double calculateTotalDonations() {
        return donations.stream().mapToDouble(Donation::getAmount).sum();
    }

    public void saveDonationsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Donation donation : donations) {
                writer.write(donation.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Donation> getDonations() {
        return donations;
    }
}
