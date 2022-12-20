import kotlin.math.max

fun main(args: Array<String>) {
    Day08.partTwo()
}

object Day08 {

    private fun isEdge(x: Int, y: Int, lines: List<String>): Boolean {
        return (x == 0 || y == 0 || x == lines[y].lastIndex || y == lines.lastIndex)
    }

    fun partOne() {
        val lines = readLines("8")
        var visibleTrees = 0
        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, c ->
                val lineArray = line.map { it.toString().toInt() }
                val tree = c.toString().toInt()
                if (isEdge(x, y, lines)) {
                    visibleTrees++
                } else {
                    val left by lazy { lineArray.subList(0, x).maxOrNull() ?: 0 }
                    val right by lazy { lineArray.subList(x + 1, lineArray.lastIndex + 1).maxOrNull() ?: 0 }
                    val up by lazy { lines.subList(0, y).map { it[x].toString().toInt() }.maxOrNull() ?: 0 }
                    val down by lazy { lines.subList(y + 1, lines.lastIndex + 1).map { it[x].toString().toInt() }.maxOrNull() ?: 0 }
                    if (left < tree || right < tree || up < tree || down < tree ) {
                        visibleTrees++
                    }
                }
            }
        }
        println(visibleTrees)
    }

    fun calculate(list: List<Int>, tree: Int): Int {
        return (list.takeWhile { it < tree }.size + 1).coerceAtMost(list.size)
    }

    fun partTwo() {
        val lines = readLines("8")
        var maxScore = 0
        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, c ->
                val lineArray = line.map { it.toString().toInt() }
                val tree = c.toString().toInt()
                if (isEdge(x, y, lines)) {
                    // do nothing
                } else {
                    val left = calculate(lineArray.subList(0, x).reversed(), tree)
                    val right = calculate(lineArray.subList(x + 1, lineArray.lastIndex + 1), tree)
                    val up = calculate(lines.subList(0, y).map { it[x].toString().toInt() }.reversed(), tree)
                    val down = calculate(lines.subList(y + 1, lines.lastIndex + 1).map { it[x].toString().toInt() }, tree)
                    maxScore = max(maxScore, left * right * up * down)
                }
            }
        }
        println(maxScore)
    }
}