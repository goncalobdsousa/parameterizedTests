package EX2;

public class Numbers {

    public static void isPrime(int number) {
        if (number < 2) {
            throw new RuntimeException("Number must be greater than 1");
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                throw new RuntimeException("Number is not prime");
            }
        }
    }

    public static void isEven(int number) {
        if (number % 2 != 0) {
            throw new RuntimeException("Number is not even");
        }
    }

    public static void isMultipleOf(int number, int multiple) {
        if (number % multiple != 0) {
            throw new RuntimeException("Number is not multiple of " + multiple);
        }
    }
}
