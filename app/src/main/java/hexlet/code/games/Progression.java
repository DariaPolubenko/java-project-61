package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final int LENGTH = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_FIRST_NUMBER = 10;
    private static final int MAX_NUMBER_PROGRESSION = 20;
    private static String greeting = "What number is missing in the progression?";
    private static int missingNumber;

    public static void playProgression() {

        String[][] data = new String[Engine.ROUNDS][2];

        for (var i = 0; i < Engine.ROUNDS; i++) {

            int[] numbers = getNumbers();
            missingNumber = Utils.getRandom(0, LENGTH - 1); // от [0 до длина массива)

            var result = numbers[missingNumber];
            data[i][1] = String.valueOf(result);

            var question = getQuestion(numbers);
            data[i][0] = "Question: " + question;
        }
        Engine.run(greeting, data);
    }

    public static int[] getNumbers() {
        int[] numbers = new int[LENGTH];
        numbers[0] = Utils.getRandom(MIN_NUMBER, MAX_FIRST_NUMBER); // от [1 до 10]

        int progressionNumber = Utils.getRandom(MIN_NUMBER, MAX_NUMBER_PROGRESSION); // от [1 до 20]
        for (var i = 1; i < LENGTH; i++) {
            numbers[i] = numbers[i - 1] + progressionNumber;
        }
        return numbers;
    }

    public static String getQuestion(int[] numbers) {
        String[] numbersString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        numbersString[missingNumber] = "..";
        var question = String.join(" ", numbersString);
        return question;
    }
}
