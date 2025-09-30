package StringAlgorithms;

public class LongesSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128]; // Mảng để lưu vị trí cuối cùng của mỗi ký tự

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i); // Cập nhật vị trí bắt đầu của chuỗi con không lặp lại
            ans = Math.max(ans, j - i + 1); // Cập nhật độ dài lớn nhất
            index[s.charAt(j)] = j + 1; // Cập nhật vị trí cuối cùng của ký tự hiện tại
        }
        return ans;
    }
    public static void main(String[] args) {
        LongesSubstringWithoutRepeatingCharacters obj = new LongesSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters in '" + s + "' is: " + result);
    }
}
                