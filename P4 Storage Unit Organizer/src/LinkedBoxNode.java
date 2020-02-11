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
 * The LinkedBoxNode mainly serves to models a linked node in our application
 * 
 * @author Kunlun Wang, Mouna Kacem
 */
public class LinkedBoxNode {

  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  /**
   * Constructor that creates a new LinkedBoxNode object with a given box and without referring to
   * any next LinkedBoxNode
   * 
   * @param box data to for this linked list or object to be stored
   */
  public LinkedBoxNode(Box box) {
    this.box = box;
    this.next = null;
  }

  /**
   * creates a new LinkedBoxNode object and sets its instance fields box and next to the specified
   * ones
   * 
   * @param box object to be stored
   * @param next a reference to the next object
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box;
    this.next = next;
  }

  /**
   * a getter method that gets the next object
   * 
   * @return next reference to the next object
   */
  public LinkedBoxNode getNext() {
    return this.next;
  }

  /**
   * Setter method that sets the next instance field to the next parameter
   * 
   * @param next next object to be referred to
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * Getter method that gets the box objects stored in the LinkedBoxNode
   * 
   * @return box object stored
   */
  public Box getBox() {
    return this.box;
  }

  /**
   * Setter method that sets the box object instance field to the parameter
   * 
   * @param box object to be stored
   */
  public void setBox(Box box) {
    this.box = box;
  }
}
