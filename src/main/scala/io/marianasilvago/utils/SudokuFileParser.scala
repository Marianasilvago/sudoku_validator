package io.marianasilvago.utils

import io.marianasilvago.exception.{SudokuError, SudokuErrorType, SudokuException}
import io.marianasilvago.model.SudokuBoard

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source
import scala.math.sqrt

object SudokuFileParser {
  /**
   * This will parse a given file and return Sudoku board list.
   *
   * @param fileName      Name of the file containing sudoku boards.
   * @param cellSeparator Separator used for separating individual cells.
   * @return Sudoku board list.
   */
  def parse(fileName: String, cellSeparator: Option[String]): List[SudokuBoard] = {
    val sudokuBoards = ListBuffer[SudokuBoard]()
    val bufferedSource = Source.fromFile(fileName)
    val board = ListBuffer[String]()
    val lines = bufferedSource.getLines()
    while (lines.hasNext) {
      val line = lines.next()
      if (line.isBlank || !lines.hasNext) {
        if (!lines.hasNext)
          board.append(line)
        try {
          parseSudokuBoard(board.toList, cellSeparator) match {
            case Some(sudokuBoard) => sudokuBoards.append(sudokuBoard)
            case None => println("Skipping this sudoku board due to parsing error.")
          }
        } catch {
          case ex: SudokuException =>
            println("Skipping this sudoku board due to parsing error.")
            println(s"Error: ${ex.getError.errorType}, Message: ${ex.getError.errorMessages}\n")
        }
        board.clear()
      }
      else {
        board.append(line)
      }
    }
    bufferedSource.close
    sudokuBoards.toList
  }

  @throws(classOf[SudokuException])
  def parseSudokuBoard(board: List[String], cellSeparator: Option[String]): Option[SudokuBoard] = {
    val boardBuffer = ArrayBuffer[Array[Int]]()
    val defaultCellSeparator = ""
    for (row <- board) {
      val cellValues: Array[String] =
        cellSeparator match {
          case Some(str) => row.split(str)
          case None => row.split(defaultCellSeparator)
        }
      val rowBuffer = ArrayBuffer[Int]()
      for (cell <- cellValues) {
        getValidCellOrError(cell, cellValues.length) match {
          case Left(err: SudokuError) => {
            val newBoard = board.map(x => x.replace(cellSeparator.getOrElse(defaultCellSeparator), " "))
            val newErr = SudokuError(err.errorMessages.concat(s"\nInvalid sudoku board:\n${newBoard.mkString(sep = "\n")}"), err.errorType)
            throw SudokuException(error = newErr)
          }
          case Right(x: Int) => rowBuffer.append(x)
        }
      }
      boardBuffer.append(rowBuffer.toArray)
    }
    val boardValues = boardBuffer.toArray
    if ((sqrt(boardValues.length) % 1) != 0) {
      val boardStr = boardValues.map(row => row.mkString(" "))
      val errorMessage = s"Sudoku board is not square. It is of shape(${boardValues.length}, ${boardValues(0).length})." +
        s"\nInvalid sudoku board:\n${boardStr.mkString("\n")}"
      throw SudokuException(error = SudokuError(errorMessage, SudokuErrorType.INVALID_BOARD_SHAPE_ERROR))
    }
    else {
      Option(SudokuBoard(boardBuffer.toArray))
    }
  }

  private def getValidCellOrError(cell: String, boardLength: Int): Either[SudokuError, Int] = {
    try {
      val intTypeCell = cell.toInt
      if (intTypeCell < 0)
        Left(SudokuError("Cell value is less than 0.", SudokuErrorType.PARSE_ERROR))
      else if (intTypeCell > boardLength)
        Left(SudokuError(s"Cell value is greater than board length = $boardLength.", SudokuErrorType.PARSE_ERROR))
      else
        Right(intTypeCell)
    } catch {
      case e: NumberFormatException => Left(SudokuError(e.getMessage, SudokuErrorType.PARSE_ERROR))
    }
  }
}
