package library.user;

public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public NormalUser(String name, String email, String phoneNumber, String role) {
        super(name, email, phoneNumber, role);
    }

    @Override
    public String toString() {
        return this.getName() + " " + 
                this.getEmail() + " "+
                this.getPhoneNumber()+" "+
                this.role;
    }

    @Override
    public void menu() {

        System.out.println("Here is normal user menu");
        System.out.println("------------------------");
        System.out.println("1. View Books");
        System.out.println("2. Search Book");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

    }

}
