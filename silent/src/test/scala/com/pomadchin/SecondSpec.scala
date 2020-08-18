package com.pomadchin

import org.scalatest.funspec.AnyFunSpec

class SecondSpec extends AnyFunSpec {
  it("true = false") {
    assert(true == false)
  }
  it("true = true") {
    assert(true == true)
  }
  it("1 = 2") {
    assert(1 == 2)
  }
  it("1 = 1") {
    assert(1 == 1)
  }
  it("'1' = '2'") {
    assert("1" == "2")
  }
  it("'1' = '1'") {
    assert("1" == "1")
  }

  it("true = false // #2") {
    assert(true == false)
  }
  it("true = true // #2") {
    assert(true == true)
   }
  it("1 = 2 // #2") {
    assert(1 == 2)
  }
  it("1 = 1 // #2") {
    assert(1 == 1)
  }
  it("'1' = '2' // #2") {
    assert("1" == "2")
  }
  it("'1' = '1' // #2") {
    assert("1" == "1")
  }
}
