package yoyo.application;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditProfile {

    private ArrayList<String[]> userInfo;
    private String editUsernameInput;
    private String editGenderInput;
    private String editEmailInput;
    private String editPhoneInput;
    private String editAddressInput;
    private String editPasswordInput;
    private String editCurrentPasswordInput;

    public void setUserInfo(ArrayList<String[]> userInfo) {
        this.userInfo = userInfo;
    }

    public void setEditUsernameInput(String editUsernameInput) {
        this.editUsernameInput = editUsernameInput;
    }

    public void setEditGenderInput(String editGenderInput) {
        this.editGenderInput = editGenderInput.toLowerCase();
    }

    public void setEditEmailInput(String editEmailInput) {
        this.editEmailInput = editEmailInput;
    }

    public void setEditPhoneInput(String editPhoneInput) {
        this.editPhoneInput = editPhoneInput;
    }

    public void setEditAddressInput(String editAddressInput) {
        this.editAddressInput = editAddressInput;
    }

    public void setEditPasswordInput(String editPasswordInput) {
        this.editPasswordInput = editPasswordInput;
    }

    public void setEditConfirmPasswordInput(String editCurrentPasswordInput) {
        this.editCurrentPasswordInput = editCurrentPasswordInput;
    }

    public User editCheck() {
        User editUser = new User();
        boolean found = false;

        if (editUsernameInput.isEmpty() || editGenderInput.isEmpty()
                || editEmailInput.isEmpty() || editPhoneInput.isEmpty()
                || editAddressInput.isEmpty() || editPasswordInput.isEmpty()
                || editCurrentPasswordInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (editUsernameInput.contains("!") || editGenderInput.contains("!")
                || editEmailInput.contains("!") || editPhoneInput.contains("!")
                || editAddressInput.contains("!") || editPasswordInput.contains("!")
                || editCurrentPasswordInput.contains("!")) {
            JOptionPane.showMessageDialog(null, "Exclamation marks are not allowed in any input field.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!editGenderInput.equals("male") && !editGenderInput.equals("female")) {
            JOptionPane.showMessageDialog(null, "Invalid gender input. Please enter 'male' or 'female'.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!editEmailInput.contains("@")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!editPhoneInput.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter only numeric digits.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!editAddressInput.matches(
                "^"
                + // Start of string
                "\\d+\\s+[\\w\\s]+,"
                + // House number (digits) followed by space, Street name (words and spaces) followed by a comma
                "\\s+[\\w\\s]+,"
                + // Area/locality (words and spaces) followed by a comma
                "\\s+\\d{5}\\s+[\\w\\s]+,"
                + // Postal code (5 digits) followed by space, City/state/country (words and spaces) followed by a comma
                "\\s+[\\w\\s]+"
                + // Additional city/state/country (words and spaces)
                "$" // End of string
        )) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid address format. Please follow the example: 15 Persiaran Gurney, Georgetown, 10250 Pulau Pinang, Malaysia",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        for (int i = 0; i < userInfo.size(); i++) {
            String[] userValues = userInfo.get(i);
            editUser.setID(userValues[0]);

            if (userValues[0].equals(editUser.getID()) && userValues[2].equals(editCurrentPasswordInput)) {
                found = true;
                editUser.setUsername(editUsernameInput);
                editUser.setPassword(editPasswordInput); // Assuming password can be stored in plain text, update if needed
                editUser.setEmail(editEmailInput);
                editUser.setAddress(editAddressInput);
                editUser.setPhoneNumber(editPhoneInput);
                editUser.setGender(editGenderInput);
                editUser.setProfileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s");

                userInfo.set(i, new String[]{editUser.getID(), editUser.getUsername(), editUser.getPassword(), editUser.getEmail(), editUser.getAddress(), editUser.getPhoneNumber(), editUser.getGender(), editUser.getProfileLink()});

                System.out.println("User information updated successfully.");
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "User ID or current password is incorrect.", "Edit Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("edutUserID: " + editUser.getID());
            return null;
        }

        SecureFileHandler fileHandler = new SecureFileHandler();

        // Clear the contents of the file
        try {
            fileHandler.clearFile("userInfo.txt");
        } catch (IOException e) {
            System.err.println("Error clearing file: " + e.getMessage());
        }

        System.out.println(userInfo);

        // Write updated user information to the file
        for (String[] userValues : userInfo) {
            String dataLine = userValues[0] + "!" + userValues[1] + "!"
                    + userValues[2] + "!" + userValues[3] + "!"
                    + userValues[4] + "!" + userValues[5] + "!"
                    + userValues[6] + "!" + userValues[7];

            try {
                fileHandler.appendEncryptedLine("userInfo.txt", dataLine, "Your16CharKey123");

            } catch (IOException e) {
                System.err.println("Error writing data to file: " + e.getMessage());
            }

            System.out.println("formattedUserId = " + dataLine);
            System.out.println("ID: " + editUser.getID());
            System.out.println("Username: " + editUser.getUsername());
            System.out.println("Password: " + editUser.getPassword());
            System.out.println("Email: " + editUser.getEmail());
            System.out.println("Address: " + editUser.getAddress());
            System.out.println("Phone Number: " + editUser.getPhoneNumber());
            System.out.println("Gender: " + editUser.getGender());
            System.out.println("Profile Link: " + editUser.getProfileLink());
        }

        return editUser;
    }
}
