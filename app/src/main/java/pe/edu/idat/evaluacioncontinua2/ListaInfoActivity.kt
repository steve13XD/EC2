package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityListaInfoBinding

class ListaInfoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityListaInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setOnClickListener(this)
        var listaInfo =intent.getSerializableExtra("listaInfo") as ArrayList<String>
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listaInfo)
        binding.lvInfo.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.toolbar -> {
                onBackPressed()
            }
        }
    }
}