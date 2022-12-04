fun main(args: Array<String>) {
    Day04.partTwo()
}

object Day04 {

    fun partOne() {
        val s = readLines("4")
            .map {
                it.split(",").map {
                    val range = it.split("-")
                    (range[0].toInt()..range[1].toInt()).toSet()
                }
            }
            .filter { pairs ->
                val intersect = pairs.first().intersect(pairs.last())
                intersect == pairs.first() || intersect == pairs.last()
            }.size
        println(s)
    }

    fun partTwo() {
        val s = readLines("4")
            .map {
                it.split(",").map {
                    val range = it.split("-")
                    (range[0].toInt()..range[1].toInt()).toSet()
                }
            }
            .filter { pairs ->
                val interesct = pairs.first().intersect(pairs.last())
                interesct.isNotEmpty()
            }.size
        println(s)
    }
}