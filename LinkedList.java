/**
 * Created by mikdev on 2/12/17.
 */
class LinkedListMain {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.AddItemAtEnd(1);
        ls.AddItemAtEnd(2);
        ls.AddItemAtEnd(3);
        ls.AddItemAtEnd(4);
        ls.AddItemAtEnd(5);
        ls.AddItemAtEnd(6);
        ls.AddItemAtEnd(7);
        ls.AddItemAtFirst(0);
        ls.AddItemAtFirst(-1);
        ls.DeleteItem(-1);
        ls.DeleteItem(4);
        ls.DeleteItem(7);
        ls.PrintList();
        ls.Reverse();
        ls.PrintList();
    }
}

class LinkedList {
    Node first;

    public boolean AddItemAtEnd(int item) {
        Node NewNode = new Node(item);
        AddItemAtEnd(NewNode);
        return true;
    }

    public boolean AddItemAtEnd(Node NewNode) {
        Node Current = first, Past = null;
        while (Current != null) {
            Past = Current;
            Current = Current.next;
        }
        if (Past == null) {
            first = NewNode;
        } else {
            Past.next = NewNode;
            NewNode.next = Current;
        }
        return true;
    }

    public boolean AddItemAtFirst(int item) {
        Node NewNode = new Node(item);
        AddItemAtFirst(NewNode);
        return true;
    }

    public boolean AddItemAtFirst(Node NewNode) {
        if (first != null) {
            NewNode.next = first;
            first = NewNode;
        } else {
            first = NewNode;
        }
        return true;
    }

    public boolean AddItemToSortedList(Node NewNode) {
        Node Current = first, Past = null;
        while (Current != null && Current.item < NewNode.item) {
            Past = Current;
            Current = Current.next;
        }
        if (Past == null) {
            NewNode.next = first;
            first = NewNode;
        } else {
            Past.next = NewNode;
            NewNode.next = Current;
        }
        return true;
    }

    public boolean AddItemToSortedList(int item) {
        Node NewNode = new Node(item);
        AddItemToSortedList(NewNode);
        return true;
    }

    public boolean FindItem(int item) {
        Node Current = first;
        while (Current != null && Current.item < item) {
            Current = Current.next;
        }
        if (Current == null || Current.item > item)
            return false;
        else
            System.out.println("Item found");

        return true;
    }

    public void Reverse() {
        if (first != null) {
            Node Past = null, Current = first, Next = first.next;

            while (Current.next != null) {
                Current.next = Past;
                Past = Current;
                Current = Next;
                Next = Next.next;
            }
            Current.next = Past;
            first = Current;
        }
    }

    public boolean DeleteItem(Node NewNode) {
        DeleteItem(NewNode.item);
        return true;
    }

    public boolean DeleteItem(int item) {
        Node Current = first, Past = null;
        while (Current != null && Current.item != item) {
            Past = Current;
            Current = Current.next;
        }
        if (Current == null || Current.item != item) {
            return false;
        }
        if (Past == null) {
            first = Current.next;
        } else {
            Past.next = Current.next;
        }
        return true;
    }

    public void PrintList() {
        Node Current = first;
        while (Current != null) {
            System.out.println(Current.item);
            Current = Current.next;
        }
    }
}

class Node {
    public int item;
    public Node next;

    public Node() {
    }

    public Node(int item) {
        this.item = item;
    }

}