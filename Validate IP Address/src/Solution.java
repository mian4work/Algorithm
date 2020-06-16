import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

    IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
    ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

    Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

    IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
    The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a
    valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in
    the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address
    (Omit leading zeros and using upper cases).

    However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
    colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

    Besides, extra leading zeros in the IPv6 is also invalid. For example,
    the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

    Note: You may assume there is no extra space or special characters in the input string.

    Example 1:
    Input: "172.16.254.1"

    Output: "IPv4"

    Explanation: This is a valid IPv4 address, return "IPv4".
    Example 2:
    Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

    Output: "IPv6"

    Explanation: This is a valid IPv6 address, return "IPv6".
    Example 3:
    Input: "256.256.256.256"

    Output: "Neither"

    Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class Solution {
    /**
     * This is from leetcode, the explanation of regix pattern is:
     * 
     * Chunk contains only one digit, from 0 to 9.
     *
     * Chunk contains two digits. The first one could be from 1 to 9, and the second one from 0 to 9.
     *
     * Chunk contains three digits, and the first one is 1. The second and the third ones could be from 0 to 9.
     *
     * Chunk contains three digits, the first one is 2 and the second one is from 0 to 4. Then the third one could be from 0 to 9.
     *
     * Chunk contains three digits, the first one is 2, and the second one is 5. Then the third one could be from 0 to 5.
     *
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattenIPv4 =
                Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern pattenIPv6 =
                Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

        if (pattenIPv4.matcher(IP).matches()) return "IPv4";
        return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }

    /**
     * First try works with several wrong submit with missing test cases.
     *
     * This is doable but the the best one. Using regix is better but for ip4, it is hard.
     *
     * @param IP
     * @return
     */
    public String validIPAddressFirstTry(String IP) {
        String ip4 = "IPv4", ip6 = "IPv6", neither = "Neither";
        if(IP == null || IP.length() == 0) {
            return neither;
        }

        String[] ips4 = IP.split("\\.");
        String[] ips6 = IP.split(":");

        if(IP.charAt(IP.length() - 1) != '.' && ips4.length == 4) {
            if(ip4(ips4)) {
                return ip4;
            }
        }

        if(IP.charAt(IP.length() -1) != ':' && ips6.length == 8) {
            if(ip6(ips6)) {
                return ip6;
            }
        }

        return neither;
    }

    boolean ip4(String[] strings) {
        boolean ans = true;

        try {
            for(int i = 0; i < 4; i++) {
                if(strings[i].length() == 0 || (strings[i].length() > 1 && strings[i].charAt(0) == '0')
                        || strings[i].charAt(0) == '-') {
                    return false;
                }
                int data = Integer.parseInt(strings[i]);
                if(data >= 256 || data < 0) {
                    ans = false;
                }
            }
        } catch(NumberFormatException ex) {
            ans = false;
        }

        return ans;
    }

    boolean ip6(String[] strings) {
        boolean ans = true;
        if(strings[0].charAt(0) == '0') {
            ans = false;
        } else {
            Pattern pattern = Pattern.compile("[^A-Fa-f0-9]");
            for(int i = 0; i < 8; i++) {
                String data = strings[i];
                if(data.length() > 4 || data.length() == 0) {
                    ans = false;
                }

                Matcher matcher = pattern.matcher(data);
                if(matcher.find()) {
                    ans = false;
                }
            }
        }
        return ans;
    }
}
