package example;

public class QuickSorter implements Sorter{
    private int[] a;

    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        int left = 0;
        int right = a.length - 1;
        quickSort(a, left, right);
    }

    private void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        else {
            int povitindex = partition(left, right);
            quickSort(a, left, povitindex - 1);
            quickSort(a, povitindex + 1, right);
        }
    }

    private int partition(int begin, int end) {
        int pivot = a[begin];
        while (begin < end) {
            while (begin < end && a[end] >= pivot)
                end--;
            if (begin != end)
                swap(begin, end);
            while (begin < end && a[begin] <= pivot)
                begin++;
            if (begin != end)
                swap(begin, end);
        }
        // a[begin]=pivot;
        return begin;
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
    
}
