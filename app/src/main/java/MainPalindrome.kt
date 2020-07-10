import androidx.annotation.FloatRange

class MainPalindrome {

    fun findPalindrome(s1: String): String {
        //val d1Range: DoubleRange = 1.0..20.0 ERROR NO DoubleRange
        val d1Range: ClosedRange<Double> = 1.0..20.0 // thanks to fun rangeTo we can create ClosedRange
        val d2Range: ClosedFloatingPointRange<Double> = 1.0..20.0 // ClosedFloatingPointRange is ClosedRange

        //val f1Range: FloatRange = 0F..20.0F ERROR NO FloatRange
        val f1Range: ClosedRange<Float> = 0F..20.0F
        val f2Range: ClosedFloatingPointRange<Float> = 1.0f..20.0f

        val i3Range: ClosedRange<Int> = 0..10
        val i1Range: IntRange = 0..10
        val i2Range: IntProgression = 0..10
        val i4Range: Iterable<Int> = 0..10

        val l3Range: ClosedRange<Long> = 0L..10L
        val l1Range: LongRange = 0L..10L
        val l2Range: LongProgression = 0L..10L
        val l4Range: Iterable<Long> = 0L..10L

        val s1Range = (0.toShort())..(10.toShort())
        val s2Range = (0.toShort())..(10.toShort())
        val s3Range = (0.toShort())..(10.toShort())
        val s4Range = (0.toShort())..(10.toShort())

        val st: CharArray = s1.toCharArray()
        var s2 = ""
        for (i in 0 until st.size - 1) {
            for (j in st.size - 1 downTo i + 1) {
                val tem1: Array<Char> = arrayOf(st[i], st[i + 1])
                val tem2: Array<Char> = arrayOf(st[j], st[j - 1])
                if (isTheSame(tem1, tem2)) {
                    //val c1: Char = tem1[0]
                    //val c2 = tem1[1]
                    //val c3 = tem2[0]
                    //val c4 = tem2[1]
                    //s2 = "$c1$c2$c3$c4"
                }//
            }
        }
        return s2


    }

    fun isTheSame(t1: Array<Char>, t2: Array<Char>): Boolean =
            (t1.size == 2 && t2.size == 2 && t1[0] == t2[0] && t1[1] == t2[1])
}


fun main(args: Array<String>) {


//    val mainPalindrome = MainPalindrome()
//    val findPalindrome = mainPalindrome.findPalindrome("MILLION")
//    println(findPalindrome)


    var x = 5
    var y = 9
    x = y + x  //14
    y = x - y //5
    x = x - y // 9

    println("x = $x")
    println("y = $y")


    val message = """
        voila:
             x = $x 
             y = $x$y 
            """.trimIndent()
    println(message)
}


