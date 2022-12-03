import java.io.File

fun main(args: Array<String>) {
    partOne()
    partTwo()
}

fun partOne() {
    val input = readLines("1")
    val summedLines = ArrayList<Int>()
    var acc = 0
    input.forEach {
        val line = it.toIntOrNull()
        if (line != null) {
            acc += line
        } else {
            summedLines.add(acc)
            acc = 0
        }
    }
    println(summedLines.maxOf { it })
}

fun partTwo() {
    val input = readLines("1")
    val summedLines = ArrayList<Int>()
    var acc = 0
    input.forEach {
        val line = it.toIntOrNull()
        if (line != null) {
            acc += line
        } else {
            summedLines.add(acc)
            acc = 0
        }
    }
    println(summedLines.sortedDescending().take(3).sum())
}


fun readLines(name: String) : List<String> {
    return File("day$name.txt").readLines()
}