package se.flyingpenguin;

import javax.swing.*;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        String[] choices = {"Check member status", "Register trainee", "Exit"};

        Object selectedChoice = JOptionPane.showInputDialog(null, "What would  you like to do?", "Selection", JOptionPane.DEFAULT_OPTION, null, choices, "0");
        if (selectedChoice != null) {//if user clicks cancel or x code runs down and theres nothing there
            String selectedString = selectedChoice.toString();//convert object to a string
            switch (selectedString) {
                case "Check member status":
                    MemberCheck.checkMemberStatus();
                    break;
                case "Register trainee":
                    TrainingLogs.registerTrainee();
                    break;

                case "Exit":

            }
        }
    }
}
