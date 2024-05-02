package library;
import java.io.File;
import java.io.IOException;
import library.database.DataBase;
import library.order.Order;
public class test {
    public static void main(String[] args) throws IOException {
        String ORDERS_FILE_PATH = "database/orders.txt";
        File file = new File(ORDERS_FILE_PATH);
        boolean isFileExist = file.exists();
        boolean isFileNotExist = !isFileExist;
        if (isFileNotExist) {
            file.createNewFile();
        }
        System.out.println(" file exist = " + file.exists());
        System.out.println(" file can write = " + file.canWrite());
        System.out.println(" file can read = " + file.canRead());
        DataBase dataBase = new DataBase();
        // Order order = new Order(null, null, 0, 0);
        // dataBase.addOrder(order);
        dataBase.writeOrderInformationToFile();
        dataBase.readBookInformationsFromFile();
        dataBase.showOrders();
    }
}
