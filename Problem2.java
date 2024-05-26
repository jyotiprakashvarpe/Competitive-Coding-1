
class Heap{
    int size;
    int[] heap;
    int capacity;
    public Heap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int pos){
        return pos/2;
    }

    private int leftChild(int pos){
        return 2 * pos;
    }

    private int rightChild(int pos){
        return 2 * pos + 1;
    }

    private boolean isLeafChild(int pos){
        if(size/2 < pos && pos <= size){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void print(){
        for(int i = 1; i <= size; i++){
            System.out.print(heap[i]+" ");
        }
    }

    public int peek(){
        return heap[1];
    }

    public void add(int element){
        if(capacity == size)
        {
            System.out.println("Capacity full");
            return;
        }
        size++;
        heap[size] = element;
        if(size == 1) return;
        int current = size;
        int parent = parent(current);
        while(heap[current] < heap[parent]){
            swap(current, parent);
            current = parent;
            parent = parent(parent);
        }

    }

    public void heapify(int pos){
        if(!isLeafChild(pos)){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    pos = leftChild(pos);
                    heapify(pos);
                } else {
                    swap(pos, rightChild(pos));
                    pos = rightChild(pos);
                    heapify(pos);
                }
            }
        }
    }

    public int remove(){
        int removed = heap[1];
        size--;
        heap[1] = heap[size];
        heapify(1);
        return removed;
    }

    private void swap(int x, int y){
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}
public class Problem2{

    public static void main(String[] strs){
        Heap heap = new Heap(10);
        heap.add(25);
        heap.add(8);
        heap.add(10);
        heap.add(20);
        heap.add(15);

        heap.print();
        System.out.println("Removed "+ heap.remove());

    }
}
