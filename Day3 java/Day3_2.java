import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3_2 {
    public static void main(String[] args) {
        try {
            long x = somma(calcola(new BufferedReader(new FileReader("input.txt")), 1, 1),
                           calcola(new BufferedReader(new FileReader("input.txt")), 3, 1),
                           calcola(new BufferedReader(new FileReader("input.txt")), 5, 1),
                           calcola(new BufferedReader(new FileReader("input.txt")), 7, 1),
                           calcola(new BufferedReader(new FileReader("input.txt")), 1, 2));

            System.out.println(x);             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static long calcola(BufferedReader in, int rank, int down) throws IOException{
        int max = 31-rank;
        int index = 0;
        String str = "";
        long counter = 0;
        int diff = 0;
        while((str=in.readLine())!=null){
            if(str.charAt(index)=='#'){
                counter++;
            }
            
            if(index<max){
                index +=rank;
            }

            else{
                diff = index - max;
                index = diff;
            }
            for(int i=1; i<down; i++){
                str=in.readLine();
            }
        }

        return counter;
    }

    static long somma(long x, long y, long z, long j, long k){
        return x*y*z*j*k;
    }
}
