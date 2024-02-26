package pe.edu.idat.evaluacioncontinua2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityRegistroBinding
import pe.edu.idat.evaluacioncontinua2.util.AppMensaje
import pe.edu.idat.evaluacioncontinua2.util.TipoMensaje

class RegistroActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityRegistroBinding
    private val listaInfo = ArrayList<String>()
    private val listaCualidades = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setOnClickListener(this)
        binding.btnAcceder.setOnClickListener(this)
        binding.cbotros.setOnClickListener(this)
        binding.cbpuntual.setOnClickListener(this)
        binding.cbrespetuoso.setOnClickListener(this)
        binding.cbresponsable.setOnClickListener(this)
        binding.btnlistainfo.setOnClickListener(this)
    }

    fun validarcualidades():Boolean{
        return binding.cbpuntual.isChecked || binding.cbresponsable.isChecked || binding.cbotros.isChecked
    }
    fun validarcarrera():Boolean{
        var respuesta = true
        if (!binding.rbingenieria.isChecked && !binding.rbciencias.isChecked && !binding.rbadministracion.isChecked && !binding.rbotros.isChecked) {
            respuesta = false
        }
        return respuesta
    }
    fun validarcampos():Boolean {
        var respuesta = true
        if (binding.edNombre.text.toString().trim().isEmpty()){
            binding.edNombre.isFocusableInTouchMode = true
            binding.edNombre.requestFocus()
            respuesta = false
        }else if(binding.edApellido.text.toString().trim().isEmpty()){
            binding.edApellido.isFocusableInTouchMode = true
            binding.edApellido.requestFocus()
            respuesta = false
        }else if (binding.edDni.text.toString().trim().isEmpty()) {
            binding.edDni.isFocusableInTouchMode = true
            binding.edDni.requestFocus()
            respuesta = false
        } else if (binding.edCelular.text.toString().trim().isEmpty()) {
            binding.edCelular.isFocusableInTouchMode = true
            binding.edCelular.requestFocus()
            respuesta = false
        } else if (binding.edEmail.text.toString().trim().isEmpty()) {
            binding.edEmail.isFocusableInTouchMode = true
            binding.edEmail.requestFocus()
            respuesta = false
        }

        return respuesta
    }
    fun validarFormulario():Boolean{
        val camposValidos = validarcampos()
        val carreraValida = validarcarrera()
        val cualidadesValidas = validarcualidades()
        if (camposValidos && carreraValida && cualidadesValidas) {
            return true
        } else {
            var mensajeError = ""
            if (!camposValidos) {
                mensajeError = getString(R.string.errorcampos)
            } else if (!cualidadesValidas) {
                mensajeError = getString(R.string.errorcualidad)
            }else if (!carreraValida) {
                mensajeError = getString(R.string.errorcarrera)
            }
            AppMensaje.noti(binding.root, mensajeError, TipoMensaje.ERROR)
            return false
        }
    }
    private fun registrarInfo(){
        if(validarFormulario()){
            var infor = "Nombre: " +binding.edNombre.text.toString()+"\nApellido: "+
                    binding.edApellido.text.toString()+"\nDni: "+
                    binding.edDni.text.toString()+"\nNumero: "+
                    binding.edCelular.text.toString()+"\nEmail: "+
                    binding.edEmail.text.toString()+"\nCualidad: "+
                    obtenerCualidades()+"\nCarrera: "+
                    obtenerCarrera()
            listaInfo.add(infor)
            AppMensaje.noti(binding.root, getString(R.string.notificacion), TipoMensaje.CORRECTO)
        }
    }
    fun obtenerCualidades():String{
        val cualidadesSeleccionadas = mutableListOf<String>()

        if (binding.cbpuntual.isChecked) {
            cualidadesSeleccionadas.add(binding.cbpuntual.text.toString())
        }
        if (binding.cbrespetuoso.isChecked) {
            cualidadesSeleccionadas.add(binding.cbrespetuoso.text.toString())
        }
        if (binding.cbresponsable.isChecked) {
            cualidadesSeleccionadas.add(binding.cbresponsable.text.toString())
        }
        if (binding.cbotros.isChecked) {
            val otrosText = binding.edOtros.text.toString().trim()
            if (otrosText.isNotEmpty()) {
                cualidadesSeleccionadas.add(otrosText)
            }
        }
        return cualidadesSeleccionadas.joinToString(separator = ", ")
    }
    fun obtenerCarrera():String{
        return when (binding.radioGroup.checkedRadioButtonId) {
            R.id.rbingenieria -> binding.rbingenieria.text.toString()
            R.id.rbciencias -> binding.rbciencias.text.toString()
            R.id.rbadministracion -> binding.rbadministracion.text.toString()
            R.id.rbotros -> binding.rbotros.text.toString()
            else -> "Ninguna carrera seleccionada"
        }
    }
    private fun irlistainfo(){
        var intent = Intent(applicationContext, ListaInfoActivity::class.java).apply {
            putExtra("listaInfo", listaInfo)
        }
        startActivity(intent)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnlistainfo -> irlistainfo()
            R.id.btnAcceder -> registrarInfo()
            R.id.toolbar -> {
                onBackPressed()
            }
        }
    }


}