def countLetterOccurrences(words: List[String]): Int = {
    val wordLengths = words.map(_.length)
    val totalCount = wordLengths.reduce(_ + _)
    totalCount
}

object Main extends App {
    val words = List("apple", "banana", "cherry")
    val result = countLetterOccurrences(words)
    println("Number of letter occurences = " + result)
}