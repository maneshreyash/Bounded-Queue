package ssm170730;

import java.util.Scanner;

public class BoundedQueue<T> {
    private int capacity;
    private int qsize;
    private int front;
    private int rear;
    private Object[] array;

    private BoundedQueue(int size) {
        qsize = 0;
        capacity = size;
        front = -1;
        rear = -1;
        array =  new Object[size];
    }

    private boolean offer(T x)
    {

        if(((rear+1) % capacity) == front)
        {
            return false;
        }
        else
        {
            if (rear == front && front == -1)
            {
                front += 1;
            }
            rear = (rear+1) % capacity;
            array[rear] = x;
            qsize++;
            return true;
        }
    }

    private T poll()
    {
        if(rear == front && rear == -1)
        {
            return null;
        }
        else
        {
            T x = (T) array[front];
            if(rear == front)
            {
                rear = -1;
                front = -1;
            }
            else
            {
                front = (front + 1) % capacity;
            }
            qsize--;
            return x;
        }
    }

    private T peek()
    {
        if(qsize == 0)
            return null;
        else
            return (T)array[front];
    }

    private int size()
    {
        return qsize;	//(rear-front);
    }
    private boolean isEmpty()
    {
        if(qsize == 0 )
            return true;
        else
            return false;
    }

    private void clear()
    {
        qsize = 0;
        rear = -1;
        front = -1;
    }

    private void toArray(T[] a)
    {
        if(front < rear){
            for (int i = front; i <= rear; i++) {
                a[i] = (T) array[i];
            }
        }else
        {   int j = 0;
            for (int i = front; i < capacity; i++){
                a[j] = (T) array[i];
                j++;
            }
            for (int i = 0; i <= rear; i++){
                a[j] = (T) array[i];
                j++;
            }
        }

    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter capacity of queue: ");
        int n = in.nextInt();
        BoundedQueue<Integer> queue =  new BoundedQueue<>(n);

        while(in.hasNext()) {
            int com = in.nextInt();
            switch(com) {
                case 1:  // offer
                    int number = in.nextInt();
                    boolean status = queue.offer(number);

                    System.out.println("Queue offer success: "+status);
                    break;
                case 2:  // poll
                    System.out.println("Poll: "+queue.poll());
                    break;
                case 3: //peek
                    System.out.println("Peek: "+queue.peek());
                    break;
                case 4: //size
                    System.out.println("Size: "+queue.size());
                    break;
                case 5: //isEmpty
                    System.out.println("Is empty?: "+queue.isEmpty());
                    break;
                case 6: //clear
                    queue.clear();
                    System.out.println("Queue cleared");
                    break;
                case 7: //toArray
                    System.out.println("Queue");
                    Integer ar[] = new Integer[queue.size()];
                    queue.toArray(ar);
                    for(int i = 0; i<ar.length; i++)
                    {
                        System.out.print(ar[i] + " ");
                    }
                    break;
                default:  // Exit loop
                    break;
            }
        }
    }
}
