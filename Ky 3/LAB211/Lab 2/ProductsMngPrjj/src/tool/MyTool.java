/*
 * Class MyTool: class for validating input and inputing data using a condition
 * Date format: y: year, M: month in year, d: day in month
 *              Separators: - / : but they are not mixed
 *              Example: yyyy/MM/dd   dd:MM:yyyy   MM/dd/yyyy:
 * Regular expression for pattern
 *    Phone no 10 or 11 digits: "\\d{10}|\\d{11}"
 *    Phone no 10 to 11 digits: "\\d{10,11}"
 *    ID format X0000 : "X\\d{4}"
 *    ID format X0000 or M000: "X\\d{4}|M\\d{3}"
 */

package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MyTool {
 
 public static Scanner sc = new Scanner(System.in);
 
    public static double getADouble(String inputMsg, String errorMsg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
public static List<String> readLinesFromFile(String filename) {
    filename = "Products.txt"; 
        ArrayList list = new ArrayList();
        File f = new File(filename);
        String line;
        if (f.exists()) {
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) list.add(line);
                }
                br.close();
                fr.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }
    public static int getAnInteger(String inputMsg, String errorMsg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String regexString(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static int updateAnInteger(String inputMsg, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                System.out.print(inputMsg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true || number > max || number < min);
        return number;
    }

    public static double updateADouble(String inputMsg, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                System.out.print(inputMsg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true || number > max || number < min);
        return number;
    }

    public static String updateString(String inputMsg, String oldData) {
        String result = oldData;
        System.out.printf(inputMsg);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }
     public static String getStringForm(String welcome, String msg, String pattern, String form) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else if (!result.matches(pattern)) {
                System.out.println(form);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
} 
