fun main() {
    println(listOf(1,2,3,2,3).toSet())
    println(arrayOf("blue", "red", "blue", "green", "red").toSortedSet())

    val map = mapOf(1 to "one", 2 to "two", 3 to "three") //mapOf : 맵 생성
    for((k, v)in map) //map의 키와 값을 각각 k, v에 대입
        println("$k -> $v") //키와 값 출력

    intArrayOf(1,2,3).forEach { //forEach : 각 원소에 대해 람다식을 실행
        println(it)
    }
    val list1 = mutableListOf(1,2,3) //원소리스트
    println(list1.contains(3)) //원소 포함 여부

    list1+=6

    println(list1+7)  //원소 추가
    println(list1.get(3))  //원소 가져오기
    println(list1.indexOf(2))  //원소 위치 찾기
}