package se.flyingpenguin;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberCheck {


    public static String status(String payment) {
        LocalDate currentDate = LocalDate.now();
        LocalDate paymentDate = LocalDate.parse(payment);
        Period period = Period.between(currentDate, paymentDate);//method that creates object period

        String statusResult;
        if (period.getDays() <= 365) {
            statusResult = "Current member";
        } else {
            statusResult = "Former member";
        }
        return statusResult;
    }


    public static void checkMemberStatus() {
        String input = JOptionPane.showInputDialog("Enter your name or personal number 10 digits");
        File customers = new File("customers.txt");

        List<String> foundMember = new ArrayList<>();

        try {
            Scanner memberReader = new Scanner(customers);

            while (memberReader.hasNextLine()) {
                String line = memberReader.nextLine();
                if (line.contains(input)) {
                    String payment = memberReader.nextLine();
                    foundMember.add(line + "/" + status(payment));
                }
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The file is not found");
        }

        if (foundMember.isEmpty()) {
            JOptionPane.showMessageDialog(null, "This person is not a member");
        } else {
            JOptionPane.showMessageDialog(null, foundMember);
        }


    }
}
