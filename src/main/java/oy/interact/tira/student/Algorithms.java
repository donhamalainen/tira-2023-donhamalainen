package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   // SWAP METHOD; joka vaihtaa kahden taulukon arvon paikkaa.
   public static <T> void swap(T[] array, int first, int second) {
      T temp = array[first];
      array[first] = array[second];
      array[second] = temp;
   }

   /*
    * Insertion Sort; algorytmi, joka järjestää taulukon pienimmästä suurimapaan.
    */
   public static <T extends Comparable<T>> void insertionSort(T[] array) {
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

   /*
    * Insertion Sort; algorytmi, joka järjestää taulukon fromIndex kohdasta
    * loppukohtaan toIndex pienimmästä suurimpaan
    */
   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
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
      // new insertionSort(T [] array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Student, implement this.
   }

   /*
    * Reversing Insertion Sort; algorytmi järjestää taulukon suurimmasta
    * pienempään.
    */
   public static <T> void reverse(T[] array) {
      // Tämä reverse funktio kääntää koko taulunkon.
      int taulukonPituus = array.length;
      for (int alkio = 0; alkio < taulukonPituus / 2; alkio++) {
         T tallennettuAlkio = array[alkio];
         array[alkio] = array[taulukonPituus - alkio - 1];
         array[taulukonPituus - alkio - 1] = tallennettuAlkio;
      }
   }

   /*
    * Insertion Sort; algorytmi, joka järjestää taulukon fromIndex kohdasta
    * loppukohtaan toIndex suurimpmasta pienimpään.
    */
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
