package hexlet.code;

public class Utils {
    public static int getRandomNumber(int min, int max) {
        var randomNumber = (int) (Math.random() * (max - min + 1) + min);
        return randomNumber;
    }
}
