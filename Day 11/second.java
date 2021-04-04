import java.io.*;
import java.util.*;

public class second {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            String len = sc.nextLine();
            m = len.length();
            while(sc.hasNextLine()) {
                sc.nextLine();
                n++;
            }
            n++;
            sc.close();   
        } catch (Exception e) {
            System.out.println("Can't count dimension");
        }

        System.out.println(n +" "+ m);
        char [][] seatMap = new char[n][m];
        char [][] seatMapUpdated = new char[n][m];
        BufferedReader in;
        String tmp = "";
        
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            for (int i=0; i<n; i++){
                if((tmp = in.readLine()) != null){
                    for (int j=0; j<tmp.length(); j++){
                        seatMap[i][j] = tmp.charAt(j);
                    }
                }       
            }
        } catch (Exception e) {
            System.out.println("Can't inizialaze seatMap");
        }

        update(seatMap, seatMapUpdated, n, m);

        while(!sameSeat(seatMap, seatMapUpdated, n, m)){
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    seatMap[i][j] = seatMapUpdated[i][j];        
            update(seatMap, seatMapUpdated, n, m);
        }

        System.out.println(countSeat(seatMap, n, m));
    }

    static void update(char [][] map, char [][] next, int n, int m){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                switch (map[i][j]) {
                    case 'L':
                        boolean nd = false;
                        //Check verticale
                        for(int i2=i+1; i2<n; i2++){
                            if(i2>-1 && i2<n){
                                if(map[i2][j]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1; i2>=0; i2--){
                            if(i2>-1 && i2<n){
                                if(map[i2][j]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j]=='L')
                                    break;
                            }
                        }

                        //Check orizzontale
                        for(int j2=j+1; j2<m; j2++){
                            if(j2>-1 && j2<m){
                                if(map[i][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i][j2]=='L')
                                    break;
                            }
                        }
                        for(int j2=i-1; j2>=0; j2--){
                            if(j2>-1 && j2<m){
                                if(map[i][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i][j2]=='L')
                                    break;
                            }
                        }

                        //Check diagonale
                        for(int i2=i+1, j2=j+1; i2<n && j2<m; i2++, j2++){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1, j2=j-1; i2>=0 && j2>=0; i2--, j2--){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i+1, j2=j-1; i2<n && j2>=0; i2++, j2--){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1, j2=j+1; i2>=0 && j2<m; i2--, j2++){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    nd = true;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }

                        if(nd==true)
                            next[i][j] = 'L';
                        else 
                            next[i][j] = '#';
                        break;
                    
                    case '#':
                        int dn = 0;
                        for(int i2=i+1; i2<n; i2++){
                            if(i2>-1 && i2<n){
                                if(map[i2][j]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1; i2>=0; i2--){
                            if(i2>-1 && i2<n){
                                if(map[i2][j]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j]=='L')
                                    break;
                            }
                        }

                        //Check orizzontale
                        for(int j2=j+1; j2<m; j2++){
                            if(j2>-1 && j2<m){
                                if(map[i][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i][j2]=='L')
                                    break;
                            }
                        }
                        for(int j2=i-1; j2>=0; j2--){
                            if(j2>-1 && j2<m){
                                if(map[i][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i][j2]=='L')
                                    break;
                            }
                        }

                        //Check diagonale
                        for(int i2=i+1, j2=j+1; i2<n && j2<m; i2++, j2++){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1, j2=j-1; i2>=0 && j2>=0; i2--, j2--){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i+1, j2=j-1; i2<n && j2>=0; i2++, j2--){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }
                        for(int i2=i-1, j2=j+1; i2>=0 && j2<m; i2--, j2++){
                            if(i2>-1 && i2<n && j2>-1 && j2<m && (i2!=i || j2!=j)){
                                if(map[i2][j2]=='#'){
                                    dn++;
                                    break;
                                }
                                if(map[i2][j2]=='L')
                                    break;
                            }
                        }

                        if(dn>=5)
                            next[i][j] = 'L';
                        break;    
                
                    default:
                        next[i][j] = map[i][j];
                        break;
                }
            }
        }
    }

    static boolean sameSeat(char [][] map, char [][] next, int n, int m){
        boolean equal = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!=next[i][j])
                    equal = false;
            }   
        }
        return equal;
    }

    static int countSeat(char [][] map, int n, int m){
        int count = 0;
        for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    if(map[i][j]=='#')
                        count++;
        return count;
    }
}
