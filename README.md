# ScalaTest AnyFunSpec it print issue

The related github issue: https://github.com/scalatest/scalatest/issues/1876
Versions that fix the behavior at the time of this commit: 3.2.2-M1, 3.2.2-M2 

This bug is reproducible with the `scalatest v3.2.1` only. `3.2.0` works as expected.

* `org.scalatest.funspec.AnyFunSpec` does not print the `it { }` blocks title in case it runs for a longer than `~2 seconds`.
* The test project contains some primitive assertions (even without `Matchers` usage). 
* [FirstSpec](./silent/src/test/scala/com/pomadchin/FirstSpec.scala) contains specs with the `Thread.sleep(2000)` calls before the assertion (emulation of a long work).
* [SecondSpec](./silent/src/test/scala/com/pomadchin/SecondSpec.scala) is the [FirstSpec](./silent/src/test/scala/com/pomadchin/FirstSpec.scala) copy but without `Thread.sleep(2000)`.
* To reproduce the behavior run `sbt silent/test`
* The expected behavior: both tests suits should print the same outputs.
* The current bahavior: scalatest silents all prints of the `it { }` blocks. The example of such output is shown below.

`describe` block titles printing works as expected.

### Output: 

```scala
sbt:silent> test
[info] Compiling 1 Scala source to /Users/daunnc/subversions/git/github/pomadchin/scalatest-silent/silent/target/scala-2.12/test-classes ...
[info] SecondSpec:
[info] SecondSpec with no Thread.sleep(2000)
[info] - true = false *** FAILED *** (33 milliseconds)
[info]   true was not equal to false (SecondSpec.scala:10)
[info] - true = true (1 millisecond)
[info] - 1 = 2 *** FAILED *** (1 millisecond)
[info]   1 was not equal to 2 (SecondSpec.scala:16)
[info] - 1 = 1 (1 millisecond)
[info] - '1' = '2' *** FAILED *** (2 milliseconds)
[info]   "[1]" was not equal to "[2]" (SecondSpec.scala:22)
[info] - '1' = '1' (0 milliseconds)
[info] SecondSpec#2
[info] - true = false // #2 *** FAILED *** (1 millisecond)
[info] - true = true // #2 (0 milliseconds)
[info] - 1 = 2 // #2 *** FAILED *** (1 millisecond)
[info]   1 was not equal to 2 (SecondSpec.scala:37)
[info] - 1 = 1 // #2 (1 millisecond)
[info] - '1' = '2' // #2 *** FAILED *** (1 millisecond)
[info]   "[1]" was not equal to "[2]" (SecondSpec.scala:43)
[info] - '1' = '1' // #2 (1 millisecond)
[info] FirstSpec:
[info] FirstSpec with Thread.sleep(2000)
[info] Run completed in 25 seconds, 347 milliseconds.
[info] Total number of tests run: 24
[info] Suites: completed 2, aborted 0
[info] Tests: succeeded 12, failed 12, canceled 0, ignored 0, pending 0
[info] *** 12 TESTS FAILED ***
[error] Failed tests:
[error] 	com.pomadchin.SecondSpec
[error] 	com.pomadchin.FirstSpec
[error] (Test / test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 26 s, completed Aug 17, 2020 9:06:18 PM
```
