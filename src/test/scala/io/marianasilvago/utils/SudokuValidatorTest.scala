package io.marianasilvago.utils

import io.marianasilvago.model.Result
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SudokuValidatorTest extends AnyFlatSpec with Matchers {
  "Sudoku validator" should "validate valid sudoku board" in {
    val validationResult = SudokuValidator.validate(SudokuConstants.VALID_SUDOKU_BOARD_3)
    validationResult.result shouldBe Result.VALID
  }

  it should "invalidate invalid sudoku board" in {
    val validationResult = SudokuValidator.validate(SudokuConstants.INVALID_SUDOKU_BOARD_1)
    validationResult.result shouldBe Result.INVALID
  }
}
