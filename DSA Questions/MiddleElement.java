class DLLNode {
    DLLNode prev;
    int data;
    DLLNode next;
    DLLNode(int data) { this.data = data; }
}

public class MiddleElement {
    DLLNode head;
    DLLNode mid;
    DLLNode prev;
    DLLNode next;
    int size;
  
    void push(int new_data)
    {
      DLLNode new_node = new DLLNode(new_data);
       
        if (size == 0) {
            head = new_node;
            mid = new_node;
            size++;
            return;
        }
        head.next = new_node;
        new_node.prev = head;
 
        head = head.next;
        if (size % 2 != 0) {
            mid = mid.next;
        }
        size++;
    }
 
   
   
 
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            }
            else {
                data = head.data;
                head = head.prev;
                head.next = null;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }
 
  
    int findMiddle()
    {
        if (size == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return mid.data;
}
 public static void main(String args[])
    {
        MiddleElement ms = new MiddleElement ();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);
 
       
        System.out.println("Middle Element : "
                           + ms.findMiddle());
        
     
    }
}