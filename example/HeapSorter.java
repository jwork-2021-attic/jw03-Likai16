package example;

public class HeapSorter implements Sorter{
    private int[] a;
    
    @Override
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
        int len = a.length;
        buildMaxHeap(len);
        for (int i = len - 1; i > 0; i--) {
            swap(0, i);
            len--;
            fixHeap(0, len);

        }
    }

    private void buildMaxHeap(int len) {
        for (int i = len / 2 - 1; i >= 0; i--)
            fixHeap(i, len);
    }

    private void fixHeap(int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && a[left] > a[largest])
            largest = left;
        if (right < len && a[right] > a[largest])
            largest = right;
        if (largest != i) {
            swap(i, largest);
            fixHeap(largest, len);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
