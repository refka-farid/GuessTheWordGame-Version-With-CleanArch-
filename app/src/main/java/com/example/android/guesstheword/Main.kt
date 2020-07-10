//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch


package com.example.android.guesstheword

import java.io.IOException
import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet
import kotlin.random.Random

infix fun Int.zid(i: Int): Int = this + i

fun tryCatchToto() {
    val user: User = User(name = "lolo", age = 7, country = "kefiya")
    val (ageHoussem, nameHoussem, countryHoussem) = user
    println("$ageHoussem houssemAge")
    println("$nameHoussem houssemName")
    println("$countryHoussem houssemCountry")

    val t: Triple<String, String, Int> = Triple("first", "second", 5)
    val (ageHoussem2, nameHoussem2, countryHoussem2) = t

    val p: Pair<String, String> = "une chaussetteD" to " une chaussetteG"
    val (d: String, g: String) = p

    val mutableListOf: MutableList<Any> = mutableListOf(1, 5, "55151", p is Pair)
    val toList = mutableListOf.toList()
    mutableListOf += ("55")
    mutableListOf[0] = 11
    val immutableListOf = listOf(1, 5, "55151", p is Pair)

    val muMap = mapOf(
            Pair("Med", 55),
            "koui" to 5,
            "joujou" to 58
    ).toMutableMap()

    val imuMap: MutableMap<String, Int> = mutableMapOf<String, Int>(
            Pair("Med", 55),
            "koui" to 5,
            "joujou" to 58
    )
    //  .toMap()

    val firstOrNull = muMap.toList().toMutableList().apply {
        add("hjk" to 35)
        add("dddd" to 95)
        add("hjk" to 52)

    }.map {
        it.first to it.second * 2
    }.firstOrNull {
        it.first == "koui"
    }?.also {
        print("${it.second}")
    }

    firstOrNull?.let {
        val (na, score) = firstOrNull
    }

    firstOrNull ?: print("No element")
    val sab3a = 3 zid 4

    try {
        exceptionMaker()
    } catch (ex: Exception) {
        when (ex) {
            is IOException,
            is IllegalArgumentException -> {
                println(" exception !!!!")
            }
        }
    }
    val arrayCaseOne: Array<String?> = arrayOf(null," A")
    var get: String? = arrayCaseOne.get(0)
    get=" bbb"

    val arrayCaseTwo: Array<Int>? = arrayOf()
    val size: Int? = arrayCaseTwo?.size

    val arrayCaseThree: Array<Boolean?>? = arrayOf(null, null , true)
    val toString: String? = arrayCaseThree?.get(0)?.toString()

    val myArray: Array<String> = Array(10) {
        "$it vvvv "
    }.also {
        it.forEach {
            println(it)
        }
    }
    val myArray2: Array<String> = arrayOf()

    val myArray3: ArrayList<String> = arrayListOf()

    val myArray4 = arrayListOf<String>().toArray()
    myArray4.set(0, "first infex")
    myArray4.set(1, "second infex")
    myArray4.set(2, "third infex")
    myArray4.set(3, "fourth infex")
    myArray4.set(4, "fifth infex")
    myArray4.set(4, " infex")

// array is mutable like in java but fixed size
     val myArray55= arrayListOf("first", "second", "third", "fourth", "fifth").toTypedArray()
    myArray55[0]="lolo"
   print(myArray55)

    val myArray5: Array<String> = arrayOf("first", "second", "third", "fourth", "fifth")
    myArray5[0]="lolo"
    myArray5.forEach{
        println(it)
    }
    val mySet: Set<Any> = setOf("one", 2, myArray4)
    val doubled = mySet.plus(mySet)
    // plus would create a new set with the original elements and then add the new elements

    val mySet2: HashSet<Any> = HashSet()
    mySet2.add("")
    val mySet3: LinkedHashSet<Any> = LinkedHashSet()
    mySet3.addAll(mySet)

    val mySet1: TreeSet<Any> = sortedSetOf("one", 2, myArray4)
    mySet1.add("")
    mySet1.remove("")
    val mySet4: TreeSet<String> = TreeSet<String>()
    myArray4.set(0, " ")
}


fun exceptionMaker() {
    throw Exception("nanana ")
}

fun isSupThan10(i: Int): Boolean {
    println("maybe sup than 10 ")
    return i > 10
}

fun isSupThan20(o: Int): Boolean {
    println("maybe sup than 20 ")
    return o > 20
}

fun momo(): Boolean {
    tryCatchToto()

    // or is the same as | in java
    if (isSupThan10(500) or isSupThan20(500)) {
        println("condition is ok ")
    } else {
        println("condition is ko ")

    }

    if (isSupThan10(500) || isSupThan20(500)) {
        println("condition is ok ")
    } else {
        println("condition is ko ")

    }

    val nextInt = Random.nextInt()
    val nextInt2 = nextInt as Any?


//    (nextInt2 as Float).let {
//        println(" $it this is 100% Float")
//    }

    (nextInt2 as? Float)?.let {
        println("nextInt2 is Float ")
    } ?: run {
        println("nextInt2 is not a Float ")
    }

    (nextInt2 as? Int)?.let {
        println("nextInt2 is Int ")
    }

    when (nextInt2) {
        is Float, is Int -> {
            println("nextInt2 is Float ")
            ""
        }
        else -> {
            println("else ")
            5
        }
    }
    when (nextInt2) {
        is Float -> {
            println("nextInt2 is Float ")
            ""
        }
        is Int -> {
            println("nextInt2 is Int ")
            3
        }
        else -> {
            println("else ")
            5
        }
    }
    val any = when {
        true || (nextInt2 is Float || nextInt2 is Int && nextInt2.toString().length < 5) -> {
            println("nextInt2 is Float ")
            ""
        }
        nextInt.rem(2) == 0 -> {
            println("hihi ")
        }

        "lolo".split("o").size < 10 -> {
            println("hihi ")
        }
        else -> {
            println("else ")
            5
        }
    }

    val isPair = nextInt.rem(2) == 0
    return if (isPair) {
        true
    } else {
        println("number is odd")
        false
    }
}

fun main() {
    momo()
    val four = 3.addOne()
    println("Hello;;;!!!$four")
    println("Refka".addMrs("boo"))
    var user: User? = User(name = "houssem", age = 7, country = "france")

    if (user != null) {
        println(user.age)
    }
    val random = Random.nextInt(0, 10).also {
        println("the Random is $it")
    }

    if (random % 2 == 0) {
        user = null
    }

    val i1 = user?.age ?: -1
    println("the age of the user is $i1")
    if (user != null) {
        val resultOfWith = with(user) lolo@{
            println("the age of the user is ${this?.age ?: -1}")
            return@lolo 3
        }
    }

    val block: User?.() -> Int = {
        println("the age of the user is ${this?.age ?: -1}")
        if (this != null) {
            printHello()
        }
        3
    }
    with(user, block)
    val returnOfTheBlock = block(user)

//apply//
    user.apply {
        println("the age of the user is ${this?.age ?: -1}")
    }
    user?.apply {
        println(user.age)
    }

    val retrunOfTheApply: User? = user.apply({
        println("the age of the user is ${this?.age ?: -1}")
    })
//apply//
//run//
    user.run {
        println(user?.age)
    }

    val run = user?.run {
        println(user.age)
    }

    val x = run({
        println("this is run")
        // Any()
    })

    suspend fun doInBackground() {
        println("I'm working in a background !! ${Thread.currentThread().name}")
        3.run { }
    }
//run//
//also//
    val returnAlso = user?.also {
        println(user.age)
    }
//let//
    val returnOfLet = user?.let {
        println(user.age)
    } ?: 5

    val any = user?.let {
        println(user.age)
    }?.let {
        ""
    }?.run {
        //close connexion
    }

    fun returnFunction0(): (Int) -> String {
        val myFun = { i: Int ->
            i.toString()
        }
        return myFun
    }

    fun returnFunction1(): (Int) -> String {
        return { i: Int ->
            i.toString()
        }
    }

    fun returnFunction2(): (Int) -> String = { i: Int ->
        i.toString()
    }

    fun returnFunction3(): (Int) -> String {
        val k = fun(i: Int): String {
            return i.toString()
        }
        return k
    }

    fun returnFunction4(): (Int) -> String {
        return fun(i: Int): String {
            return i.toString()
        }
    }

    fun returnFunction5(): (Int) -> String = fun(i: Int): String {
        return i.toString()
    }

    //when and if  expressions are function when they cover all conditions

    val myAnonymousFun: (Int?) -> Boolean? = fun(x1: Int?): Boolean? = when {
        x1 == null -> null
        x1 > 0 -> true
        x1 < 0 -> false
        else -> null
    }

    val myLambdaFun1: (Int?) -> Boolean? = lolo@{ x2: Int? ->
        return@lolo when {
            x2 == null -> null
            x2 > 0 -> true
            x2 < 0 -> false
            else -> null
        }
    }

    val myLambdaFun2: (Int?) -> Boolean? = { x2: Int? ->
        when {
            x2 == null -> null
            x2 > 0 -> true
            x2 < 0 -> false
            else -> null
        }
    }

    //  (x: Int?): Boolean? =
//    val u = Random.nextInt()
//    val h = if (u <= 1) {
//        null
//    } else {
//        3
//    }

//    repeat(5) {
//        println("this is $it")
//    }
//    for (x: Int in 1 until 5) {
//        println("this is $x")
//    }
//    for (x: Int in 0..4) {
//        println("this is $x")
//    }
//    for (x: Int in 4 downTo 0) {
//        println("this is $x")
//    }


// x is a suspend function ()-> Unit
//    val x: suspend () -> Unit = suspend {
//        doInBackground()// OK because we are inside a suspend block
//        withContext(Dispatchers.IO) {
//            doInBackground()// OK because we are inside a coroutine
//        }
//    }
//x.invoke() No It does not compile because main is not a suspend function  or a coroutine
// x.invoke()
//x() No It does not compile because main is not a suspend function  or a coroutine
//x()
//doInBackground() No It does not compile because main is not a suspend function  or a coroutine
//    runBlocking {
//        x()
//    }
}

data class User(val age: Int, val country: String, val name: String) {
    fun printHello() {
        println("hello")
    }
}

data class Fragment(val isReady: Boolean)
//fun main() {
////    GlobalScope.launch { // launch a new coroutine in background and continue
////        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
////        println("World! ${Thread.currentThread().name}") // print after delay
////
////    }
//    runBlocking {
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World! ${Thread.currentThread().name}") // print after delay
//
//    }
//    println("Hello,${Thread.currentThread().name}") // main thread continues while coroutine is delayed
//    Thread.sleep(500L) // block main thread for 2 seconds to keep JVM alive
//    println("momo ,${Thread.currentThread().name}") // main thread continues while coroutine is delayed
//    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
//
//}
//
//fun main() {
//    println("hello 1 ${Thread.currentThread().name}\"")
//    println("hello 2 ${Thread.currentThread().name}\"")
//    GlobalScope.launch(Dispatchers.IO) {
//        doInBackground("IO1", 3_000)
//    }
//    GlobalScope.launch(Dispatchers.IO) {
//        doInBackground("IO2", 3_000)
//    }
//    GlobalScope.launch(Dispatchers.Default) {
//        doInBackground("DEFAULT1", 4_000)
//    }
//    GlobalScope.launch(Dispatchers.Default) {
//        doInBackground("DEFAULT2", 4_000)
//    }
//    //GlobalScope.launch(Dispatchers.Main) {
//    //  doInBackground("MAIN", 5_000)
// // } // does not work because we are in main thread
//    GlobalScope.launch(Dispatchers.Unconfined) {
//        doInBackground("UNCONFINED1", 1_000)
//    }
//    GlobalScope.launch(Dispatchers.Unconfined) {
//        doInBackground("UNCONFINED2", 1_000)
//    }
//    GlobalScope.launch {
//        doInBackground("___1", 2_000)
//    }
//    GlobalScope.launch {
//        doInBackground("___2", 2_000)
//    }
//    println("hello 3 ${Thread.currentThread().name}\"")
//    println("hello 4 ${Thread.currentThread().name}\"")
//    // Thread.sleep(10_000)
//    do {
//
//    } while (true)
//
//
//    println("DONE ${Thread.currentThread().name}")
//
//}
//
//suspend fun doInBackground(s: String, t: Long) {
//    delay(t)
//    println("do in background $s function !!! ${Thread.currentThread().name}\"")
//}

fun String.addMrs(lastName: String): String {
    return "Mrs $this $lastName"
}

fun Int.addOne(): Int {
    return this + 1
}

inline fun <reified T : User> doIt(t: T): T {
    return T::class.java.newInstance()
}

//abstract class Holder<R1, R2, R3>(open val r: R1) {
//    var isReady = true
//    open var isSleeping = true
//
//    abstract fun doThat(r3: R3): R2
//    open fun printThat(s: String): Unit = println(s)
//    final fun printThat2(s: String): Unit = print(s)
//}

//open class MyHolder1(r: Int) : Holder<Int, String, User>(r) {
//    //var isReady = false
//    override var isSleeping = false
//
//    override fun doThat(r3: User): String {
//        TODO("Not yet implemented")
//    }
//
//    override fun printThat(s: String): Unit {
//        println("$s !!!")
//    }
//
//    open fun printThat1(s: String): Unit {
//        print("$s !!!")
//    }
//}
//
//open class MyHolder2(override val r: Int) : MyHolder1(r) {
//    override fun printThat1(s: String): Unit {
//        print("$s !!!")
//    }
//}
//
//class MyHolder3(override val r: Int) : MyHolder2(r) {
//    override fun printThat1(s: String): Unit {
//        print("$s !!!")
//    }
//}
//
//abstract class Result<in T, out R>( t: T, r: R) {
//    abstract fun send(t: T, r: T): R
//}

//class MyResult(override val t: Int, override val r: String) : Result<Int, String>(t, r) {
//    override fun send(t: Int, r: String): String {
//        return 5.toString()
//    }
//}
//********************************producer******************************

//abstract class Source<out T> {
//    abstract fun nextT(): T
//
//    // fun nextT1(t:T)=t
//    //restrection in declaration generic T is only out position
//    abstract val x: T
//
//    //abstract var x1:T
//    // var is invariant can't apply out or in
//}
//
//class SourceImpl1(override val x: MyHolder2) : Source<MyHolder2>() {
//    override fun nextT(): MyHolder2 = MyHolder2(3)
//}
//
//class SourceImpl2(override val x: MyHolder3) : Source<MyHolder3>() {
//    override fun nextT(): MyHolder3 = MyHolder3(3)
//}
//
//abstract class SourceImpl3(override val x: Nothing) : Source<Nothing>() {
//    abstract override fun nextT(): Nothing
//}
//
////************************************* Consumer ******************************************
//abstract class Consumer<in T>(t: T) {
//    // we cannot make it val , val has a getter => out
//    abstract fun nextT(t: T)
//}
//
//class ConsumerImpl1 : Consumer<MyHolder2>(MyHolder2(2)) {
//    override fun nextT(t: MyHolder2) {
//        TODO("Not yet implemented")
//    }
//}
//
//class ConsumerImpl2 : Consumer<MyHolder3>(MyHolder3(2)) {
//    override fun nextT(t: MyHolder3) {
//        TODO("Not yet implemented")
//    }
//}
//
//class ConsumerImpl3 : Consumer<MyHolder1>(MyHolder1(2)) {
//    override fun nextT(t: MyHolder1) {
//        TODO("Not yet implemented")
//    }
//}
//
//fun bloblo(source: Source<MyHolder2>, consumer: Consumer<MyHolder1>) {
//    val x: Source<Any?> = source // producer(out) extends
//    val y: Consumer<Nothing> = consumer  // consumer (in) super
//}
//fun demo1(strs: Source<MyHolder2>) {
//    val objects: Source<MyHolder2> = strs // This is OK, since T is an out-parameter
//    // ...
//}
//
//fun demo2(strs: Source<MyHolder3>) {
//    val objects: Source<MyHolder2> = strs // This is OK, since T is an out-parameter
//    // ...<
//}
//
//fun demo3(strs: Source<Nothing>) {
//    val objects: Source<MyHolder2> = strs // This is OK, since T is an out-parameter
//    // ...<
//}


//fun login(email: String?, pswd: String?): Boolean {
//    val isNullOrEmpty = email.isNullOrEmpty()
//    val isEmpty = email?.isEmpty()
//    val isNull = email == null
//
//
//    val isNotNullAndNotEmpty = (!isNull) && (!isEmpty!!)
//}

