package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueGeneric<T> implements IQueue<T>{

    /***
     *
     */
    private int maxSize;

    /**
     *
     */
    private List<T> list = new ArrayList<>();

    /***
     *
     * @param maxSize
     */
    public QueueGeneric(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     *
     * @return
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     *
     * @param maxSize
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     *
     * @param obj
     * @return
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
     *
     * @return
     */
    @Override
    public T poll() {
        T element = peek();

        if (list.size() != 0) {
            list.remove(0);
        }

        return element;
    }

    /**
     *
     * @return
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
     *
     * @return
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
     *
     * @return
     */
    @Override
    public T element() {
        T element = peek();
        if(element==null)
            throw new NoSuchElementException("there's no element any more");
        return element;
    }
}
