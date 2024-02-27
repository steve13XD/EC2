package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityListaFormularioBinding

class ListaFormularioActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityListaFormularioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setOnClickListener(this)
        var listaformulario = intent.getSerializableExtra("listaformulario") as ArrayList<String>
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,listaformulario)
        binding.lvFormulario.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.toolbar ->{
                onBackPressed()
            }
        }

    }
}