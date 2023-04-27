public class Main {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(5);

        for (int j : result) {
            System.out.println(j);
        }
    }
}
