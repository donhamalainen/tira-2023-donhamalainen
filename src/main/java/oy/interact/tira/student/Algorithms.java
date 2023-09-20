package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   // SWAP METHOD; joka vaihtaa kahden taulukon arvon paikkaa.
   public static <T> void swap(T[] array, int first, int second) {
      final T temp = array[first];
      array[first] = array[second];
      array[second] = temp;
   }

   // INSERTIONSORT
   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
   }

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int tarkasteltava_alkio = fromIndex + 1; tarkasteltava_alkio < toIndex; tarkasteltava_alkio++) {
         T alkio = array[tarkasteltava_alkio];
         int edellinen_alkio = tarkasteltava_alkio - 1;
         // Aloitetaan järjestäminen vasemmalle puolelle
         while (edellinen_alkio >= fromIndex && array[edellinen_alkio].compareTo(alkio) > 0) {
            swap(array, edellinen_alkio, edellinen_alkio + 1);
            edellinen_alkio--;
         }
      }
   }

   // INSERTIONSORT END
   // COMPARATOR INSERTIONSORT
   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);
   }

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int tarkasteltava_alkio = fromIndex; tarkasteltava_alkio < toIndex; tarkasteltava_alkio++) {
         T alkio = array[tarkasteltava_alkio];
         int edellinen_alkio = tarkasteltava_alkio - 1;
         while (edellinen_alkio >= 0 && alkio != null && comparator.compare(array[edellinen_alkio], alkio) > 0) {
            swap(array, edellinen_alkio, edellinen_alkio + 1);
            edellinen_alkio--;
         }
      }
   }

   // COMPARATOR INSERTIONSORT END
   // REVERSE
   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      for (int tarkasteltava_alkio = fromIndex; tarkasteltava_alkio < toIndex / 2; tarkasteltava_alkio++) {
         swap(array, tarkasteltava_alkio, (toIndex - 1 - tarkasteltava_alkio));
      }
   }
   // REVERSE END

   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return -1;
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

}
