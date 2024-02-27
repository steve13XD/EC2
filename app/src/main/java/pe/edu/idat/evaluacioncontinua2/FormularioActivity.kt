package pe.edu.idat.evaluacioncontinua2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityFormularioBinding
import pe.edu.idat.evaluacioncontinua2.util.AppMensaje
import pe.edu.idat.evaluacioncontinua2.util.TipoMensaje
import kotlin.collections.joinToString

class FormularioActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityFormularioBinding
    private var listaformulario = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnResolver.setOnClickListener(this)
        binding.tbAppIDAT.setOnClickListener(this)
        binding.btnListaFormulario.setOnClickListener(this)

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

    private fun registrarFormulario(){
        if (ValidarCuestionario()){
            var formulario = "Sus platos favoritos son: " + ObtenerPlatos() +
            "\n  " + ObtenerVisita() + " visitó Europa, Asia o África" +
                    "\n " + ObtenerIngles() + " habla inglés" +
                    "\n " + ObtenerTecnologia() + " le gusta la tecnología" +
                    "\n " + ObtenerTrabajo() + " realiza trabajo remoto"



            listaformulario.add(formulario)

        }


    }

    fun ObtenerTrabajo():String{
        return when(binding.rgTrabajo.checkedRadioButtonId){
            R.id.rbTrabajoSI -> binding.rbTrabajoSI.text.toString()
            R.id.rbTrabajoNo -> binding.rbTrabajoNo.text.toString()
            else -> "Ninguna opción fue seleccionada"
        }
    }

    fun ObtenerTecnologia():String{
        return when (binding.rgTecnologia.checkedRadioButtonId){
            R.id.rbTecSi -> binding.rbTecSi.text.toString()
            R.id.rbTecNo -> binding.rbTecNo.text.toString()
            else -> "Ninguna opción fue seleccionada"
        }
    }

    fun ObtenerIngles():String{
        return when (binding.rgIngles.checkedRadioButtonId){
            R.id.rbInglesSi -> binding.rbInglesSi.text.toString()
            R.id.rbInglesNo -> binding.rbInglesNo.text.toString()
            else -> "Ninguna opción fue seleccionada"
        }
    }

    fun ObtenerVisita():String{
        return when (binding.rgPais.checkedRadioButtonId){
            R.id.rbPaisSi -> binding.rbPaisSi.text.toString()
            R.id.rbPaisNo -> binding.rbPaisNo.text.toString()
            else -> "Ninguna opción fue seleccionada"
        }
    }

    fun ObtenerPlatos():String{
        val platosSeleccionados = mutableListOf<String>()

        if (binding.cbArrozConPollo.isChecked){
            platosSeleccionados.add(binding.cbArrozConPollo.text.toString())
        }
        if (binding.cbLomoSaltado.isChecked){
            platosSeleccionados.add(binding.cbLomoSaltado.text.toString())
        }
        if (binding.cbAjiGallina.isChecked){
            platosSeleccionados.add(binding.cbAjiGallina.text.toString())
        }
        if (binding.cbTallarines.isChecked){
            platosSeleccionados.add(binding.cbTallarines.text.toString())
        }
        if (binding.cbArrozChaufa.isChecked){
            platosSeleccionados.add(binding.cbArrozChaufa.text.toString())
        }
        if (binding.cbOtros.isChecked){
            platosSeleccionados.add(binding.cbOtros.text.toString())
        }

        return platosSeleccionados.joinToString(separator = ", ")
    }


    private fun irListaFormulario(){
        var intent = Intent(applicationContext,ListaFormularioActivity::class.java).apply {
            putExtra("listaformulario", listaformulario)
        }
        startActivity(intent)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnResolver -> registrarFormulario()

            R.id.btnListaFormulario -> irListaFormulario()

            R.id.tbAppIDAT ->{
                onBackPressed()
            }

        }
    }


}