//region file start here
package com.example.android.guesstheword.sealed

fun main(args: Array<String>) {
    val xIdentifiers: X_identifiers = X_identifiers()// ok its public
    //val xIdentifiersProtected: X_identifiers.X_protected = X_identifiers.X_protected() KO its protected visible in same file
    val xIdentifiersInternal: X_identifiers.X_internal = X_identifiers.X_internal()//ok its visible in the same package
    //val x3: X3 = X3() No visibility because it's private
    //val y: Y = Y() KO it's private
    update_all_Bars()
}
//endregion file start here


class TryScope {
    var bar: Int = 5 // property is visible everywhere
        private set         // setter is visible only in same class

    private var baz: Int = 5
        get() {// getter visibility must be the same as property visibility
            return field * 2
        }
        set(value) { //setter visibility must be the same or less permissive than property visibility
            field = value - 10
        }

    internal val baz2: Int = 5
        get() {
            return field * 2
        }


    fun updateBar() {
        bar += 10
        bar = outerBar
        outerBar = 10
    }
}

var outerBar: Int = 5 // property is visible everywhere
    private set // setter is visible only in same file

fun update_all_Bars() {
    outerBar = 200
    val tryScope: TryScope = TryScope()
    println(tryScope.bar)
     //tryScope.bar += 10 // cannot reassign ,setter is private
    println(tryScope.baz2)
}
