public class Codec {
    static int count = 0;
    static Map<String, String> longToShortMap = new HashMap<>();
    static Map<String, String> shortToLongMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!longToShortMap.containsKey(longUrl)) {
            String shortUrl = "http://tinyurl.com/" + encode62();
            longToShortMap.put(longUrl, shortUrl);
            shortToLongMap.put(shortUrl, longUrl);
            count++;
        }
        return longToShortMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private String encode62() {
        String result = "";
        char[] codes = genCharArray();
        do {
            result = codes[count % 62] + result;
            count = (int)Math.floor(count / 62);
        } while (count != 0);
        return result;
    }

    private char[] genCharArray() {
        int count = 0;
        char[] codes = new char[62];
        for (char i = '0'; i <= '9'; i++) {
            codes[count++] = i;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            codes[count++] = i;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            codes[count++] = i;
        }
        return codes;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
