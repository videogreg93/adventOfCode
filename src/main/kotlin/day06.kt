fun main(args: Array<String>) {
    Day06.partTwo()
}

object Day06 {

    fun partOne() {
       val input = readLines("6").first()
        val markerLength = 4
        repeat(input.length) { index ->
            val marker = input.subSequence(index, index + markerLength).toSet()
            if (marker.size == markerLength) {
                println(index + markerLength)
                return
            }
        }
    }

    fun partTwo() {
        val input = readLines("6").first()
        val markerLength = 14
        repeat(input.length) { index ->
            val marker = input.subSequence(index, index + markerLength).toSet()
            if (marker.size == markerLength) {
                println(index + markerLength)
                return
            }
        }
    }
}