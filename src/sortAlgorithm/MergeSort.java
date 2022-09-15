package sortAlgorithm;

public class MergeSort {
    private int len;
    private int m;
    private int a;
    private int b;
    private int k;

    public MergeSort(){
        this.len=1;
        this.m=0;
        this.a=0;
        this.b=0;
        this.k=0;
    }

    public void mergeSort(int[] array){
        int[] A = new int[len];
        int[] B = new int[len];

        if(k>=array.length) k = 0;
        for (int index = 0; index < len; index++) {
            if(index<A.length && k<array.length){
                A[index] = array[k];
                k++;
            }
        }
        for (int index = 0; index < len; index++) {
            if(index<B.length && k<array.length){
                B[index] = array[k];
                k++;
            }
        }
        int dim = -1;
        for (int i = 0; i < B.length; i++) {
            if(B[i]!=0){
            }else{
                int[] C = new int[i];
                for (int index = 0; index < C.length; index++) {
                    C[index] = B[index];
                }
                dim = C.length;
                merge(A, C, array);
                break;
            }
        }
        if(dim==-1){
            merge(A, B, array);
        }
        if(k == array.length && len == 1) len = 2;
        else if (k==array.length && len > 1) len *= 2;
    }

    public void merge(int[] A, int[] B, int[] array){
        a = 0;
        b = 0;
        if (m == array.length) {
            m = 0;
        }
        while (a < A.length && b < B.length && m < array.length) {
            if (A[a] < B[b]) {
                array[m] = A[a];
                m++;
                a++;
            } else {
                array[m] = B[b];
                m++;
                b++;
            }
        }
        if (a >= A.length) {
            while (b < B.length && m < array.length) {
                array[m] = B[b];
                m++;
                b++;
            }
        } else  {
            while (a < A.length && m < array.length) {
                array[m] = A[a];
                m++;
                a++;
            }
        }
    }

    public void setUp() {
        this.len=1;
        this.m=0;
        this.a=0;
        this.b=0;
        this.k=0;
    }
    
    public int getM(){
        return m;
    }    
}