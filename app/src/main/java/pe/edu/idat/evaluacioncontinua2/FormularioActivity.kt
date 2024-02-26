package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityFormularioBinding
import pe.edu.idat.evaluacioncontinua2.util.AppMensaje
import pe.edu.idat.evaluacioncontinua2.util.TipoMensaje

class FormularioActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnResolver.setOnClickListener(this)
        binding.tbAppIDAT.setOnClickListener(this)

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

    fun ValidarCuestionario():Boolean{
        val PlatosValidados = ValidarPlatos()
        val PaisValidado = ValidarPais()
        val InglesValidado = ValidarIngles()
        val TecValidado = ValidarTecnologia()
        val TrabajoValidado = ValidarTrabajo()

        if (PlatosValidados && PaisValidado && InglesValidado && TecValidado && TrabajoValidado){
            AppMensaje.noti(binding.root, "Información Registrada con Éxito!!", TipoMensaje.CORRECTO)
            return true
        }
        else{
            var MensajeError = ""
            if (!PlatosValidados){
                MensajeError = "Recuerda debes marcar al menos un plato"
            }
            else if(!PaisValidado){
                MensajeError = "Recuerda marcar la pregunta 2"
            }
            else if(!InglesValidado){
                MensajeError = "No olvides marcar si hablas inglés"
            }
            else if(!TecValidado){
                MensajeError = "Marca si te gusta la Tecnología"
            }
            else if(!TrabajoValidado){
                MensajeError = "Aún no marcas si realizas Trabajo Remoto"
            }
            AppMensaje.noti(binding.root,MensajeError,TipoMensaje.ERROR)
            return false
        }


    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnResolver.id -> {
                if(ValidarCuestionario()){}
            }
            binding.tbAppIDAT.id ->{
                onBackPressed()
            }

        }
    }


}