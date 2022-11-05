package io.marianasilvago.exception

import io.marianasilvago.exception

object SudokuErrorType extends Enumeration {
  type SudokuErrorType = Value

  val PARSE_ERROR: exception.SudokuErrorType.Value = Value("PARSE_ERROR")
  val INVALID_BOARD_SHAPE_ERROR: exception.SudokuErrorType.Value = Value("INVALID_SHAPE_BOARD_ERROR")
  val UNKNOWN_ERROR: exception.SudokuErrorType.Value = Value("UNKNOWN_ERROR")
  val INVALID_CELL_VALUE: exception.SudokuErrorType.Value = Value("INVALID_CELL_VALUE")
}
