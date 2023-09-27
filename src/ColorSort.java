/** Sorting of balls.
 * @since 1.8
 */
public class ColorSort {

   enum Color {red, green, blue};


   public static void main (String[] param) {

   }

   public static void reorder (Color[] balls) {
      // https://www.youtube.com/watch?v=6sMssUHgaBs Quick run down on Dutch national flag problem.

      // Initiate 3 pointers:
      //            start :    pointing at the beginning of the array.
      //            middle:    pointing at the beginning of the array, but moving forward (kinda like the main pointer).
      //            end   :    pointing at the end of the array.
      int start = 0;
      int end = balls.length - 1;
      int middle = 0;

      // Since the middle pointer is the main pointer and moving through the array, the algorithm will finish when the middle pointer meets the end pointer.
      while(end >= middle){
         switch (balls[middle]){
            case red:
               // When the middle pointer hits a red ball (0th section in the expected sorted array) the swap is done with the current (red)ball and the ball at the start pointer.
               // Meaning that the red ball is moved to the start.
               swap(balls, start, middle);
               // Since the swap was done with the starting index, we move the starting index up 1 index noting that the start has moved forward.
               start++;
               // The swap was done move the main pointer forward.
               middle++;
               break;
            case green:
               // Since green is the middle section ball, just move the main(middle) pointer forward.
               middle++;
               break;
            case blue:
               // Blue is the 3rd section ball, we swap it with the end pointer and move the end pointer 1 place backwards noting that the end has moved closer.
               swap(balls, end, middle);
               // Reason for only moving the end closer, is that the ball coming from the end pointer might be either red or green, so we need to rerun it with the middle pointer still pointing at the current pos.
               end--;
               break;
         }

      }
   }

   public static void swap(Color[] arr, int pos1, int pos2){
      Color firstSwappable = arr[pos1];
      arr[pos1] = arr[pos2];
      arr[pos2] = firstSwappable;
   }
}