package io.marianasilvago.utils

import io.marianasilvago.model.{Result, SudokuBoard, ValidationResult}

object SudokuValidator {
  /**
   * Validate sudoku board.
   *
   * @param sudokuBoard [[SudokuBoard]]
   * @return
   */
  def validate(sudokuBoard: SudokuBoard): ValidationResult = {
    val boardLength = sudokuBoard.board.length
    val occurrencesInRows = Array.fill(boardLength) {
      Array.fill(boardLength) {
        false
      }
    }
    val occurrencesInCols = Array.fill(boardLength) {
      Array.fill(boardLength) {
        false
      }
    }
    val occurrencesInSubBox = Array.fill(boardLength) {
      Array.fill(boardLength) {
        false
      }
    }

    for (row <- 0 until boardLength) {
      for (col <- 0 until boardLength) {
        if (sudokuBoard.getCellValue(row, col) != 0) {
          val cellValue = sudokuBoard.getCellValue(row, col) - 1;
          if (occurrencesInRows(row)(col) ||
            occurrencesInCols(row)(col) ||
            occurrencesInSubBox(((row / 3) * 3) + (col / 3))(cellValue)) {
            val reasonOfInvalidity = s"Invalid value found at cell($row, $col) = ${sudokuBoard.getCellValue(row, col)}." +
              s"\nSudoku board:\n$sudokuBoard"
            return ValidationResult(Result.INVALID, reasonOfInvalidity)
          }
          else {
            occurrencesInRows(row)(col) = true
            occurrencesInCols(row)(col) = true
            occurrencesInSubBox(((row / 3) * 3) + (col / 3))(cellValue) = true
          }
        }
      }
    }
    ValidationResult(Result.VALID, s"Sudoku board is valid. \nSudoku board:\n$sudokuBoard")
  }
}
