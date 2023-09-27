/** Sorting of balls.
 * @since 1.8
 */
public class ColorSort {

   enum Color {red, green, blue};

   public static void main (String[] param) {
      // Test or use the reorder method here
   }

   public static void reorder (Color[] balls) {
      // Implementing the Dutch national flag problem for three-way partitioning.
      int start = 0;
      int middle = 0;
      int end = balls.length - 1;

      while (middle <= end) {
         switch (balls[middle]) {
            case red:
               swap(balls, start++, middle++);
               break;
            case green:
               middle++;
               break;
            case blue:
               swap(balls, middle, end--);
               break;
         }
      }
   }

   private static void swap(Color[] balls, int pos1, int pos2) {
      Color temp = balls[pos1];
      balls[pos1] = balls[pos2];
      balls[pos2] = temp;
   }
}
