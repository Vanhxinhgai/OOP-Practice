package W9.B4.B4a_Adapter;

import java.util.Arrays;


// Target: giao diện hệ thống yêu cầu
interface Sorter {
    int[] sort(int[] arr);
}

// Adaptee: thư viện cũ, KHÔNG được sửa
// (Phần thân quickSort được viết ra để chương trình chạy được;
//  coi như đây là code có sẵn của thư viện.)
class LegacySorter {
    public int[] quickSort(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);   // không làm hỏng mảng gốc
        quickSort(result, 0, result.length - 1);
        return result;
    }

    private void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int pivot = a[(low + high) / 2];
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
                i++; j--;
            }
        }
        quickSort(a, low, j);
        quickSort(a, i, high);
    }
}

// Adapter: cài đặt Sorter, bên trong nhờ LegacySorter làm việc
class SorterAdapter implements Sorter {
    private final LegacySorter legacy;

    public SorterAdapter(LegacySorter legacy) {
        this.legacy = legacy;
    }

    @Override
    public int[] sort(int[] arr) {
        return legacy.quickSort(arr);     // chuyển lời gọi sort() sang quickSort()
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        // Phía sử dụng chỉ khai báo kiểu Sorter, không biết gì về LegacySorter
        Sorter sorter = new SorterAdapter(new LegacySorter());

        int[] arr = {5, 2, 9, 1, 7, 3, 8};
        int[] sorted = sorter.sort(arr);

        System.out.println("Mảng ban đầu  : " + Arrays.toString(arr));
        System.out.println("Sau khi sắp xếp: " + Arrays.toString(sorted));
    }
}
