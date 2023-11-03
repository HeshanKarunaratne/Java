package hackerrankquestions;

/**
 * @author Heshan Karunaratne
 */
public class CamelCase {

    public static int camelcase(String s) {

        if(s == null){
            return 0;
        }

        if(s.length() ==1){
            return 1;
        }
        int count = 1;
        for(int i=0; i< s.length();i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(camelcase("thisIsAString"));
    }
}
