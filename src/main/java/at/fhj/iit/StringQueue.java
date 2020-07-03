package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE
// TODO: find typos, bugs, etc and fix them

public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize; //bug: maxSize was already assigned

  public StringQueue(int maxSize) { //typo: maxsize to maxSize
    this.maxSize = maxSize; //bug maxSize to this.maxSize
  }

  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) { //bug: was ==, should be !=, method was called when List is empty, not filled
      elements.remove(0);
    }

    return element;
  }

  @Override
  public String remove() {
    String element = poll();
    //element = ""; Bug: Exception always thrown, if assigned value is reassigned  to ""
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}