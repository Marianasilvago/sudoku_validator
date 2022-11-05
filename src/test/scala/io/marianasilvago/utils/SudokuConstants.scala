package io.marianasilvago.utils

import io.marianasilvago.model.SudokuBoard

object SudokuConstants {
  val VALID_SUDOKU_BOARD_1: SudokuBoard = SudokuBoard(Array(
    Array(0, 0, 3, 0, 2, 0, 6, 0, 0),
    Array(9, 0, 0, 3, 0, 5, 0, 0, 1),
    Array(0, 0, 1, 8, 0, 6, 4, 0, 0),
    Array(0, 0, 8, 1, 0, 2, 9, 0, 0),
    Array(7, 0, 0, 0, 0, 0, 0, 0, 8),
    Array(0, 0, 6, 7, 0, 8, 2, 0, 0),
    Array(0, 0, 2, 6, 0, 9, 5, 0, 0),
    Array(8, 0, 0, 2, 0, 3, 0, 0, 9),
    Array(0, 0, 5, 0, 1, 0, 3, 0, 0),
  ))

  val VALID_SUDOKU_BOARD_2: SudokuBoard = SudokuBoard(Array(
    Array(2, 0, 0, 0, 8, 0, 3, 0, 0),
    Array(0, 6, 0, 0, 7, 0, 0, 8, 4),
    Array(0, 3, 0, 5, 0, 0, 2, 0, 9),
    Array(0, 0, 0, 1, 0, 5, 4, 0, 8),
    Array(0, 0, 0, 0, 0, 0, 0, 0, 0),
    Array(4, 0, 2, 7, 0, 6, 0, 0, 0),
    Array(3, 0, 1, 0, 0, 7, 0, 4, 0),
    Array(7, 2, 0, 0, 4, 0, 0, 6, 0),
    Array(0, 0, 4, 0, 1, 0, 0, 0, 3),
  ))

  val VALID_SUDOKU_BOARD_3: SudokuBoard = SudokuBoard(Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9),
  ))

  val INVALID_SUDOKU_BOARD_1: SudokuBoard = SudokuBoard(Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 8, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9),
  ))
}
