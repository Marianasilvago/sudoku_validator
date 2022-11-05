package io.marianasilvago.utils

import io.marianasilvago.exception.{SudokuErrorType, SudokuException}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class SudokuFileParserTest extends AnyFlatSpec with Matchers {
  val validSudoku = "src/test/resources/sudoku_test_all_valid.txt"
  val invalidSudokuWithAlphabets: List[String] = List(
    "2,0,0,0,8,0,3,0,0",
    "0,aa,0,0,7,0,0,8,4",
    "0,3,0,b,0,0,2,0,9",
    "0,0,0,1,0,5,4,0,8",
    "0,dd,0,0,0,0,0,0,0",
    "4,0,2,7,c,6,0,0,0",
    "3,0,1,0,0,7,0,4,0",
    "7,2,0,0,4,0,0,6,0",
    "0,0,4,0,1,0,0,0,3"
  )
  val invalidSudokuWithInvalidNumbers: List[String] = List(
    "0,0,3,0,2,0,6,0,0",
    "9,0,0,3,0,5,0,0,1",
    "0,0,1,8,0,6,4,0,0",
    "0,0,8,1,0,2,9,0,0",
    "7,0,0,10,0,0,0,0,8",
    "0,0,6,7,0,8,2,0,0",
    "0,0,2,6,0,9,5,0,0",
    "8,0,0,2,0,3,0,0,9",
    "0,0,5,0,1,0,3,0,0"
  )
  val invalidSudokuWithNegativeNumbers: List[String] = List(
    "0,0,3,0,2,0,6,0,0",
    "9,0,0,3,0,5,0,0,1",
    "0,0,-1,8,0,6,4,0,0",
    "0,0,8,1,0,2,9,0,0",
    "7,0,0,0,0,0,0,0,8",
    "0,0,6,7,0,8,2,0,0",
    "0,0,2,6,0,9,5,0,0",
    "8,0,0,2,0,3,0,0,9",
    "0,0,5,0,1,0,3,0,0"
  )
  val invalidSudokuWithInvalidShape: List[String] = List(
    "0,0,3,0,2,0,6,0,0",
    "9,0,0,3,0,5,0,0,1",
    "0,0,1,8,0,6,4,0,0",
    "0,0,8,1,0,2,9,0,0",
    "7,0,0,0,0,0,0,0,8",
    "0,0,6,7,0,8,2,0,0",
    "0,0,2,6,0,9,5,0,0",
    "8,0,0,2,0,3,0,0,9"
  )

  "Sudoku parser " should "parse valid sudoku board" in {
    val sudokuBoards = SudokuFileParser.parse(validSudoku, Option(","))
    sudokuBoards(0).board should equal(SudokuConstants.VALID_SUDOKU_BOARD_1.board)
    sudokuBoards(1).board should equal(SudokuConstants.VALID_SUDOKU_BOARD_2.board)
    sudokuBoards should have length 2
  }

  it should "throw error on invalid sudoku board with alphabets" in {
    val exceptionCaught = intercept[SudokuException] {
      SudokuFileParser.parseSudokuBoard(invalidSudokuWithAlphabets, Option(","))
    }
    exceptionCaught.getError.errorType shouldEqual SudokuErrorType.PARSE_ERROR
    exceptionCaught.getError.errorMessages shouldEqual "For input string: \"aa\"\n" +
      "Invalid sudoku board:\n" +
      "2 0 0 0 8 0 3 0 0\n" +
      "0 aa 0 0 7 0 0 8 4\n" +
      "0 3 0 b 0 0 2 0 9\n" +
      "0 0 0 1 0 5 4 0 8\n" +
      "0 dd 0 0 0 0 0 0 0\n" +
      "4 0 2 7 c 6 0 0 0\n" +
      "3 0 1 0 0 7 0 4 0\n" +
      "7 2 0 0 4 0 0 6 0\n" +
      "0 0 4 0 1 0 0 0 3"
  }

  it should "throw error on invalid sudoku board with invalid numbers" in {
    val exceptionCaught = intercept[SudokuException] {
      SudokuFileParser.parseSudokuBoard(invalidSudokuWithInvalidNumbers, Option(","))
    }
    exceptionCaught.getError.errorType shouldEqual SudokuErrorType.PARSE_ERROR
    exceptionCaught.getError.errorMessages shouldEqual "Cell value is greater than board length = 9.\n" +
      "Invalid sudoku board:\n" +
      "0 0 3 0 2 0 6 0 0\n" +
      "9 0 0 3 0 5 0 0 1\n" +
      "0 0 1 8 0 6 4 0 0\n" +
      "0 0 8 1 0 2 9 0 0\n" +
      "7 0 0 10 0 0 0 0 8\n" +
      "0 0 6 7 0 8 2 0 0\n" +
      "0 0 2 6 0 9 5 0 0\n" +
      "8 0 0 2 0 3 0 0 9\n" +
      "0 0 5 0 1 0 3 0 0"
  }

  it should "throw error on invalid sudoku board with negative numbers" in {
    val exceptionCaught = intercept[SudokuException] {
      SudokuFileParser.parseSudokuBoard(invalidSudokuWithNegativeNumbers, Option(","))
    }
    exceptionCaught.getError.errorType shouldEqual SudokuErrorType.PARSE_ERROR
    exceptionCaught.getError.errorMessages shouldEqual "Cell value is less than 0.\n" +
      "Invalid sudoku board:\n" +
      "0 0 3 0 2 0 6 0 0\n" +
      "9 0 0 3 0 5 0 0 1\n" +
      "0 0 -1 8 0 6 4 0 0\n" +
      "0 0 8 1 0 2 9 0 0\n" +
      "7 0 0 0 0 0 0 0 8\n" +
      "0 0 6 7 0 8 2 0 0\n" +
      "0 0 2 6 0 9 5 0 0\n" +
      "8 0 0 2 0 3 0 0 9\n" +
      "0 0 5 0 1 0 3 0 0"
  }

  it should "throw error on invalid sudoku board with invalid shape" in {
    val exceptionCaught = intercept[SudokuException] {
      SudokuFileParser.parseSudokuBoard(invalidSudokuWithInvalidShape, Option(","))
    }
    exceptionCaught.getError.errorType shouldEqual SudokuErrorType.INVALID_BOARD_SHAPE_ERROR
    exceptionCaught.getError.errorMessages shouldEqual "Sudoku board is not square. It is of shape(8, 9).\n" +
      "Invalid sudoku board:\n" +
      "0 0 3 0 2 0 6 0 0\n" +
      "9 0 0 3 0 5 0 0 1\n" +
      "0 0 1 8 0 6 4 0 0\n" +
      "0 0 8 1 0 2 9 0 0\n" +
      "7 0 0 0 0 0 0 0 8\n" +
      "0 0 6 7 0 8 2 0 0\n" +
      "0 0 2 6 0 9 5 0 0\n" +
      "8 0 0 2 0 3 0 0 9"
  }
}
