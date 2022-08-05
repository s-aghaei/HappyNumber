package happyNumber;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static Function<Integer,Integer> sumOfDigitSquares = number -> {
        Integer sum = 0;

        while (number != 0) {
            Integer digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    };
    public static boolean numberIsHappy(int number) {



        int slow, fast;

        slow = fast = number;
        do
        {
            slow = sumOfDigitSquares.apply(slow);

            fast = sumOfDigitSquares.apply(sumOfDigitSquares.apply(fast));

        }
        while (slow != fast);

        return (slow == 1);
    }
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("please enter a number:");
        Integer number = scanner.nextInt();
        System.out.println(numberIsHappy(number));

    }

}
