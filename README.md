# Bounded-Queue

A bounded-sized queue BoundedQueue<T>, using arrays with the following operations:
   To avoid "generic array cannot be created" error, declare the array to be Object[] and
   typecast where needed to avoid type warnings.
   BoundedQueue(int size): Constructor for queue of given size
   boolean offer(T x):	add a new element x at the rear of the queue
			returns false if the element was not added because the queue is full
   T poll():		remove and return the element at the front of the queue
			return null if the queue is empty
   T peek():		return front element, without removing it (null if queue is empty)
   int size():		return the number of elements in the queue
   boolean isEmpty():	check if the queue is empty
   void clear():	clear the queue (size=0)
   void toArray(T[] a):	fill user supplied array with the elements of the queue, in queue order
