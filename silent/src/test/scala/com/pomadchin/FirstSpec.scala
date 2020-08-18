package com.pomadchin

import org.scalatest.funspec.AnyFunSpec

class FirstSpec extends AnyFunSpec {
  it("true = false") {
    Thread.sleep(2000)
    assert(true == false)
  }
  it("true = true") {
    Thread.sleep(2000)
    assert(true == true)
  }
  it("1 = 2") {
    Thread.sleep(2000)
    assert(1 == 2)
  }
  it("1 = 1") {
    Thread.sleep(2000)
    assert(1 == 1)
  }
  it("'1' = '2'") {
    Thread.sleep(2000)
    assert("1" == "2")
  }
  it("'1' = '1'") {
    Thread.sleep(2000)
    assert("1" == "1")
  }

  it("true = false // #2") {
    Thread.sleep(2000)
    assert(true == false)
  }
  it("true = true // #2") {
    Thread.sleep(2000)
    assert(true == true)
   }
  it("1 = 2 // #2") {
    Thread.sleep(2000)
    assert(1 == 2)
  }
  it("1 = 1 // #2") {
    Thread.sleep(2000)
    assert(1 == 1)
  }
  it("'1' = '2' // #2") {
    Thread.sleep(2000)
    assert("1" == "2")
  }
  it("'1' = '1' // #2") {
    Thread.sleep(2000)
    assert("1" == "1")
  }
}
