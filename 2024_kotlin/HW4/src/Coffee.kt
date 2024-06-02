/*
 과제를 해결하며 기말 공부도 해 보자!
 지금까지 배운 내용들을 이것저것 적용해서 만들어 보고 어떤 기술들을 적용했는지 리포트를 작성하여 완성된 소스코드들과 함께 제출
 기한은 6/6(현충일)까지이며 성적에 반영하므로 반드시 제출하세요!

 [과제1] 제목 : 해다방
        실행해 보면 알겠지만 아래의 코드는 한 번 주문할 때 한 종류의 음료만 여러 잔 살 수 있다.
        한 번에 여러 종류의 음료를 주문할 수 있도록 코드를 수정하라. - 리스트등을 활용해 보자.
        출제자가 졸면서(?!) 만든 아래의 예시 코드가 마음에 들지 않으면 본인의 입맛에 맞게 다시 만들어도 됨. (메뉴 바꿔도 됨)

 /*[과제2] 제목 : 또또포인트
        해다방에 여러 명의 전화번호를 등록하여 포인트가 쌓이게 해 보자.  - 맵 사용하기
        첫 등록시 3000포인트를 적립해 주고 구매하는 가격만큼 포인트를 차감해 보자. (구매 포인트는 계속 쌓임)

 과제를 번호로 구분해 놓았지만 실제로는 하나의 프로그램이 만들어지면 됩니다!
 아래 코드는 단지 예시일 뿐이며 구현하는 방법은 매우 다양하게 있을 수 있습니다.
 */
/*
 [만든 사람]
 학번 :                  이름 :
 */
class Coffee(val name:String, val price:Int, val point:Int)

val menupan = listOf(
    Coffee("americano", 2000, 20),
    Coffee("cafelatte", 2800, 28),
    Coffee("cappuccino", 3200, 32),
    Coffee("cafemocha", 3400, 34)
)

class Order (val menu:Int, val n:Int){
    val name
        get() = menupan[menu-1].name
    val price
        get() = menupan[menu-1].price*n
    fun makeCoffee() = "${name} $n 잔 $price 원입니다."
}

fun main(){
    while(true){
        println("SUNBUCKS CAFE : 메뉴를 고르세요.")
        println("1.아메리카노  2.카페라떼  3.카푸치노  4.카페모카  0.주문 끝~  exit:안녕히계세요~")
        val menu = readLine()!!.toInt()
        if(menu == 0 || menu > 5) {
            println("다음에 또 오세요~")
            break
        }
        println("몇 잔 필요하신가요? ")
        val num = readLine()!!.toInt()
        val customer = Order(menu, num)
        println(customer.makeCoffee())
    }
    //포인트 적립,  포인트 등록
}
*/
