package StringAlgorithms;
import java.util.Scanner;

// Lớp chuyển đổi số nguyên thành chữ tiếng Anh
public class intergerToEnglishWord {
    // Phương thức main - điểm bắt đầu của chương trình
    public static void main(String[] args) {    
        // Khởi tạo đối tượng Scanner để đọc input từ bàn phím
        Scanner scanner = new Scanner(System.in);
        // In thông báo yêu cầu nhập số
        System.out.print("Enter an integer: ");
        // Đọc số nguyên từ input
        int number = scanner.nextInt();
        // Chuyển đổi số thành chữ và lưu kết quả
        String result = convert(number);
        // In kết quả ra màn hình
        System.out.println("English word: " + result);
        // Đóng scanner để giải phóng tài nguyên
        scanner.close();
    }

    // Phương thức chuyển đổi số thành chữ
    private static String convert(int number) {
        // Xử lý trường hợp số 0
        if (number == 0) return "Zero";
        
        // Mảng chứa các từ cho số từ 0-19
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                         "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        // Mảng chứa các từ cho hàng chục
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        // Tạo StringBuilder để xây dựng kết quả
        StringBuilder result = new StringBuilder();
        
        // Xử lý hàng tỷ
        if (number >= 1000000000) {
            result.append(convert(number / 1000000000)).append(" Billion ");
            number %= 1000000000;
        }
        
        // Xử lý hàng triệu
        if (number >= 1000000) {
            result.append(convert(number / 1000000)).append(" Million ");
            number %= 1000000;
        }
        
        // Xử lý hàng nghìn
        if (number >= 1000) {
            result.append(convert(number / 1000)).append(" Thousand ");
            number %= 1000;
        }
        
        // Xử lý hàng trăm
        if (number >= 100) {
            result.append(units[number / 100]).append(" Hundred ");
            number %= 100;
        }
        
        // Xử lý hàng chục và đơn vị
        if (number > 0) {
            if (number < 20) {
                // Nếu số nhỏ hơn 20, lấy trực tiếp từ mảng units
                result.append(units[number]);
            } else {
                // Nếu số lớn hơn hoặc bằng 20, xử lý riêng phần chục và đơn vị
                result.append(tens[number / 10]);
                if (number % 10 > 0) {
                    result.append(" ").append(units[number % 10]);
                }
            }
        }
        
        // Trả về kết quả và loại bỏ khoảng trắng thừa ở đầu và cuối
        return result.toString().trim();
    }
}
