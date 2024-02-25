package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun ValidarPlatos():Boolean{
        var respuesta = false
        if (binding.cbAjiGallina.isChecked || binding.cbArrozChaufa.isChecked || binding.cbArrozConPollo.isChecked
            || binding.cbTallarines.isChecked || binding.cbLomoSaltado.isChecked || binding.cbOtros.isChecked){
            respuesta = true
        }
        return respuesta

    }

    fun ValidarPais():Boolean{
        var respuesta = true
        if (binding.rgPais.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun ValidarIngles():Boolean{
        var respuesta = true
        if (binding.rgIngles.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun ValidarTecnologia():Boolean{
        var respuesta = true
        if (binding.rgTecnologia.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun ValidarTrabajo():Boolean{
        var respuesta = true
        if(binding.rgTrabajo.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }





}