package StringAlgorithms;
import java.util.Scanner;
public class CompareVersionNumber {
    public static int compareVersion(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter version1: ");
        String version1 = scanner.nextLine();
        System.out.print("Enter version2: ");
        String version2 = scanner.nextLine();
        int result = compareVersion(version1, version2);
        System.out.println("Comparison result: " + result + " (1 means version1 > version2, -1 means version1 < version2, 0 means equal)");
        scanner.close();
    }
}    