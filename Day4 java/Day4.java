import java.io.*;

public class Day4 {
    public static void main(String[] args) {
        passaporto pass = new passaporto();

        try {
            int x = howManyValid(new BufferedReader(new FileReader("input.txt")), pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static int howManyValid(BufferedReader in, passaporto pass) throws IOException{
        int result = 0;
        String str = "";
        String tmp = "";
        
        while((str=in.readLine())!=null){
            if(str.isBlank())
        }

        return result;
    }
}
