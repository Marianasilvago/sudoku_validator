package io.marianasilvago.exception

import io.marianasilvago.exception.SudokuErrorType.SudokuErrorType

case class SudokuError(errorMessages: String = "", errorType: SudokuErrorType = SudokuErrorType.UNKNOWN_ERROR) {}
