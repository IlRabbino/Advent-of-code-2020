import java.io.*;

public class Day3_1{
    public static void main(String[] args) {
        BufferedReader in;
        int counter = 0;
        String str = "";
        int index = 0;
        int max = 28;
        int diff = 0;
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            while((str = in.readLine()) != null){   
                if(str.charAt(index)=='#'){
                    counter++;
                }
                
                if(index<max){
                    index +=3;
                }

                else{
                    diff = index - max;
                    index = diff;
                }
            }
        } catch (Exception e) {
            System.err.println("Errore apertura file");
            e.printStackTrace();
        }
        
        System.out.println(counter);
    }
}