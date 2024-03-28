fun main(){

    val person = Person("John", "Doe")
    val wallet = person.Possession("Wallet")

    wallet.shoOwner()
    println( wallet.getOwner().familyName)

    println(isLetterString("abc"))
    println(isLetterString("null"))

}

fun isLetterString(s: String?) :Boolean{
    if(s==null)
        return false
    if(s.isEmpty())
        return false
    for(ch in s){
        if(!ch.isLetter())
            return false
    }
    return true
}















//val id = Person.Id("John", "Doe")

    //val person = Person(id, 21)
    //person.showMe()

    /*
    val person = Person("John Doe", "Doe")
    val personFname = PersonFullName("John Doe")   //person 인스턴스 생성
    person.age =  25
    personFname.age = 25

    person.showMe()
    personFname.showMe()
     */
