package pe.edu.idat.evaluacioncontinua2.util

import android.app.Application

class MiApp : Application() {
    companion object{
        lateinit var i : MiApp
    }

    override fun onCreate() {
        super.onCreate()
        i = this
    }
}