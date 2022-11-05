package io.marianasilvago

import io.marianasilvago.exception.SudokuErrorType
import io.marianasilvago.model.{Result, SudokuBoard}
import io.marianasilvago.utils.{ArgumentParser, SudokuFileParser, SudokuValidator}


object SudokuValidatorApp {
  private val CELL_SEPARATOR = ","

  def main(args: Array[String]): Unit = {
    val appOption = ArgumentParser.getOptions(args)
    val sudokuBoards: List[SudokuBoard] = SudokuFileParser.parse(appOption.fileName, Option(CELL_SEPARATOR))

    for (sudokuBoard <- sudokuBoards) {
      val validationResult = SudokuValidator.validate(sudokuBoard)
      println(validationResult.result)
      validationResult.result match {
        case Result.VALID => println(s"${validationResult.reason}\n")
        case Result.INVALID => println(s"Error: ${SudokuErrorType.INVALID_CELL_VALUE}, Message: ${validationResult.reason}\n")
      }
    }

  }

}
