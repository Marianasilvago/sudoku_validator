package io.marianasilvago.model

import picocli.CommandLine

class AppOption {
  @CommandLine.Option(names = Array("-f", "--file"), description = Array("file containing sudoku samples"), required = true)
  var fileName: String = _
}
