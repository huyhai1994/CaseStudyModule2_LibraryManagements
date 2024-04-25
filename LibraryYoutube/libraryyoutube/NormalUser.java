import java.util.Scanner;

public class NormalUser extends User {
    protected IOOperation[] operations;

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[] {
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    public NormalUser(String name,
            String email,
            String phoneNumber) {
        super(name, email, phoneNumber);
        this.operations = new IOOperation[] {
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    @Override
    public void menu(DataBase database, User user) {
        System.out.println("1. View Books");
        System.out.println("2. Search Books");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
        Scanner scanner = new Scanner(System.in);
        int normalUserChoice = scanner.nextInt();
        this.operations[normalUserChoice - 1].oper(database, user);
        scanner.close();
    }
}
