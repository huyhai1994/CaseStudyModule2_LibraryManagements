package library.user;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }
    public NormalUser(String name, String email, String phoneNumber, String role){
        super(name, email, phoneNumber, role);    
    }
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
    @Override
    public void menu() {

        System.out.println("Here is normal user menu"); 
    }    

}
