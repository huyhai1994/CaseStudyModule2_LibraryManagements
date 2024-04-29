package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {
   public static void main(String[] args) throws IOException {
    try{
        File file = new File("src/library/database/users.txt");
        file.createNewFile();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    
    // try {
    //     FileWriter fileWriter = new FileWriter(file);
    //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    //     bufferedWriter.write("11222");
    //     bufferedWriter.close();
    //  } catch (IOException e) {
    //     e.printStackTrace();
    // }
}
}
