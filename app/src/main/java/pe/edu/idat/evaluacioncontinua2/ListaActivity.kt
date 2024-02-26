package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}