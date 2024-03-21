import foo.bar.util.readInt

fun main() {
    //val w = readln().toInt()
    //val h = readln().toInt()

    //println("Rectangle area : ${rectangleArea(w,h)}")
    //println(restrictRange(10, 1, 5))

    printSorted(16,4,1,767,221,43,5,7,1)    //[1, 1, 4, 5, 7, 16, 43, 221, 767]

    val numberArray =
        intArrayOf(16,4,1,767,221,43,5,7,1)

    // 스프레드 연산자 *를 사용하면 배열을 넣을 수 있다.
    // 배열의 주소값을 넘기는게 아니라 배열을 copy 해서 오버로딩함
    // 원본 값은 안바뀐다.
    printSorted(*numberArray)   // [1, 1, 4, 5, 7, 16, 43, 221, 767]
    //배열 자체가 안바뀐걸 확인할 수 있음
    println(numberArray.contentToString())  // [16, 4, 1, 767, 221, 43, 5, 7, 1]

    //이런것도 가능하다.
    printSorted(16,4,1,767,221,43,5,7,1,*numberArray)   //[1, 1, 1, 1, 4, 4, 5, 5, 7, 7, 16, 16, 43, 43, 221, 221, 767, 767]

    //배열을 가변인자로 받는 함수에 배열을 통으로 넣기
    val item1 = intArrayOf(1,2,3)
    val item2 = intArrayOf(4,5,6)

    changeArray(item1, item2)

    //위와 다르게 참조(주소) 집어넣었기 때문에 배열의 값이 바뀐다.
    println(item1.contentToString())   // [100, 2, 3]
    println(item2.contentToString())   // [4, 5, 6]

    //mul(10)  이렇게 하면 오류가 난다. 컴파일러가 찾지를 못함
    //mul(10,20)
    //mul(10,20L)
    //mul(10, 40, true)


    // 다른 패키지 안에 있는 것도 불러올 수 있다.
    // import 해주면 됟나.
    println(readInt(10))
}

