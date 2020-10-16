package se.flyingpenguin;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class TrainingLogs {

    public static boolean personNummerValidation(String input2) {
        boolean numeric = true;

        try {
            int num = Integer.parseInt(input2);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if (input2.length() == 10 && numeric == true) {
            return true;

        } else {
            return false;
        }
    }

    public static void registerTrainee() {

        String input = JOptionPane.showInputDialog("Enter trainee name");
        String input2 = JOptionPane.showInputDialog("Enter personal number 10 digits");

        if (personNummerValidation(input2) == true) {
            try (PrintWriter trainer = new PrintWriter(new FileWriter("trainings.txt", true))) {
                trainer.println(input);
                trainer.println(input2);
                trainer.println(LocalDate.now().toString());

                JOptionPane.showMessageDialog(null, "The log has been saved");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong format");
        }
    }
}


