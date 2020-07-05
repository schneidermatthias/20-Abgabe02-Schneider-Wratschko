package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueGeneric<T> implements IQueue<T>{


    private int maxSize;
    private List<T> list = new ArrayList<>();

    /***
     * constructor
     * @param maxSize describes maximum size of queue
     */
    public QueueGeneric(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * getter of maxSize of queue
     * @return int maxSize of Queue
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * method for assigning new maxSize to Queue
     * @param maxSize
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Adds the element obj to the queue.
     * If the addition is successful, the method returns true else false.
     * @param obj Generic, will be added to queue
     * @return boolean, true if list is not full, flase if full
     */
    @Override
    public boolean offer(T obj) {
        if (list.size() != maxSize)
            list.add(obj);
        else
            return false;

        return true;
    }

    /**
     * Returns the head (first) element and also deletes it. That is, we cannot get it again.
     * If no element exists (when queue is empty), the method returns null.
     * @return Generic element
     * */
    @Override
    public T poll() {
        T element = peek();

        if (list.size() != 0) {
            list.remove(0);
        }

        return element;
    }

    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     * @return Generic element
     */
    @Override
    public T remove() {
        T element = poll();
        //element = ""; Bug: Exception always thrown, if assigned value is reassigned  to ""
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     * @return Generic element
     */
    @Override
    public T peek() {
        if(list.size()>0){
            return list.get(0);
        }
        else
            return null;
    }

    /**
     * It works similar to peek() but with a small difference (returns but does not delete the element).
     * It throws NoSuchElementException when the queue is empty.
     * @return Generic element
     */
    @Override
    public T element() {
        T element = peek();
        if(element==null)
            throw new NoSuchElementException("there's no element any more");
        return element;
    }
}
