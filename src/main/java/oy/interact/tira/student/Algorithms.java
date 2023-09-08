package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      /*
       * Tämä insertion sort algorytmi toimii seuraavanlaisesti.
       * Olen ikäänkuin jakanut tarkasteltavasta alkiosta katsottuna sen oikean puolen
       * järjestättömiiin alkioihin ja vasemman järjestettyihin.
       * algormytmi laajenaa ja tarkastelee aina vasemmanpuoleista järjesteltyjä
       * alkioiden tilannetta lisäämällä aina sinne yhden alkion.
       */

      for (int tarkasteltava_alkio = 1; tarkasteltava_alkio < array.length; tarkasteltava_alkio++) {
         T alkio = array[tarkasteltava_alkio];
         int edellinen_alkio = tarkasteltava_alkio - 1;
         // Aloitetaan järjestäminen vasemmalle puolelle
         while (edellinen_alkio >= 0 && array[edellinen_alkio].compareTo(alkio) > 0) {
            array[edellinen_alkio + 1] = array[edellinen_alkio];
            edellinen_alkio--;
         }
         // Asetetaan
         array[edellinen_alkio + 1] = alkio;
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      /*
       * Tämä insertion sort algorytmi toimii samalla periaattella kuin ylhäällä
       * näkyvä insertion sort algorytmi. Erona on että funktioon asetetut fromIndex
       * ja toIndex parametrien väli sortataan eikä koko taulukkoa.
       */
      for (int tarkasteltava_alkio = fromIndex + 1; tarkasteltava_alkio < toIndex; tarkasteltava_alkio++) {
         T alkio = array[tarkasteltava_alkio];
         int edellinen_alkio = tarkasteltava_alkio - 1;
         // Aloitetaan järjestäminen vasemmalle puolelle
         while (edellinen_alkio >= fromIndex && array[edellinen_alkio].compareTo(alkio) > 0) {
            array[edellinen_alkio + 1] = array[edellinen_alkio];
            edellinen_alkio--;
         }
         // Asetetaan
         array[edellinen_alkio + 1] = alkio;
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      // TODO: Student, implement this.
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Student, implement this.
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      // Tämä reverse funktio kääntää koko taulunkon.
      int taulukonPituus = array.length;
      for (int alkio = 0; alkio < taulukonPituus / 2; alkio++) {
         T tallennettuAlkio = array[alkio];
         array[alkio] = array[taulukonPituus - alkio - 1];
         array[taulukonPituus - alkio - 1] = tallennettuAlkio;
      }
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Kääntää koko taulukon ympäri.
      int taulukonPituus = array.length - toIndex + 1;
      for (int alkio = fromIndex; alkio < taulukonPituus / 2; alkio++) {
         T tallennettuAlkio = array[alkio];
         array[alkio] = array[taulukonPituus - alkio - 1];
         array[taulukonPituus - alkio - 1] = tallennettuAlkio;
      }
   }

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
