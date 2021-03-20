class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        array = "null".equals(array) ? null : array;
        if (array != null)
        {
            System.out.println((index < 0 || index > array.length - 1) ? "Exception!" : array[index] * array[index]);
        } else {
            System.out.println("Exception!");
        }
    }
}