package edu.greenriver.sdev333;


import java.util.Iterator;
import java.util.List;

/**
 * FIFO queue, page 151 and 152 of the red book
 */
public class Queue<ItemType> implements Iterable<ItemType>
{

    private class Node{
        ItemType data;
        Node next;
    }

    //fields:
    private Node first;
    private Node last;
    private int size;
    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return size;
    }

    public void enqueue(ItemType item)
    {
        Node oldlast = last;
        last = new Node();
        last.data = item;
        last.next = null;

        if(isEmpty())
        {
            last = null;
        }
        else
        {
            oldlast.next = last;
        }
        size ++;
    }

    public ItemType dequeue()
    {
        ItemType item = first.data;
        first = first.next;
        size--;
        if(isEmpty())
        {
            last = null;
        }
        return item;
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    //page 155
    @Override
    public Iterator<ItemType> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<ItemType>
    {
        private Node current = first;

        public ListIterator()
        {
            current = first;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current !=null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public ItemType next() {
            ItemType item = current.data;
            current = current.next;
            return item;
        }
    }
}
