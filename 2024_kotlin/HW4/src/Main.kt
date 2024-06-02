/*
 [만든 사람]
 학번 : 2021563033
 이름 : 박준규
 */
// 커피 클래스 정의함
// 이름, 가격, 포인트를 속성으로 가짐
class Coffee(val name: String, val price: Int, val point: Int)

// 메뉴판 구성
// 커피 이름, 가격, 포인트
val menupan = listOf(
    Coffee("아메리카노", 2000, 20),
    Coffee("카페라떼", 2800, 28),
    Coffee("카푸치노", 3200, 32),
    Coffee("카페모카", 3400, 34)
)

// 주문 클래스 정의
class Order(val coffee: Coffee, val quantity: Int) {
    val name: String = coffee.name // 주문한 커피 이름
    val price: Int = coffee.price * quantity // 주문한 커피 총 가격
    val point: Int = coffee.point * quantity // 주문한 커피 총 포인트
    // 커피 주문을 출력하는 함수
    fun makeCoffee() = "$name $quantity 잔 $price 원입니다."
}

// 고객 클래스 정의
// 초기 포인트 3000점이다.
class Customer(val phoneNum: String, var points: Int = 3000)

// 포인트 시스템 클래스 정의
class PointSystem {
    private val customerPoints = mutableMapOf<String, Customer>() // 고객 전화번호와 고객 객체를 맵으로 저장

    // 고객 등록 함수, 신규 고객이면 새로 등록하고 포인트 3000점 부여
    fun registerCustomer(phoneNum: String): Customer {
        return customerPoints.getOrPut(phoneNum) {
            println("신규 고객이십니다. 3000포인트가 적립되었습니다.")
            Customer(phoneNum)
        }
    }
}

// 커피숍 클래스 정의
class CoffeeShop {
    private val orderList = mutableListOf<Order>() // 주문 리스트
    private val pointSystem = PointSystem() // 포인트 시스템 객체

    // 주문을 받는 함수
    fun takeOrder() {
        println("================================================")
        println("SUNBUCKS CAFE : 메뉴를 고르세요.")
        while (true) {
            println("1.아메리카노  2.카페라떼  3.카푸치노  4.카페모카  5.주문 종료")

            val menu = readLine()!!.toInt() // 메뉴 선택
            if (menu in 1..4) {
                println("몇 잔 필요하신가요? ")
                val num = readLine()!!.toInt() // 주문 수량
                val coffee = menupan[menu - 1] // 선택한 커피
                val order = Order(coffee, num) // 주문 객체 생성
                orderList.add(order) // 주문 리스트에 추가
            } else if (menu == 5) {
                completeOrder() // 주문 완료 처리
                break
            } else {
                println("없는 메뉴 입니다.")
            }
        }
    }

    // 주문 완료 처리 함수
    private fun completeOrder() {
        val totalPrice = orderList.sumOf { it.price } // 총 가격 계산
        val totalPoints = orderList.sumOf { it.point } // 총 포인트 계산

        println("포인트 적립을 위해 전화번호를 입력해주세요.")
        val phoneNum = readLine()!! // 전화번호 입력
        val customer = pointSystem.registerCustomer(phoneNum) // 고객 등록

        val currentPoints = customer.points // 현재 포인트
        val discountPrice = if (currentPoints >= totalPrice) totalPrice else currentPoints // 할인 금액 계산

        // 주문 내역 출력
        for (order in orderList) {
            println(order.makeCoffee())
        }

        println("포인트로 $discountPrice 원 할인되었습니다.")
        println("총 금액은 ${totalPrice - discountPrice} 원 입니다.")

        // 포인트 차감 및 적립
        customer.points = currentPoints - discountPrice + totalPoints
        println("현재 포인트는 ${customer.points}점 입니다.")

        orderList.clear() // 주문 리스트 초기화
        println("카페를 이용해주셔서 감사합니다.")
    }
}

// 메인 함수, 커피숍 객체 생성 후 주문 받기 반복
fun main() {
    val coffeeShop = CoffeeShop()
    while (true) {
        coffeeShop.takeOrder()
    }
}
