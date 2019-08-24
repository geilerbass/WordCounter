# WordCounter
Analyse a space-separated text file and output a list of words found within and the total count of each word to STDOUT, ordered by the length of word and then alphanumerically.
Words that are substrings of longer words will be ignored; only words that do not 'contain' any other, shorter words will be counted.

## Pre-Requisites
Gradle - this needs to be installed locally to build the project
## Build Instructions
Clone the project locally and run `gradle clean build`
This should create an executable JAR in the `build/libs` directory, called `WordCounter-1.0-SNAPSHOT.jar`.

## Execution
The project can be run as an executable JAR, taking the relative path to the text file for analysis as a single argument, e.g. `java -jar <build-dir>/build/libs/WordCounter-1.0-SNAPSHOT.jar <path-to-file-for-analysis`

## Outstanding
The following items are TODO, were more time permitted: -
- Edge case and exception-handling
-- For example, the application is designed solely for a text file, with words separated by one of more spaces. It handles multiple lines, but has not been designed to delimit by punctuation characters, for example.
- Performance
-- The text-matching algorithim is crude and not performant for larger files, particularly where most words are distinct. It likely has a time complexity of O(N<sup>2</sup>), so is not efficient. With more time, a more efficient algorithm would be implemented.
- Output Options
-- For simplicity, the application outputs to STDOUT, but extension to different output options should be simple, e.g. to an output file
