package chapter_4

import org.scalatest.{MustMatchers, WordSpecLike}
import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.time.{Millis, Span}

import scala.io.Source
import scala.util.Random._

class Q_1Spec extends WordSpecLike
  with MustMatchers
  with TimeLimitedTests{

  //set a timelimit for each test
  override def timeLimit = Span(50, Millis)

  private val lotOfWords = for {
    i <- 0 to 1e6.toInt
  } yield math.abs(nextLong)

  "parity" must {
    "return 1 for odd word" in {
      val expected = 1
      val actual = Q_1.paritySimple(2L)

      assert(actual == expected)
    }

    "return 0 for even word" in {
      val expected = 0
      val actual = Q_1.paritySimple(3L)

      assert(actual == expected)
    }

    "can calculate a million parities" in {
      //this will fail with the simple parity
      for(w <- lotOfWords){
        Q_1.paritySimple(w)
      }
    }
  }


}
