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
import java.util.*;

/**
 * The Box class serves to define a static field randGen that represents a generator of random
 * numbers, and two instance fields that represent respectively the color of the box, and its
 * weight. Also several methods that serve to compare and check equality of two object and several
 * getter and setter methods.
 * 
 * @author: Kunlun Wang, Mouna Kacem
 *
 */
public class Box implements Comparable<Box> {
  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  /**
   * The Box() constructor serves to create a new Box and initializes its instance fields color and
   * weight to random values
   */
  public Box() {
    // randomize the weight to be between 1 and 31
    this.weight = randGen.nextInt(31) + 1;
    // randomize the color of the new object to be any color possible
    this.color = randGen.nextInt();
  }


  /**
   * Box(int color, int weight) is a contsructor that creates a new Box and initializes its instance
   * fields color and weight to the specified values Throws IllegalArgumentException if the provided
   * weight value is out of the range of [1..30]
   * 
   * @param color a specific integer that represents the color
   * @param weight a specific integer that represents the weight of the object
   */
  public Box(int color, int weight) {
    // check if the weight passed in meets the restriction, if not, throw exception
    if (weight > 31 || weight < 1) {
      throw new IllegalArgumentException("Weight is not between 1 and 31!");
    } else {
      this.color = color;
      this.weight = weight;
    }
  }

  /**
   * equals(Object other) checks if the weight and color of two boxes are equal to each other.
   * 
   * @param other other box object
   * @return true if equals, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    boolean otherObjectCheck = false;
    // first check if other object is an instance of Box
    if (other instanceof Box) {
      int otherBoxWeight = ((Box) other).getWeight();
      int otherBoxColor = ((Box) other).getColor();
      // check if the wight and color of the two objects are the same
      if (this.weight == otherBoxWeight && this.color == otherBoxColor) {
        otherObjectCheck = true;
        return otherObjectCheck;
      } else {
        otherObjectCheck = false;
        return otherObjectCheck;
      }
    } else {
      otherObjectCheck = false;
      return otherObjectCheck;
    }
  }

  /**
   * returns a negative integer, a positive integer, or zero as this box is lighter than, heavier
   * than, or has the same weight as the specified otherBox.
   * 
   * @param otherBox another box object to be compared to
   * @return -1 if weight is less than the other box, 1 if the weight is more than the other box,
   *         and 0 if they are equal in weight
   */
  @Override
  public int compareTo(Box otherBox) {

    if (this.weight < otherBox.weight) {
      return -1;
    }
    if (this.weight == otherBox.weight) {
      return 0;
    }
    if (this.weight > otherBox.weight) {
      return 1;
    }
    return 0;
  }

  /**
   * Getter method to get the color of the current object
   * 
   * @return color of box
   */
  public int getColor() {
    return this.color;
  }

  /**
   * Getter method to get the weight of current object
   * 
   * @return weight of box
   */
  public int getWeight() {
    return this.weight;
  }
}


