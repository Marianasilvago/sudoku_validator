package io.marianasilvago.model

import io.marianasilvago.model

object Result extends Enumeration {
  type Result = Value

  val VALID: model.Result.Value = Value("VALID")
  val INVALID: model.Result.Value = Value("INVALID")
}
