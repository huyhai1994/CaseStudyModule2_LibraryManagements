package library;

public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.operations = new IOOperation[] {
                new ViewBooks(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }

    public Admin(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.operations = new IOOperation[] {
                new ViewBooks(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }

    @Override
    public void menu() {
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search Books");
        System.out.println("5. Delete all data");
        System.out.println("6. View Orders");
        System.out.println("7. Exit");
    }
}
