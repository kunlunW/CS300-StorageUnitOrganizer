//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P4 Storage Unit Organizer
// Files: Box.java, LinkedBoxNode.java, LinkedBoxList.java, StorageUnitTests.java
// Course: CS300 Summer 2019
//
// Author: Kunlun Wang
// Email: kwang358@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: N/A
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * LinkedBoxList class serves to model a dynamic list to store box objects sorted in a descendant
 * order with respect to their weights
 * 
 * @author Kunlun Wang, Mouna Kacem
 */

public class LinkedBoxList {

  private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private int size; // number of boxes already stored in this list
  private int capacity; // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList
  // can store

  /**
   * A constructor that creates an empty LinkedBoxList with a given initial capacity
   * 
   * @param capacity of the LinkedBoxList
   */
  public LinkedBoxList(int capacity) {
    this.capacity = capacity;
    this.head = null;
    this.size = 0;
  }

  /**
   * Returns the size of this list
   * 
   * @return size of list
   */
  public int size() {
    return this.size;
  }

  /**
   * Return the capacity of this list
   * 
   * @return capacity of list
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Expands the capacity of this LinkedBoxList with the specified number a of additional elements
   * 
   * @param a amount that capacity needs to be expanded by
   */
  public void expandCapacity(int a) {
    this.capacity = this.capacity + a;
  }


  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return true if this LinkedBoxList is empty, false otherwise
   */
  public boolean isEmpty() {
    int size1 = this.size;
    if (size1 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks whether this LinkedBoxList is full
   * 
   * @return true if this list is full, false otherwise
   */
  public boolean isFull() {
    if (this.size >= this.capacity) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds a new box into this sorted list
   * 
   * @param newBox object to be added
   * @throws IllegalArgumentException if newBox is null
   * @throws IllegalStateException if this list is full
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
    if (newBox == null) {
      throw new IllegalArgumentException("Illegal Argument Exception");
    }
    if (isFull()) {
      throw new IllegalStateException("Illegal State Exception");
    }
    LinkedBoxNode newBoxNode = new LinkedBoxNode(newBox);
    // need a LinkedBoxNode object that refers to the current node
    LinkedBoxNode currentNode;
    // need a LinkedBoxNode object that refers to the previous node
    LinkedBoxNode previousNode;
    // if the head is null --> then the size must be zero. So it is an empty linkedList
    if (this.head == null) {
      // then we can assign the newBoxNode to head
      this.head = newBoxNode;
      // the size increments as we now have one node
      this.size++;
    }
    // if head is not null and the newNode with the newBox is heavier than the head
    else if (newBoxNode.getBox().getWeight() > this.head.getBox().getWeight()) {
      // then we set head to the next node

      newBoxNode.setNext(this.head);
      // and we set the new heavier node as head
      this.head = newBoxNode;
      size++;
    }
    // we also should consider another scenario, that is if the head is not null
    // and the new box is not heavier than the head, set current node to refer to
    // the next node, and the previous node remains as head
    else {
      currentNode = this.head.getNext();
      previousNode = this.head;
      // while the currentNode is referring to a non-null next node and the weight of new box
      // is less than the weight of current box, then we refer the previousNode to currentNode
      // and currentNode to nextNode
      while (currentNode != null
          && newBoxNode.getBox().getWeight() < currentNode.getBox().getWeight()) {
        previousNode = currentNode;
        currentNode = currentNode.getNext();
      }
      previousNode.setNext(newBoxNode);
      newBoxNode.setNext(currentNode);
      size++;
      return;
    }
  }

  /**
   * Checks if this list contains a box that matches with (equals) a specific box object
   * 
   * @param findBox box that needs to be searched for
   * @return true if this list contains findBox, false otherwise
   */
  public boolean contains(Box findBox) {
    // if the head is null, then return false
    if (this.head == null) {
      return false;
    }
    // we temporarily store the content of head to boxChecker, a LinkedBoxNode object
    // so we could iterate through the linkedlist to search for the specific box
    LinkedBoxNode boxChecker = this.head;
    for (int i = 0; i < size; i++) {
      if (boxChecker.getBox().equals(findBox)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a box stored in this list given its index
   * 
   * @param index of box index to be searched for
   * @return Box Box object to be found
   * @throws IndexOutOfBoundsException if index is out of the range 0..size-1
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    if ((size - 1) < index || index < 0) {
      throw new IndexOutOfBoundsException("Error: Invalid index.");
    }
    // we temporarily store the content of head to boxChecker, a LinkedBoxNode object
    // so we could iterate through the linkedlist to search for the specific box
    LinkedBoxNode boxChecker = this.head;
    for (int i = 0; i < index; i++) {
      boxChecker = boxChecker.getNext();
    }
    return boxChecker.getBox();
  }

  /**
   * Removes a returns the box stored at index from this LinkedBoxList
   * 
   * @param index of box object to be removed
   * @return box object that has been removed
   * @throws IndexOutOfBoundsException f index is out of bounds. index should be in the range of
   *         [0.. size()-1]
   */
  public Box remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("Error: Index out of bounds.");
    }
    LinkedBoxNode previousNode = head;
    // declare a box object, boxToRemove which store the content to be removed
    Box boxToRemove;
    // checks if the specific node is at the head position
    if (index == 0) {
      boxToRemove = this.head.getBox();
      this.head = this.head.getNext();
    } else {
      // go the the specific node where its references the one to be removed
      for (int i = 0; i < index - 1; i++) {
        previousNode = previousNode.getNext();
      }
      // set to remove and move to the previous node
      boxToRemove = previousNode.getNext().getBox();
      previousNode.setNext(previousNode.getNext().getNext());
    }
    size--;
    return boxToRemove;
  }

  /**
   * Removes all the boxes from this list
   */
  public void clear() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Returns a String representation of the state and content of this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}

