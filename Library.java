import java.util.Hashtable;
import java.util.InputMismatchException;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for Library
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();

  }

  /**
   * adds a title to the collection hashtable
   * 
   * @param title the book-to-be-added's title
   */
  public void addTitle(String title) {
    try {
      this.collection.put(title, true);
    } catch (InputMismatchException e) {
      System.out.println("Please enter a valid title"); // exception catching for if we use a scanner later on to add residents
    }
  }

  /**
   * checks out a book by setting the key's value to false
   * 
   * @param title the book-to-be-checked out's title
   * 
   */
  public void checkOut(String title) {
    if (isAvailable(title)) {
      try {
      this.collection.put(title, true);
      } catch (InputMismatchException d) {
        System.out.println("Please enter a valid title");
      }
    } else {
      throw new RuntimeException("You can't check out this book, sorry!");
    }
  }

  /**
   * removes a title from the collection hashtable
   * 
   * @param title the book-to-be-removed's title
   * @return the title of the removed book
   */
  public String removeTitle(String title) {
    if (this.collection.contains(title)) {
      try {
        this.collection.remove(title);
      } catch (InputMismatchException f) {
        System.out.println("Please enter a valid title");
      }
    } else {
      System.out.println("Collection doesn't contain the book you're trying to remove");
    }
    return title;
  }

 
  /**
   * returns true if the title appears as a key in the Libary's collection, false
   * otherwise
   * 
   * @param title
   * @return T/F is the title a key in the Library collection?
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * returns true if the title is currently available, false otherwise
   * 
   * @param title
   * @return T/F whether the title is availble to checkout
   */
  public boolean isAvailable(String title) {
    try {
      if (this.collection.get(title)) {
        return true;
      } else {
        return false;
      }
    } catch (InputMismatchException g) {
      System.out.println("Please enter a valid title");
      return false;
    } catch (RuntimeException l){
      System.out.println("This title is not in the current collection"); // catching a null pointer exception if the book isn't in collection
      return false;
    }
  }

  /**
   * prints out the entire collection in an easy-to-read way (including checkout
   * status)
   */
  public void printCollection() {
    // System.out.println(this.collection.toString());
    System.out.println("Titles in Collection: " + this.collection.keySet() + " Availible?: " + this.collection.entrySet());
  }

  public static void main(String[] args) {
    Library n = new Library("Nielson", "address", 4);
    n.addTitle("Jaws");
    n.addTitle("Jaws 2");
    n.addTitle("Jaws 3");
    n.checkOut("Jaws");
    System.out.println(n.containsTitle("Jaws"));
    System.out.println(n.isAvailable("Jaws"));
    n.checkOut("Jaws");
    n.printCollection();
  }

}
