
fun <T> TreeNode<T>.cancellableWalkDepthFirst(onEach:(T)->Boolean):Boolean{
    val nodes = java.util.LinkedList<TreeNode<T>>()
    nodes.push(this)
    while(nodes.isNotEmpty()){
        val node = nodes.pop()
        if(!onEach(node.data))
            return false
        node.children.forEach{nodes.push(it)}
    }
    return true
}

private fun Any.forEach(function: () -> Unit) {
    TODO("Not yet implemented")
}

inline fun <reified T> TreeNode<*>.isInstanceOf() = cancellableWalkDepthFirst { it is T }

fun main(){
    val tree = TreeNode<Any>("abc").addChild("def").addChild(123)
    println(tree.isInstanceOf<String>())
}
