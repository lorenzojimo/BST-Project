class Node{
int value;
Node left, right;
/**
 * Constructs a Node with a given value.
 *
 * @param value the value to store in the node
 */
public Node(int value){
this.value = value;
left = null;
right = null;
}
}
/**
 * Represents a Binary Search Tree (BST) with common operations
 * such as insertion, traversal, search, and deletion.
 */
class BinarySearchTree{
Node root;
/*
recursive insert method
*/
/*
inserts a node into the tree
*/
/**
 * Inserts a value into the binary search tree.
 *
 * @param value the value to insert into the tree
 */
//implementing insert method
public void insert(int value){
//tree is empty
if(root == null){
root = new Node(value);
return;
}else{
Node current = root;
Node parent = null;
while(true){
parent = current;
if(value < current.value){
current = current.left;
if(current == null){
parent.left = new Node(value);
return;
}
}else{
current = current.right;
if(current == null){
parent.right = new Node(value);
return;
}
}
}//closing while
}//closing main if-else
}
/*
pre-order traversal
Prints the value of every node preOrder
*/
/**
 * Performs a pre-order traversal of the tree.
 * Visits: Root -> Left -> Right
 *
 * @param root the starting node of the traversal
 */
public void preOrderTraversal(Node root){
//implement in here
	if (root == null) return;
	System.out.print(root.value + " ");
	preOrderTraversal(root.left);
	preOrderTraversal(root.right);
}
/*
in-order traversal
*/
/**
 * Performs an in-order traversal of the tree.
 * Visits: Left -> Root -> Right
 *
 * @param root the starting node of the traversal
 */
public void inOrderTraversal(Node root){
//implement in here
    if (root == null) return;
    inOrderTraversal(root.left);
    System.out.print(root.value + " ");
    inOrderTraversal(root.right);
}
/*
post-order traversal
*/
/**
 * Performs a post-order traversal of the tree.
 * Visits: Left -> Right -> Root
 *
 * @param root the starting node of the traversal
 */
public void postOrderTraversal(Node root){
//implement in here
    if (root == null) return;
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(root.value + " ");
}
/*
a method to find the node in the tree
with a specific value
*/
/**
 * Searches for a specific value in the tree.
 *
 * @param root the starting node
 * @param key the value to search for
 * @return true if the value exists, false otherwise
 */
public boolean find(Node root, int key){
//implement in here
	if (root == null) return false;
    if (root.value == key) return true;
    if (key < root.value)
        return find(root.left, key);
    else
        return find(root.right, key);
}
/*
a method to find the node in the tree
with a smallest key
*/
/**
 * Finds the minimum value in the tree.
 *
 * @param root the starting node
 * @return the smallest value in the tree
 * @throws IllegalArgumentException if the tree is empty
 */
public int getMin(Node root){
//implement in here
    if (root == null)
        throw new IllegalArgumentException("Tree is empty");
    while (root.left != null) {
        root = root.left;
    }
    return root.value;
}
/*
a method to find the node in the tree
with a largest key
*/
/**
 * Finds the maximum value in the tree.
 *
 * @param root the starting node
 * @return the largest value in the tree
 * @throws IllegalArgumentException if the tree is empty
 */
public int getMax(Node root){
//implement in here
    if (root == null)
        throw new IllegalArgumentException("Tree is empty");
     while (root.right != null) {
        root = root.right;
    }
    return root.value;
}
/*
this method will not compile until getMax
is implemented
*/
/**
 * Deletes a node with a given key from the tree.
 *
 * @param root the starting node
 * @param key the value to delete
 * @return the updated root after deletion
 */
public Node delete(Node root, int key){
if(root == null){
return root;
}else if(key < root.value){
root.left = delete(root.left, key);
}else if(key > root.value){
root.right = delete(root.right, key);
}else{
//node has been found
if(root.left==null && root.right==null){
//case #1: leaf node
root = null;
}else if(root.right == null){
//case #2 : only left child
root = root.left;
}else if(root.left == null){
//case #2 : only right child
root = root.right;
}else{
//case #3 : 2 children
root.value = getMax(root.left);
root.left = delete(root.left, root.value);
}
}
return root;
}
}
public class TreeDemo{
public static void main(String[] args){
BinarySearchTree t1 = new BinarySearchTree();
t1.insert( 24);
t1.insert(80);
t1.insert(18);
t1.insert(9);
t1.insert(90);
t1.insert(22);
System.out.print("in-order : ");
t1.inOrderTraversal(t1.root);
System.out.print("\nPre-order: ");
t1.preOrderTraversal(t1.root);

System.out.print("\nPost-order: ");
t1.postOrderTraversal(t1.root);

System.out.println("\nFind 22: " + t1.find(t1.root, 22));
System.out.println("Min: " + t1.getMin(t1.root));
System.out.println("Max: " + t1.getMax(t1.root));
}
}
