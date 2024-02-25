package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityRegistroBinding
import pe.edu.idat.evaluacioncontinua2.util.AppMensaje
import pe.edu.idat.evaluacioncontinua2.util.TipoMensaje

class RegistroActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityRegistroBinding
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
            AppMensaje.noti(binding.root, getString(R.string.notificacion), TipoMensaje.CORRECTO)
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
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAcceder -> {
                if (validarFormulario()) {

                }
            }
            R.id.toolbar -> {
                onBackPressed()
            }
        }
    }


}