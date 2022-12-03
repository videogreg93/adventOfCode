fun main(args: Array<String>) {
    day02.partTwo()
}

object day02 {

    fun partOne() {
        val scoreMap = mapOf(
            "X" to mapOf(
              "A" to  1 + 3,
              "B" to 1 + 0,
              "C" to 1 + 6
            ),
            "Y" to mapOf(
                "A" to 2 + 6,
                "B" to 2 + 3,
                "C" to 2 + 0
            ),
            "Z" to mapOf(
                "A" to 3 + 0,
                "B" to 3 + 6,
                "C" to 3 + 3
            )
        )
        val input = readLines("2").map { it.split(" ") }
        val score = input.fold(0) { acc, round ->
            acc + scoreMap.getValue(round[1]).getValue(round[0])
        }
        println(score)
    }

    fun partTwo() {
        val scoreMap = mapOf(
            "X" to mapOf(
                "A" to  1 + 3,
                "B" to 1 + 0,
                "C" to 1 + 6
            ),
            "Y" to mapOf(
                "A" to 2 + 6,
                "B" to 2 + 3,
                "C" to 2 + 0
            ),
            "Z" to mapOf(
                "A" to 3 + 0,
                "B" to 3 + 6,
                "C" to 3 + 3
            )
        )
        val rightColumnMap = mapOf(
            "X" to mapOf(
                "A" to "Z",
                "B" to "X",
                "C" to "Y"
            ),
            "Y" to mapOf(
                "A" to "X",
                "B" to "Y",
                "C" to "Z",
            ),
            "Z" to mapOf(
                "A" to "Y",
                "B" to "Z",
                "C" to "X"
            )
        )
        val input = readLines("2").map { it.split(" ") }
        val score = input.fold(0) { acc, round ->
            val newRightHandSide = rightColumnMap.getValue(round[1]).getValue(round[0])
            acc + scoreMap.getValue(newRightHandSide).getValue(round[0])
        }
        println(score)
    }
}