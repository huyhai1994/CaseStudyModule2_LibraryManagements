package library.user;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    public Admin(String name, String email, String phoneNumber, String role) {
        super(name, email, phoneNumber, role);
    }

    @Override
    public String toString() {
        return this.getName() + " " +
                this.getEmail() + " " +
                this.getPhoneNumber() + " " +
                this.role;

    }

    @Override
    public void menu() {
        System.out.println("Here is Admin menu");
        System.out.println("-------------------");
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search Books");
        System.out.println("5. Delete all data");
        System.out.println("6. View orders");
        System.out.println("7. Exit");

    }

}
