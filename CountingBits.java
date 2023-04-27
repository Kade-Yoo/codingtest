public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int num = 0; num <= n; num++) {
            if (num == 0) {
                result[num] = num;
                continue;
            }

            result[num] = divideBits(num, 0);
        }

        return result;
    }

    public int divideBits(int num, int count) {
        if (num / 2 == 0) {
            return count + 1;
        }

        if (num % 2 == 1) {
            return divideBits(num / 2, count + 1);
        } else {
            return divideBits(num / 2, count);
        }
    }
}
