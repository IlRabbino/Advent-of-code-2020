import java.io.*;
import java.util.*;

public class Day4 {
    public static void main(String[] args) {

        try {
            int x = howManyValid(new BufferedReader(new FileReader("input.txt")));
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    static int howManyValid(BufferedReader in) throws IOException{
        int result = 0;
        String read = null;
        String tmp = "";
        List<String> splited = new ArrayList<String>();
        String[] toSplit;
        HashMap<String, String> map = new HashMap<String, String>();

        while ((read = in.readLine()) != null) {
    
            if(!read.isBlank()){
                tmp += read;
                tmp += " ";
            }
                
            else{
                splited.add(tmp);
                tmp = "";
            }
                
        }

        splited.add(tmp);

        for (String part : splited) {
            toSplit = part.split("\\s+");

            for (String pair : toSplit) {
                String[] keyValue = pair.split(":");
                map.put(keyValue[0], keyValue[1]);
            }

            if(isValid(map))
                result++;

            map = new HashMap<String, String>();
            toSplit = null;
        }
        return result;
    }

    static Boolean isValid(HashMap<String, String> passport){
        Boolean birth_year = passport.containsKey("byr");
        Boolean issue_year = passport.containsKey("iyr");
        Boolean expiration_year = passport.containsKey("eyr");
        Boolean height = passport.containsKey("hgt");
        Boolean hair_color = passport.containsKey("hcl");
        Boolean eye_color = passport.containsKey("ecl");
        Boolean passport_id = passport.containsKey("pid"); 
        System.out.println(Integer.parseInt(passport.get("byr")));
        if(birth_year && issue_year && expiration_year && height && hair_color && eye_color && passport_id)
            //return areDataValid(passaporto)
            return true;
      
        return false;
    }

    
}
