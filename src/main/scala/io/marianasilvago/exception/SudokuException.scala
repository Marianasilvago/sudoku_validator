package io.marianasilvago.exception

final case class SudokuException(private val message: String = "",
                                 private val error: SudokuError = SudokuError("", SudokuErrorType.UNKNOWN_ERROR),
                                 private val cause: Throwable = None.orNull)
  extends Exception(message + error, cause) {
  def getError: SudokuError = error
}