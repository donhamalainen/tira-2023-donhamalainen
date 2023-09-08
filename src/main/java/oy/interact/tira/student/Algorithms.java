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
       * TODO: lajittelee koko taulukon luonnolliseen järjestykseen. Voit olettaa
       * ettei taulukossa ole null:eja.
       */

      /*
       * Aloitetaan käymällä taulukon alkioita läpi. Otetaan ensiksi ensimmäinen alkio
       * jota verrataan seuraavaan alkioon.
       */
      for (int i = 1; i < array.length; i++) {
         T tarkasteltava_alkio = array[i];
         // Edeltävä alkio.
         int j = i - 1;
         // Lähdetään vertailemaan tarkasteltavaa alkiota muihin alkioihin.
         while (j >= 0 && array[j].compareTo(tarkasteltava_alkio) > 0) {
            // Siirretään tarkasteltava alkio yhden alkion verran oikealle.
            array[j + 1] = array[j];
            // Vähennetään
            j--;
         }
         // Asetetaan alkio oikeaan paikkaan
         array[i + 1] = tarkasteltava_alkio;
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      // TODO: lajittelee taulukon luonnolliseen järjestykseen annettujen indeksien
      // välillä. Voit olettaa ettei taulukossa ole annetulla indeksivälillä null:eja.

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
      // TODO: Student, implement this.
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
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
