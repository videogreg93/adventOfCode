fun main(args: Array<String>) {
    Day03.partTwo()
}

object Day03 {
    private fun getPriority(c: Char): Int {
        val code = c.code
        return if (code <= 90) {
            code - 38
        } else {
            code - (96)
        }
    }

    fun partOne() {
        val sum = readLines("3").fold(0) { acc, line ->
            val left = line.subSequence(0, line.length/2)
            val right = line.substring(line.length/2)
            val item = left.first {
                right.contains(it)
            }
            acc + getPriority(item)
        }
        println(sum)
    }

    fun partTwo() {
        val sum = readLines("3").chunked(3).fold(0) { acc, group ->
            val item = group.first().first { char ->
                group.drop(1).all { line ->
                    line.contains(char)
                }
            }
            acc + getPriority(item)
        }
        println(sum)
    }
}