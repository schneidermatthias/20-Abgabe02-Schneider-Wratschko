package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE
// TODO: find typos, bugs, etc and fix them

public class StringQueue implements IQueue<String> {


  private List<String> elements = new ArrayList<String>();
  private int maxSize; //bug: maxSize was already assigned

  /***
   * constructor
   * @param maxSize describes maximum size of queue
   */
  public StringQueue(int maxSize) { //typo: maxsize to maxSize
    this.maxSize = maxSize; //bug maxSize to this.maxSize
  }

  /**
   * Adds the element obj to the queue.
   * If the addition is successful, the method returns true else false.
   * @param obj String, will be added to queue
   * @return boolean, true if list is not full, flase if full
   */
  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  /**
   * Returns the head (first) element and also deletes it. That is, we cannot get it again.
   * If no element exists (when queue is empty), the method returns null.
   * @return String element
   * */
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) { //bug: was ==, should be !=, method was called when List is empty, not filled
      elements.remove(0);
    }

    return element;
  }

  /**
   * It also returns and deletes the head element like poll(), but with a small difference.
   * This method throws NoSuchElementException if the queue is empty.
   * @return String element
   */
  @Override
  public String remove() {
    String element = poll();
    //element = ""; Bug: Exception always thrown, if assigned value is reassigned  to ""
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  /**
   * Returns the head element but it does not delete it. That is, we can get it again.
   * Returns null when the queue is empty.
   * @return String element
   */
  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  /**
   * It works similar to peek() but with a small difference (returns but does not delete the element).
   * It throws NoSuchElementException when the queue is empty.
   * @return String element
   */
  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}