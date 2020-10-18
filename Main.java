import java.io.File;    
import java.util.Scanner; 

public class Main {

    public static void main(String[] args) {
        try {
          File myObj = new File("sample-text1.txt");
          Scanner myReader = new Scanner(myObj);
          String line[];
          HashTableImp hashtable=new HashTableImp(100);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            line=data.split(" ");
            for (String str : line) {
                str=str.replace(",", "").replace(";", "").replace(".", "").replace(":", "");
                hashtable.insert(str);
            }
          }
          myReader.close();
          System.out.println("Count of who  " +hashtable.search("who"));
          System.out.println("average keys of bucket "+hashtable.average());
          System.out.println("min keys of bucket "+hashtable.min());
          System.out.println("max keys of bucket "+hashtable.max());
          System.out.println("STD keys of bucket "+hashtable.standDV());
        } catch (Exception e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
     
}
