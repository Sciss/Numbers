/*
 *  FloatFunctions2.scala
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

/** Less common functions for `Float` values. */
object FloatFunctions2 {
  // -------- unary ops --------

  @inline def not       (f: Float): Float = if (f > 0f) 0f else 1f
  @inline def neg       (f: Float): Float = -f

  @inline def cubed     (f: Float): Float = f * f * f
  @inline def reciprocal(f: Float): Float = 1f / f

  @inline def distort   (f: Float): Float = f / (1 + math.abs(f))

  @inline def softclip  (f: Float): Float = {
    val absx = math.abs(f)
    if (absx <= 0.5f) f else (absx - 0.25f) / f
  }

  @inline def ramp      (f: Float): Float = if (f <= 0) 0 else if (f >= 1) 1 else f
  @inline def scurve    (f: Float): Float = if (f <= 0) 0 else if (f >  1) 1 else f * f * (3 - 2 * f)

  // -------- binary ops --------

  @inline def ring1   (a: Float, b: Float): Float = a * b + a
  @inline def ring2   (a: Float, b: Float): Float = a * b + a + b
  @inline def ring3   (a: Float, b: Float): Float = a * a * b

  @inline def ring4   (a: Float, b: Float): Float = {
    val ab = a * b
    a * ab - b * ab
  }

  @inline def thresh  (a: Float, b: Float): Float = if (a < b) 0f else a
  @inline def amclip  (a: Float, b: Float): Float = if (b <= 0f) 0f else a * b
  @inline def scaleneg(a: Float, b: Float): Float = (math.abs(a) - a) * (0.5f * b + 0.5f) + a
}