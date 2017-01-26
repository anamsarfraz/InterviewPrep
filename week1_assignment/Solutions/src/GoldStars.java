/*
 * Alice is a teacher with a class of n children, each of whom has been assigned a numeric rating. The classroom is seated in a circular arrangement, with Alice at the top of the circle. She has a number of gold stars to give out based on each child's rating, but with the following conditions:

Each child must receive at least one gold star
Any child with a higher rating than his or her immediate neighbor should get more stars than that neighbor
Assuming n >= 3, what is the minimum total number of stars Alice will need to give out?

Write a program which takes as its input an int[] containing the ratings of each child, ordered by seating position, and returns an int value for the minimum total number of stars that Alice will need to give out.

Hint: this problem can be solved with an algorithm that runs in O(n) time.

For example:

In a class of three children with ordered ratings of {1, 2, 2}, Alice will need to give out {1, 2, 1} stars accordingly, for a total number of 4 stars overall.

NOTE: You should be able to implement this in pure Java using no imports, helper functions, or collections classes!

Bonus 1

In the above example, child #3 has the same rating as child #2 but gets fewer stars. To be equitable, the number of stars should be {1, 2, 2}, resulting in a total number of 5 stars overall.

Modify the algorithm so that any child with fewer stars than an immediate neighbor with an equal rating gets at least as many stars as that neighbor.
 */

/*
 * NOTE: I implemented bonus requirement as well. The time complexity is O(n) and space complexity is also O(n) 
 */
public class GoldStars
{
  
  public static int countStars(int[] arr) {
      int[] countArr = new int[arr.length];
      countArr[0] = 1;
    
    for (int i=1; i < arr.length; i++) {
      if (arr[i] > arr[i-1]) {
          countArr[i] = countArr[i-1]+1;
      } else if (arr[i] == arr[i-1]) {
        countArr[i] = countArr[i-1];
      } else {
        countArr[i] = 1;
      }
    }
    
    for (int i=arr.length-2; i >=0; i--) {
      if (arr[i] > arr[i+1]) {
        countArr[i] = countArr[i+1]+1;
      } else if (arr[i] == arr[i+1]) {
        countArr[i] = countArr[i+1];
      }
    }
    
    int sum = 0;
    for (int i=0; i < countArr.length; i++) {
      System.out.println(countArr[i]);
      sum += countArr[i];
    }
    
    return sum;
  }  
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    int[] arr = {1, 2, 2};
    System.out.print(countStars(arr));
  }
}