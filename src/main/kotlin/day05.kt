fun main(args: Array<String>) {
    Day05.partTwo()
}

object Day05 {

    fun partOne() {
        val input = readLines("5")
        val crates = Array(9) { ArrayList<Char>() }
        input.forEachIndexed { i, line ->
            if (i <= 7) {
                line.chunked(4).forEachIndexed { index, s ->
                    val crate = s.replace(Regex("[^A-Za-z]+"), "").firstOrNull()
                    if (crate != null && crate in 'A'..'Z') {
                        crates[index].add(0, crate)
                    }
                }
            } else if (i >= 10) {
                val orders = line.replace("move ", "")
                    .replace("from ", "")
                    .replace("to ", "")
                    .split(" ")
                repeat(orders[0].toInt()) {
                    val fromIndex = orders[1].toInt() - 1
                    val toIndex = orders[2].toInt() - 1
                    val c = crates[fromIndex].removeLast()
                    crates[toIndex].add(c)
                }
            }
        }
        val r = crates.fold("") { acc, l ->
            acc + l.last()
        }
        println(r)
    }

    fun partTwo() {
        val input = readLines("5")
        val crates = Array(9) { ArrayList<Char>() }
        input.forEachIndexed { i, line ->
            if (i <= 7) {
                line.chunked(4).forEachIndexed { index, s ->
                    val crate = s.replace(Regex("[^A-Za-z]+"), "").firstOrNull()
                    if (crate != null && crate in 'A'..'Z') {
                        crates[index].add(0, crate)
                    }
                }
            } else if (i >= 10) {
                val orders = line.replace("move ", "")
                    .replace("from ", "")
                    .replace("to ", "")
                    .split(" ")
                val quantity = orders[0].toInt()
                val fromIndex = orders[1].toInt() - 1
                val toIndex = orders[2].toInt() - 1
                val cratesToMove = crates[fromIndex].subList(crates[fromIndex].size - quantity, crates[fromIndex].size)
                crates[toIndex].addAll(cratesToMove)
                crates[fromIndex] = ArrayList(crates[fromIndex].dropLast(quantity))
            }
        }
        val r = crates.fold("") { acc, l ->
            acc + l.last()
        }
        println(r)
    }
}