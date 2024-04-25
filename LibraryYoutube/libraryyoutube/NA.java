import java.io.File;
import java.io.FileWriter;

public class NA {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("a.txt");
        fileWriter.write("Files in Java might be tricky, but it is fun enough!\n");
        fileWriter.write("Xin Chaoo\n");
        fileWriter.write("Tooi la hai");
        fileWriter.close();
        File folder = new File("newFolder");
        folder.mkdirs();
    }
}
