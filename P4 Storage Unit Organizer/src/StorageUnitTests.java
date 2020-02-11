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
 * This class serves to test the functionality of box.java, LinkedBoxNode.java, and
 * LinkedBoxList.java
 * 
 * @author Kunlun Wang, Mouna Kacem
 */

public class StorageUnitTests {

  /**
   * testBoxEquals() serves to check the functionality of equals() method
   * 
   * @return true if passes, false otherwise
   */
  public static boolean testBoxEquals() {
    boolean testPassed = true;

    Box box1 = new Box(1, 1);
    Box box2 = new Box(1, 1);
    Box box3 = new Box(1, 2);

    if (!box1.equals(box2)) {
      testPassed = false;
    }
    if (box2.equals(box3)) {
      testPassed = false;
    }

    return testPassed;
  }

  /**
   * Checks whether the behavior of compareTo method is correctly implemented
   * 
   * @return true if passes, false otherwise
   */
  public static boolean testBoxCompareTo() {
    boolean testPassed = true; // test boolean

    // test boxes
    Box box1 = new Box(10, 15);
    Box box2 = new Box(10, 20);
    Box box3 = new Box(20, 20);

    if (box1.compareTo(box3) != -1) {
      testPassed = false;
    }

    if (box2.compareTo(box3) != 0) {
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether remove method defined in your LinkedBoxList works correctly
   * 
   * @return true is passes, false otherwise
   */
  public static boolean testLinkedBoxListRemove() {
    // create a new LinkedBoxList object with a weight of 20
    LinkedBoxList test = new LinkedBoxList(20);
    boolean testPassed = true;
    // test boxes
    Box box1 = new Box(10, 10);
    Box box2 = new Box(10, 25);
    Box box3 = new Box(10, 5);

    test.add(box1);
    test.add(box2);
    test.add(box3);
    test.remove(3);

    // test that boxes are added and removed correctly
    if (test.get(0) != box2) {
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether contains method defined in your LinkedBoxList works correctly
   * 
   * @return true is passes, false otherwise
   */
  public static boolean testLinkedBoxListContains() {
    LinkedBoxList test = new LinkedBoxList(10);
    boolean testPassed = true;
    Box box1 = new Box(10, 20);
    Box box2 = new Box(10, 30);
    Box box3 = new Box(10, 40);
    test.add(box1);
    test.add(box2);
    if (!test.contains(box1)) {
      testPassed = false;
    }
    if (test.contains(box3)) {
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether add method defined in your LinkedBoxList works correctly
   * 
   * @return true i passes, false otherwise
   */
  public static boolean testLinkedBoxListAdd() {
    LinkedBoxList test = new LinkedBoxList(10);
    boolean testPassed = true;

    Box box1 = new Box(10, 20);
    Box box2 = new Box(10, 5);
    Box box3 = new Box(10, 40);
    test.add(box1);
    test.add(box2);
    test.add(box3);
    if (test.get(0) != box3 || test.get(1) != box1 || test.get(3) != box2) {
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Driver application of the tests.
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testBoxEquals());
    System.out.println(testBoxCompareTo());
    System.out.println(testLinkedBoxListRemove());
    System.out.println(testLinkedBoxListContains());
    System.out.println(testLinkedBoxListAdd());
  }
}


