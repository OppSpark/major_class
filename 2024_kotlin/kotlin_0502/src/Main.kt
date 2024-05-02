import java.util.TreeMap

fun main() {
    //ArrayList 활용
    val list = ArrayList<String>()
    list.add("Hello")
    list.add("World")
    list.add("Kotlin")
    println(list)

    //HashSet 활용
    val set = HashSet<Int>()
    set.add(10)
    set.add(20)
    set.add(111)
    println(set)

    //TreeMap 활용
    val map = TreeMap<Int, String>()
    map[1] = "Hello"
    map[2] = "World"
    map[3] = "Kotlin"
    println(map)

    //불변형 컬렉션들
    val emtpylist = emptyList<String>()
    println(emtpylist)

    val singleSet = setOf("one")
    println(singleSet)

    val sortedSet = sortedSetOf(45, 1, 6, 11, 7, 41, 25, 12)
    println(sortedSet)
    sortedSet.add(3)
    sortedSet.add(14)
    println(sortedSet)
}
