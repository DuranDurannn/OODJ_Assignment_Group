public class User {
    
    private String id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private String accessLevel;

    // Getters
    public String getID() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
    
    public String getAccessLevel() {
        return accessLevel;
    }
    
    // Setters
    public void setID(String id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}