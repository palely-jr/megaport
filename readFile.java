import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class readFile{
	public static void main(String[] args) throws IOException{
		try (Scanner file = new Scanner(System.in)) {
            System.out.println("Enter file path");
            //Reads the file
            String fileDirectory = file.nextLine();  // Read user input
            File tempFile = new File(fileDirectory);
           

           
           //Checks if the file exists
           while(!tempFile.exists()){
               System.out.println("File Doesn't exist");
               System.out.println("Enter file path again");
           
               fileDirectory = file.nextLine();
               tempFile = new File(fileDirectory);
           }
           
           //Reads the file
            BufferedReader initialFile = new BufferedReader(new FileReader(fileDirectory));
           
            //Convert the file into array
            ArrayList<String> fileArray = new ArrayList<>();
            String line = "";
            while((line=initialFile.readLine())!=null){
                fileArray.add(line);
            }
            initialFile.close();
            //Sort the collection
            Collections.sort(fileArray);
            FileWriter writer = new FileWriter("sortedNames.txt");
            for(String s: fileArray){
            		writer.write(s);
            		writer.write("\r\n");
            }
            writer.close();
            System.out.println("New File Written");
        } catch (Exception e) {
            System.out.println("Error is"+e);
}
}
}