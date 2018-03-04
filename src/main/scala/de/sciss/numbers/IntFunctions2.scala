/*
 *  IntFunctions2.scala
 *  (Numbers)
 *
 *  Copyright (c) 2013-2018 Hanns Holger Rutz. All rights reserved.
 *
 *	This software is published under the GNU Lesser General Public License v2.1+
 *
 *
 *  For further information, please contact Hanns Holger Rutz at
 *  contact@sciss.de
 */

package de.sciss.numbers

import de.sciss.numbers.{IntFunctions => ri, DoubleFunctions => rd}

/** Less common functions for `Int` values. */
object IntFunctions2 {
  @inline def cubed   (a: Int): Long  = { val n = a.toLong; n * n * n }

  @inline def difsqr  (a: Int, b: Int): Long = {
    val an = a.toLong
    val bn = b.toLong
    an * an - bn * bn
  }

  @inline def sumsqr  (a: Int, b: Int): Long = {
    val an = a.toLong
    val bn = b.toLong
    an * an + bn * bn
  }

  @inline def sqrsum  (a: Int, b: Int): Long = {
    val z = a.toLong + b.toLong
    z * z
  }

  @inline def sqrdif  (a: Int, b: Int): Long = {
    val z = a.toLong - b.toLong
    z * z
  }

  @inline def absdif  (a: Int, b: Int): Int = math.abs(a - b) // XXX TODO -- may overflow

  @inline def roundTo   (a: Int, b: Int): Int = rd.roundTo(a, b).toInt
  @inline def roundUpTo (a: Int, b: Int): Int = ri.div(a + b - 1, b) * b
  @inline def trunc     (a: Int, b: Int): Int = ri.div(a, b) * b
}
