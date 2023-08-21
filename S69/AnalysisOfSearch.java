import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// Anurag and Poojitha did this project collaboratively . 

class AnalysisOfSearch extends BST{
    

    public static void main(String[] args) {
        BST tree1= new BST();
        OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(100000);
        int bstAverage=0;
        int arrayAverage=0;

        for(int i=0;i<10000;i++){
            Random rand=new Random();
            int rand_int = rand.nextInt(1000);
            tree1.add(rand_int);
            pq.insert(rand_int);

            //insertion time
            long  bstStart=System.nanoTime();
            tree1.add(rand_int);
            long bstEnd=System.nanoTime();
            long diff=bstEnd-bstStart;
            bstAverage+=diff;


            long pqStart=System.nanoTime();
            pq.insert(rand_int);
            long pqEnd=System.nanoTime();
            long diff2=pqEnd-pqStart;
            arrayAverage+=diff2;
            //skew tree worst case
            // tree2.add(i);
        }

        // search in ordered array with binary search
        long pqSearchStart=System.nanoTime();
        System.out.println(pq.search(512));
        long pqSearchEnd=System.nanoTime();
        System.out.println("time for searching in pq :"+(pqSearchEnd-pqSearchStart));

        // for(int i=0;i<pq.size();i++){
        //     System.out.println(pq.get(i));
        // }

        // array1.sort(Comparator.naturalOrder());
        // for(int i=0;i<array1.size();i++){
        //     System.out.println(array1.get(i));
        // }

        System.out.println("Average insertion in BST : "+(bstAverage/1000)+" ");
        System.out.println("Average insertion in array : "+(arrayAverage/1000)+" ");

        //time for tree 1
        long bstsearchStart = System.nanoTime();

        boolean treeSearch=tree1.search(512);

        long bstsearchEnd = System.nanoTime(); 

        
        long bstinsertStart=System.nanoTime();
        tree1.add(400);
        long bstinsertEnd = System.nanoTime(); 

        
        // //
        if(treeSearch==false){
            System.out.println("didnt find key");
        }


        long time = bstsearchEnd-bstsearchStart;
        System.out.println("Elapsed Time for search in BST : "+time +" nano seconds");

        // long time2=bstinsertEnd-bstinsertStart;
        // System.out.println("insert in bst "+time2+ " nano second");


    }
    
}

class OrderedArrayMaxPQ<Key extends Comparable<? super Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) (new Comparable[capacity]);
        n = 0;
    }


    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       }
    public Key delMax()      { return pq[--n]; }

    public void insert(Key key) {
        int i = n-1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        n++;
    }

    public Key get(int i){
        return pq[i];
    }


   /***************************************************************************
    * Helper functions.
    ***************************************************************************/
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public boolean search(int key) {
        return binarySearch(0, n - 1, key);
    }
    
    private boolean binarySearch(int low, int high, int key) {
        if (high < low) {
            return false;
        }
    
        int mid = (low + high) / 2;
    
        int comparisonResult = ((Comparable<Integer>) pq[mid]).compareTo(key);
    
        if (comparisonResult == 0) {
            System.err.println("found "+ pq[mid]+" " + key );
            return true;
        } else if (comparisonResult > 0) {
            return binarySearch(low, mid - 1, key);
        } else {
            return binarySearch(mid + 1, high, key);
        }
    }
    

}
