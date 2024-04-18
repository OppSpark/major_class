class Person(val firstName: String, val familyName: String)
{
fun hasNameOf(name:String) = name.equals(firstName, ignoreCase = true)
}