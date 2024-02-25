package pe.edu.idat.evaluacioncontinua2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregistro.setOnClickListener(this)
        binding.btnformulario.setOnClickListener(this)
        binding.btnlistado.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnregistro -> {
                startActivity(Intent(applicationContext, RegistroActivity::class.java))
            }
            R.id.btnformulario -> {
                startActivity(Intent(applicationContext, FormularioActivity::class.java))
            }
            R.id.btnlistado -> {
                startActivity(Intent(applicationContext, ListaActivity::class.java))
            }
        }
    }
}