package io.marianasilvago.model

import org.scalatest.flatspec.AnyFlatSpec

class SudokuBoardTest extends AnyFlatSpec {
  val boardValues: Array[Array[Int]] = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9),
  )
  val board = SudokuBoard(boardValues)
  "A sudoku board (0-indexed)" should "have 2 in cell (1, 2)" in {
    assert(board.getCellValue(1, 2) == 2)
  }
  it should "not have 8 in cell (8, 8)" in {
    assert(board.getCellValue(8, 8) != 8)
  }

  it should "have proper string representation of sudoku board" in {
    val expectedBoardStr = "5 3 4 | 6 7 8 | 9 1 2 \n" +
      "6 7 2 | 1 9 5 | 3 4 8 \n" +
      "1 9 8 | 3 4 2 | 5 6 7 \n" +
      "- - - - - - - - - - - \n" +
      "8 5 9 | 7 6 1 | 4 2 3 \n" +
      "4 2 6 | 8 5 3 | 7 9 1 \n" +
      "7 1 3 | 9 2 4 | 8 5 6 \n" +
      "- - - - - - - - - - - \n" +
      "9 6 1 | 5 3 7 | 2 8 4 \n" +
      "2 8 7 | 4 1 9 | 6 3 5 \n" +
      "3 4 5 | 2 8 6 | 1 7 9 \n"
    assert(board.toString == expectedBoardStr)
  }
}
