# Array
An array is a fundamental data structure that stores a collection of elements of the same type in contiguous memory locations. Each element in the array is identified by its index or position within the array.

## Creating an Array in Java

```
public class CustomDynamicArray {
    
    public static void main(String args[]) {
        // Declaring an integer array of size 3
        int[] intArray = new int[3];

        // Adding elements into the array
        intArray[0] = 50;
        intArray[1] = 60;
        intArray[2] = 70;

        // Declaring and initializing an array of strings
        String[] stringArray = {"Dog", "Cat", "Monkey"};

        // Looping through the intArray array to print its elements
        for (int i = 0; i < intArray.length; i++) {
            // Printing the element at index i of intArray
            System.out.println("Element at index " + i + " of intArray: " + intArray[i]);
        }

        // Looping through the stringArray array to print its elements
        for (int i = 0; i < stringArray.length; i++) {
            // Printing the element at index i of stringArray
            System.out.println("Element at index " + i + " of stringArray: " + stringArray[i]);
        }
    }
}
```
# Dynamic Array
The arrays created in the example above are of fixed size, meaning their size must be declared during creation and cannot be changed thereafter. This is where the dynamic array comes in. 
> A dynamic array is a data structure that dynamically resizes itself as needed while still providing constant time access to individual elements. It combines features of arrays and linked lists, allowing efficient random access like arrays and dynamic resizing like linked lists.

## Built In Dynamic Array in Java
In Java, dynamic arrays are typically implemented using the ArrayList class from the java.util package. ArrayList provides dynamic resizing functionality. Some common operations provided by ArrayList include adding elements (add), removing elements (remove), accessing elements by index (get), and more.
```
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
 
```

## Creating a Dynamic Array from Scratch
```
class CustomArray<Type> {
    // Define the array and currentIndex
    Type[] array;
    int currentIndex = 0;

    // Default constructor initializes the array with size 10
    CustomArray() {
        this.array = (Type[]) new Object[10]; // Creating an array of objects
    }

    // Constructor with a specified size
    CustomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid initial capacity: " + size);
        }
        this.array = (Type[]) new Object[size]; // Creating an array of objects with the specified size
    }

    // Method to insert an item into the array
    public void insert(Type item) {
        // Check if the array is full
        if (currentIndex == array.length) {
            // If array is full, double the size of the array
            Type[] temp = (Type[]) new Object[currentIndex * 2]; 
            // Copy elements from the original array to the new array
            for (int i = 0; i < currentIndex; i++) {
                temp[i] = this.array[i];
            }
            // Update the reference to the original array to point to the new array
            this.array = temp;
        }
        // Insert the item at the current index and increment the index
        this.array[currentIndex] = item;
        currentIndex++;
    }



    // Override toString method to print the array
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < currentIndex; i++) {
            result.append(array[i]);
            if (i < currentIndex - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}

public class CustomDynamicArray {
    public static void main(String args[]) {
        // Create an instance of CustomArray with Integer type
        CustomArray<Integer> intArray = new CustomArray<>(2);
        // Insert elements into the array
        intArray.insert(5);
        intArray.insert(56);
        intArray.insert(77);

        // Print the array using the overridden toString method
        System.out.println(intArray);

        System.out.print(intArray);
    }
}

```
