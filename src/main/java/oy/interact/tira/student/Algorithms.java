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
      int alinPiste = fromIndex;
      int korkeinPiste = toIndex - 1;

      // Iteratiivinen

      while (alinPiste <= korkeinPiste) {
         int keskiPiste = alinPiste + (korkeinPiste - alinPiste) / 2;
         if (fromArray[keskiPiste].compareTo(aValue) == 0) {
            return keskiPiste;
         } else if (fromArray[keskiPiste].compareTo(aValue) < 0) {
            alinPiste = keskiPiste + 1;
         } else {
            korkeinPiste = keskiPiste - 1;
         }
      }

      // Rekurssiivinen
      /*
       * if (alinPiste <= korkeinPiste) {
       * int keskiPiste = alinPiste + (korkeinPiste - alinPiste) / 2;
       * if (fromArray[keskiPiste].compareTo(aValue) == 0) {
       * return keskiPiste;
       * } else if (fromArray[keskiPiste].compareTo(aValue) < 0) {
       * return binarySearch(aValue, fromArray, keskiPiste + 1, toIndex);
       * } else {
       * return binarySearch(aValue, fromArray, fromIndex, keskiPiste - 1);
       * }
       * }
       */

      return -1; // aValue eli haluttua arvoa ei löytynyt taulukosta.
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      int alinPiste = fromIndex;
      int korkeinPiste = toIndex - 1;
      // Iteratiivinen
      while (alinPiste <= korkeinPiste) {
         int keskiPiste = alinPiste + (korkeinPiste - alinPiste) / 2;
         int vertailija = comparator.compare(fromArray[keskiPiste], aValue);
         // Ehtolause
         if (vertailija == 0) {
            return keskiPiste;
            // Jos negatiivinen
         } else if (vertailija < 0) {
            alinPiste = keskiPiste + 1;
            // Jos muutoin positiivinen
         } else {
            korkeinPiste = keskiPiste - 1;
         }
      }

      // Rekurssiivinen

      return -1; // aValue:ta ei löytynyt taulukosta
   }

   // FASTSORT COMPARABLE
   public static <E extends Comparable<E>> void fastSort(E[] array) {
      // TODO: Student, implement this.
      quickSort(array, 0, array.length - 1, Comparator.naturalOrder());
   }

   // FASTSORT COMPARATOR
   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
      quickSort(array, comparator);
   }

   // FASTSORT COMPARATOR with Indexes
   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
      quickSort(array, fromIndex, toIndex - 1, comparator);
   }

   // PARTITION
   private static <E> int partition(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // Käytä viimeistä elementtiä pivotina
      E pivot = array[toIndex];
      int edellinen_alkio = fromIndex - 1;

      for (int alkio = fromIndex; alkio < toIndex; alkio++) {
         if (comparator.compare(array[alkio], pivot) <= 0) {
            edellinen_alkio++;

            // vaihdetaan paikkoja
            swap(array, alkio, edellinen_alkio);
         }
      }

      // Vaihdetaan pivot oikeaan paikkaan jälkeen viimeisen "pienemmän" alkion
      swap(array, edellinen_alkio + 1, toIndex);

      return edellinen_alkio + 1; // Palautetaan pivotin uusi indeksi
   }

   ///////////////////////////////////////////
   // Q U I C K S O R T
   ///////////////////////////////////////////
   public static <E> void quickSort(E[] array, Comparator<E> comparator) {
      quickSort(array, 0, array.length - 1, comparator);
   }

   public static <E> void quickSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (fromIndex < toIndex) {
         int partitionIndex = partition(array, fromIndex, toIndex, comparator);

         quickSort(array, fromIndex, partitionIndex - 1, comparator);
         quickSort(array, partitionIndex + 1, toIndex, comparator);
      }
   }
   ///////////////////////////////////////////
   // H E A P S O R T
   ///////////////////////////////////////////

   ///////////////////////////////////////////
   // M E R G E S O R T
   ///////////////////////////////////////////
}
