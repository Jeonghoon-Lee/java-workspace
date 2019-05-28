package playground;

public class RecursiveSelectionSort {
    public static void sort(int[] list) {
        sort(list, 0, list.length - 1);
    }

    public static void sort(int[] list, int low, int high) {
        if (low < high) {
            // find the smallest number
            int min = list[low];
            int minIndex = low;

            for (int i = low + 1; i <= high; i++) {
                if (min > list[i]) {
                    min = list[i];
                    minIndex = i;
                }
            }
            // swap the smallest in list
            list[minIndex] = list[low];
            list[low] = min;

            // sort the remaining
            sort(list, low + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 1, 3, 1, 2, 5, 2, -1, 0};
        sort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
