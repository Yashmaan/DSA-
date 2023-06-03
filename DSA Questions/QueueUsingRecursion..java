/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class QueueUsingRecursion {

// Utility function to print the queue
public static void Print(Queue<Integer> Queue)
{
	while (Queue.size() > 0) {
	System.out.print(Queue.peek() + " ");
	Queue.remove();
	}
}

// Function to reverse the queue
public static void reverseQueue(Queue<Integer> q)
{
	// base case
	if (q.size() == 0)
	return;
	// storing front(first element) of queue
	int fr = q.peek();

	// removing front
	q.remove();

	// asking recursion to reverse the
	// leftover queue
	reverseQueue(q);

	// placing first element
	// at its correct position
	q.add(fr);
}

public static void main(String[] args)
{
	Queue<Integer> Queue = new LinkedList<>();

	Queue.add(10);
	Queue.add(20);
	Queue.add(30);
	Queue.add(40);
	Queue.add(50);
	Queue.add(60);
	Queue.add(70);
	Queue.add(80);
	Queue.add(90);
	Queue.add(100);

	reverseQueue(Queue);
	Print(Queue);
}
}

// This code is contributed by akashish__
