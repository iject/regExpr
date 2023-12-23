import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun main(args: Array<String>) {
    // #1
    println("#1")
    val s = "Это курс информатики соответствует ФГОС и ПООП, это подтверждено ФГУ ФНЦ НИИСИ РАН"
    var regex = Regex(pattern = "[А-Я]{2,}")
    var matched = regex.findAll(input = s).map { it.value }.toList()
    println(matched)


    // #2
    println("#2")
    var input = "Комитет государственной Безопасности"
    val words = input.split(" ")
    val acronym = words.map { it.first().uppercaseChar() }.joinToString("")
    println(acronym)

    // #3
    println("#3")
    input = "camelCaseVar"
    val snakeCase = input.replace(Regex("([a-z])([A-Z])"), "$1_$2").toLowerCase()
    println(snakeCase)

    // #4
    println("#4")
    var text = """
        - Дельный, что и говорить,
        Был старик тот самый,
        Что придумал суп варить
        На колесах прямо.
        Суп - во-первых. Во-вторых,
        Кашу в норме прочной.
        Нет, старик он был старик
        Чуткий - это точно.
    """.trimIndent()

    regex = Regex(pattern = "^[А-Яа-я]|\\s[А-Яа-я]")
    matched = regex.findAll(input = text).map { it.value }.toList()
    println(matched.size)

    // #5
    println("#5")
    text = "The following example creates an ArrayList with a capacity of 50 elements." +
    " Four elements are then added to the ArrayList and the ArrayList is trimmed accordingly."


    regex = Regex(pattern = "\\b[a|e|A|E]\\w{0,}\\b")
    matched = regex.findAll(input = text).map { it.value }.toList()
    println(matched)

    // #6
    println("#6")
    text =  """Mr smith bought cheapsitecom for 15 million dollars!
    Did he mind? Adam Jones thin, ks he didn't. In any case this isn't true...
    Well with a probability of 9 it isn't. Aasd aseew sdvevwt..."""

    regex = Regex(pattern = "[A-ZА-Я][\\w*\\s\\'\\,]*[.;!?]*")
    matched = regex.findAll(input = text).map { it.value }.toList()
    for (i in matched)
        println(i)

    // #7
    println("#7")
    val path = Paths.get("C:\\Users\\ПК\\Downloads\\2638-0 (1).txt")
    text = Files.readString(path, Charsets.UTF_8)
    regex = Regex(pattern = "PART I[\\s]+[\\w\\W]+PART II\\s")
    var part = regex.findAll(input = text).map { it.value}.toList()

    regex = Regex(pattern = "(^|\\s)[Tt]he\\s")
    matched = regex.findAll(input = part[0]).map { it.value}.toList()
    println(matched.size)
}