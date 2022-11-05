package io.marianasilvago.model

import scala.collection.mutable
import scala.math.sqrt

case class SudokuBoard(board: Array[Array[Int]]) {
  private val boardCardinality = sqrt(board.length).toInt

  /**
   * Return cell value of the sudoku board.
   *
   * @param row row index.
   * @param col column index.
   * @return cell value of the sudoku board.
   */
  def getCellValue(row: Int, col: Int): Int = {
    board(row)(col)
  }

  override def toString: String = {
    val boardSideLength = boardCardinality * boardCardinality
    val separator = if (boardCardinality <= 3) ' ' else '\t'
    val horizontalSeparator = getHorizontalSeparator(separator)
    val stringBuilder = new mutable.StringBuilder()
    for (row <- 0 until boardSideLength) {
      for (col <- 0 until boardSideLength) {
        stringBuilder.append(s"${getCellValue(row, col)}$separator")
        if ((col % boardCardinality) == (boardCardinality - 1) &&
          col != (boardSideLength - 1))
          stringBuilder.append(s"|$separator")
      }
      stringBuilder.append("\n")
      if ((row % boardCardinality) == (boardCardinality - 1) &&
        row != (boardSideLength - 1)) {
        stringBuilder.append(s"$horizontalSeparator")
        stringBuilder.append("\n")
      }
    }
    stringBuilder.toString()
  }

  private def getHorizontalSeparator(separator: Char): String = {
    val stringBuilder = new mutable.StringBuilder()
    for (_ <- 1 to (boardCardinality * boardCardinality + (boardCardinality - 1)))
      stringBuilder.append(s"-$separator")
    stringBuilder.toString()
  }
}
