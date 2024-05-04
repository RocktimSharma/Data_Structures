import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

class BuiltInDynamicArray {
    public static void main(String args[]) {
        // Declaring the ArrayList with inistial size
        ArrayList<Integer> arr1 = new ArrayList<Integer>(5);

        // Declaring the ArrayList without initial size
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        // Appending new elements at the end of the list
        for (int i = 1; i <= 10; i++) {
            arr1.add(i);
            arr2.add(i);
        }

        // Printing the ArrayList
        System.out.println("Array 1:" + arr1);
        System.out.println("Array 2:" + arr2);

        //Adding element at given index 
        arr1.add(2, 30); // Adding 30 at index 2
        System.out.println("Array 1 after adding at index 2:" + arr1);


        // Adding all elements of arr2 to arry1
        arr1.addAll(arr2); // Appending elements from collection to arr1
        System.out.println("Array 1 after adding all elements from array 2:" + arr1);

        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        arr3.add(22);
        arr3.add(56);
        //Adding all elements of array3 into array 2 at given index
        arr2.addAll(1, arr3); // Adding all elements from array3 to arr2 starting from index 1
        System.out.println("Array 2 after adding all elements from array 3 at index 5:" + arr2);

        // Clear the array
        arr3.clear(); // Clearing all elements from arr1
        System.out.println("Array 3 after clearing:" + arr3);

        // .clone()
        ArrayList<Integer> clonedList = (ArrayList<Integer>) arr1.clone(); // Cloning arr2
        System.out.println("Cloned Array 1:" + clonedList);

        // Check if an element is present in the array
        boolean containsElement = arr2.contains(5); // Checking if arr2 contains 5
        System.out.println("Array 1 contains 5: " + containsElement);


        // Get elements using index
        int elementAtIndex = arr1.get(3); // Getting element at index 3
        System.out.println("\nElement at index 3 in Array 1: " + elementAtIndex);

        // get Index of an Array
        int indexOfElement = arr2.indexOf(22); // Getting index of element 7 in arr2
        System.out.println("Index of 22 in Array 2: " + indexOfElement);

        // Check if array is empty
        boolean isEmpty = arr3.isEmpty(); // Checking if arr3 is empty
        System.out.println("Array 3 is empty: " + isEmpty);

        // Get last index of an element
        int lastIndexOfElement = arr1.lastIndexOf(5); // Getting last index of element 5 in arr1
        System.out.println("Last index of 5 in Array 1: " + lastIndexOfElement);

        // Delete an element using index
        arr1.remove(2); // Removing element at index 2 from arr1
        System.out.println("Array 1 after removing element at index 2: " + arr1);


        // Remove elements using filters
        arr2.removeIf(element -> element % 2 == 0); // Removing all even elements from arr2
        System.out.println("Array 2 after removing all even elements: " + arr2);

        // Replace element in a particular index
        arr2.set(0, 100); // Replacing element at index 0 with 100 in arr2
        System.out.println("Array 2 after setting element at index 0 to 100: " + arr2);

    }
}
 