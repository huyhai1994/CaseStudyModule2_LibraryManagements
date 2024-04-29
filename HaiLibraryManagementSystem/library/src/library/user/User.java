package library.user;

public abstract class User{
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String role;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String phoneNumber, String email, String role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   @Override
    public abstract String toString();

    public abstract void menu();

    public String getPassword() {
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
    
    
}
