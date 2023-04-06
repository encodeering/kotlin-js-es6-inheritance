@OptIn (ExperimentalJsExport::class)
@JsExport
class TaskApp: App () {

    override fun description () = "lorem ipsum dante"

}

fun main () {
    println ("Starting TaskApp")
    println (TaskApp ().description ())
}
