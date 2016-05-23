# Usage

## Getting Gradle

If you need Gradle, [visit their downloads page first](https://gradle.org/gradle-download/) and install the binaries. The installation process should also set up any environment or shell variables for you. You can verify by trying to call `gradle`.

## Running Cucumber/Serenity tests

Navigate to ../test/serenity folder and run from the command line:

`
gradle clean test aggregate
`

The Cucumber test output (includes stacktrace, if build errors occurred) can be found at 

`
serenity/build/reports/tests/index.html
`

The Serenity test reports are at

`
serenity/target/site/serenity/index.html
`