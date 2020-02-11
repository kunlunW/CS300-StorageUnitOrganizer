
public class AlternativeWayToDoAddMethod extends Box implements Comparable<Box> {
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
    }
    // we also should consider another scenario, that is if the head is not null
    // and the new box is not heavier than the head, set current node to refer to
    // the next node, and the previous node remains as head
    else {
      currentNode = this.head.getNext();
      previousNode = this.head;
      // while the currentNode is referring to a non-null next node
      while (currentNode != null) {
        // if the new node is heavier than the current node, then move it down
        if (newBoxNode.getBox().getWeight() > currentNode.getBox().getWeight()) {
          previousNode.setNext(newBoxNode);
          newBoxNode.setNext(currentNode);
          return;
        }
        // if not, then previous node refer to current node, and current node refers to the next
        // node
        else {
          previousNode = currentNode;
          currentNode = currentNode.getNext();
        }
        // if the current node refers to a null node, then do the following
        previousNode.setNext(newBoxNode);
        newBoxNode.setNext(null);
      }
    }
  }
}

//public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
//if (newBox == null) {
//throw new IllegalArgumentException("Illegal Argument Exception");
//}
//if (isFull()) {
//throw new IllegalStateException("Illegal State Exception");
//}
//// create a new LinkedBoxNode object, with newBox as a Box object that needs 
//// to be stored
//LinkedBoxNode newBoxNode = new LinkedBoxNode(newBox); 
//// when the list if empty, add the LinkedBoxNode object to the head of the linked list 
//if (this.size == 0) {
//this.head = newBoxNode;
//// increment the size of the list 
//size++;
//}
//// if the list is not empty, then we will need to first compare the new box and 
//// the existing box to determine where to add the new box 
//else {
//// since we need to conduct insertion, the previous node would refer
//LinkedBoxNode previousNode = null; 
//// need to create a LinkedBoxNode object that refers to the head of the 
//// linked list, since we want the boxes to be sorted out in a descending order,
//// which means that the the head must store the box with the biggest values
//LinkedBoxNode nextNode = this.head; // holds the next node reference
//// need a boolean variable here to track if a box has been added or not
//boolean boxAddedCheck = false; 
//while (!boxAddedCheck) {
//  // checks the weight of the node to the weight of the box to be added, if the 
//  // new node is heavier than the nextNode (which stores the head right now)
//  if (newBox.compareTo(nextNode.getBox()) >= 0) {
//    // double check if nextNode is head, if it is then move down the newNode to 
//    // the place of head and head is refereed as next node
//    if (nextNode == this.head) {
//      newBoxNode.setNext(this.head);
//      this.head = newBoxNode;
//      size++;
//      // box was added! next round exit while loop
//      boxAddedCheck = true;
//    }
//    // adds the node
//    else {
//      newBoxNode.setNext(nextNode);
//      if (previousNode != null) {
//        previousNode.setNext(newBoxNode);
//      }
//      size++;
//      boxAddedCheck = true;
//    }
//  }
//  // adds the box if it being added to the back of the list
//  if (nextNode.getNext() == null && !boxAddedCheck) {
//    nextNode.setNext(newBoxNode);
//    size++;
//    boxAddedCheck = true;
//  }
//  previousNode = nextNode;
//  nextNode = nextNode.getNext();
//}
//}
//}
