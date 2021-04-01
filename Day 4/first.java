import java.io.*;
import java.util.*;

public class first {
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
        
        if(birth_year && issue_year && expiration_year && height && hair_color && eye_color && passport_id)
            return true;
      
        return false;
    }
    /********************************************************************************************************************************* 
    static Boolean areDataValid(HashMap<String, String> passport){
        Boolean birth_year_valid = (1919<Integer.parseInt(passport.get("byr")) && Integer.parseInt(passport.get("byr"))<2003);
        Boolean issue_year_valid = (2009<Integer.parseInt(passport.get("iyr")) && Integer.parseInt(passport.get("iyr"))<2021);
        Boolean expiration_year_valid = (2019<Integer.parseInt(passport.get("eyr")) && Integer.parseInt(passport.get("eyr"))<2031);
        Boolean height_valid = false;
        Boolean passport_id_valid = false;
        
        String height =passport.get("hgt");
        if(height.contains("cm")){
            int tmp = Integer.parseInt(height.substring(0, 2));
            if(149<tmp && tmp<193)
                height_valid = true;
        }
        else if(height.contains("in")){
            int tmp = Integer.parseInt(height.substring(0, 1));
            if(58<tmp && tmp<76)
                height_valid = true;
        }

        if(passport.get("pid").length()==9){
            passport_id_valid = isNumeric(passport.get("pid")); 
        }


        Boolean hair_color_valid = isHairValid(passport.get("hcl"));
        Boolean eye_color_valid = isColorValid(passport.get("ecl"));
        

        if(birth_year_valid && issue_year_valid && expiration_year_valid && height_valid && hair_color_valid && eye_color_valid && passport_id_valid)
            return true;
      
        return false;
    }
    
    private static Boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static Boolean isHex(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long d = Long.parseLong(strNum, 16);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static Boolean isColorValid(String str){
        List<String> valid = new ArrayList<String>();
        valid.add("amb");
        valid.add("blu");
        valid.add("brn");
        valid.add("gry");
        valid.add("grn");
        valid.add("hzl");
        valid.add("oth");
        
        if(valid.contains(str))
            return true;
        return false;
    }

    private static Boolean isHairValid(String str){
        str = str.substring(1);
        
        if(isHex(str))
            return true;
        return false;
    }

    *********************************************************************************************************************************************************/
}
