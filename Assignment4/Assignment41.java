import java.util.regex.Pattern;
import java.lang.*;
import java.util.*;

public class Assignment41 {
    public static String formattedLicense(String str, int k) { // score 2
        Pattern p = Pattern.compile("[^a-zA-Z0-9-]");
        if ( str.length() > 12000 || str.length() <= 0) {
            System.out.println("String length must more than 0 and less than 12000.");
        } else if (k <= 0) {
            System.out.println("K must be a positive integer.");
        } else if (p.matcher(str).find()) {
            System.out.println("String must consists only alphanumerical characters(a-z and/or A-Z and/or 0-9) and dashes(-).");
        } else {
            str = str.replace("-", "");
            str = str.toUpperCase();
            StringBuilder str_insert = new StringBuilder(str);
            for (int i = 1; i <= str.length() / k; i++) {
                int index = str.length() - i * k;
                str_insert = str_insert.insert(index, "-");
            }
            str = str_insert.toString();
        }

        return str;
}

    public static void main(String[] args) {
        String formattedLicense = formattedLicense("sd3-3532-d-Akd-e3aas3", 3);
        System.out.println(formattedLicense);
    }
}
