//region file start here
package com.example.android.guesstheword.sealed

// public is the default modifier for everything
open class X_identifiers {
    // protected is visible for subclasses
    protected class X_protected {

    }

    // internal is visible only in this module (gradle , java module, maven module )
    internal class X_internal {

    }

    // private is visible only in this class and not this file
    private class X_private {

    }

    fun doItPublic() = Unit
    protected fun doItProtected() = Unit
    internal fun doItInternal() = Unit
    private fun doItPrivate() = Unit

    fun test() {
        doItPublic()
        doItProtected()
        doItInternal()
        doItPrivate()
    }

    open fun tryToOverrideMePublic() = Unit
    open protected fun tryToOverrideMeProtected() = Unit
    open internal fun tryToOverrideMeInternal() = Unit
    //open private fun tryToOverrideMePrivate() = Unit // open and private has no sens
}

// private is visible only in this file
private class Y
//protected class Y2 protected modifier is not applicable inside file
internal class Y3


class SubclassX : X_identifiers() {
    val z_public = Unit
    protected val z_protected = Unit
    internal val z_internal = Unit
    private val z_private = Unit

    fun doSomething() {
        //*****instantiation of classes ****//
        val xIdentifiers: X_identifiers = X_identifiers()
        val xProtected: X_protected = X_protected()
        val xInternal: X_internal = X_internal()
        //val x3: X3 = X3() No visibility because it's private
        val y: Y = Y()


        //*****functions******//
        xIdentifiers.doItPublic()//it is public so it'is an API
        //x.doItProtected()
        doItProtected() // API for subclasses
        xIdentifiers.doItInternal()//API in the current module
        //x.doItPrivate() not visible because we call it from outside its class; not API
    }

    override fun tryToOverrideMePublic() = Unit
    protected override fun tryToOverrideMeProtected() = Unit
    internal override fun tryToOverrideMeInternal() = Unit // we can override it , we cannot change the visibility scope to protected but we can change it to public
}
//endregion file start here
