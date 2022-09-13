class Solution {

    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int integer : data) {
            if (integer > 247) {
                return false;
            }
            if (count == 0) {
                if (integer >= 240) {
                    count = 3;
                } else if (integer >= 224) {
                    count = 2;
                } else if (integer >= 192) {
                    count = 1;
                } else if (integer >= 128) {
                    return false;
                }
            } else {
                if (integer >= 128 && integer <= 191) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
