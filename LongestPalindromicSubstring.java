package StringAlgorithms;

import java.util.Scanner;

public class LongestPalindromicSubstring {

    // Hàm tìm chuỗi con đối xứng dài nhất trong chuỗi s
    public String longestPalindrome(String s) {
        // Nếu chuỗi rỗng hoặc null thì trả về rỗng
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0; // Lưu lại vị trí bắt đầu và kết thúc của chuỗi con đối xứng dài nhất

        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < s.length(); i++) {
            // Trường hợp 1: chuỗi đối xứng có độ dài lẻ (tâm là 1 ký tự)
            int len1 = expandAroundCenter(s, i, i);

            // Trường hợp 2: chuỗi đối xứng có độ dài chẵn (tâm là 2 ký tự liên tiếp)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Lấy độ dài lớn nhất trong 2 trường hợp
            int len = Math.max(len1, len2);

            // Nếu độ dài tìm được lớn hơn độ dài hiện tại
            if (len > end - start) {
                // Cập nhật lại start và end
                start = i - (len - 1) / 2; // Xác định vị trí bắt đầu
                end = i + len / 2;         // Xác định vị trí kết thúc
            }
        }
        // Trả về chuỗi con đối xứng dài nhất
        return s.substring(start, end + 1);
    }

    // Hàm mở rộng từ tâm ra hai bên để tìm chuỗi đối xứng
    private int expandAroundCenter(String s, int left, int right) {
        // Trong khi hai con trỏ chưa vượt ra ngoài chuỗi và ký tự hai bên bằng nhau
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // mở rộng sang trái
            right++;  // mở rộng sang phải
        }
        // Độ dài của chuỗi đối xứng chính là right - left - 1
        return right - left - 1;
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the string: "); // Nhập chuỗi từ bàn phím
            String LPC = input.nextLine();

            // In ra kết quả
            System.out.println("Longest Palindromic Substring of '" + LPC + "' is: "
                                + solver.longestPalindrome(LPC));
        }
    }
}