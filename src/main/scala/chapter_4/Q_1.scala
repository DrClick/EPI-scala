package chapter_4

import scala.annotation.tailrec

object Q_1 {

  def paritySimple(word: Long): Int = {

    //recursively solve this in O(n) time
    def loop(x: Long, result: Int): Int = {
      if (x == 0) result
      else {
        //XOR is a great way to switch between 0 and 1
        //if the current parity is zero, and the current lowest bit is zero, the parity
        //is still zero. If the current parity is 1 and the lowest bit is 1, we know
        //that currently the parity is now zero (we have an even number of 1s).
        //repeat through the whole string
        val lowestBitSet: Int = (x & 1).toInt //this will be 0 or 1
        val wordShiftedRightBy1 = x >> 1
        val currentParity = result ^ lowestBitSet

        loop(wordShiftedRightBy1, currentParity)

        //this whole thing could have been written a bit more concisely as
        //loop(x >> 1, result ^ (x & 1).toInt)
      }
    }

    loop(word, 0)
  }

  def parityLowestBitErase(word: Long): Long = {
    @tailrec
    def loop(x: Long, result: Long): Long = {
      if (x == 0) return result
      val lowestBitSet = x & 1
      val xLowestBitErased = x & (x - 1)

      loop(xLowestBitErased, result ^ lowestBitSet)

    }

    loop(word, 0).toInt
  }
}
