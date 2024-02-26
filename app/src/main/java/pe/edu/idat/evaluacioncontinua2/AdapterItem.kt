package pe.edu.idat.evaluacioncontinua2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.evaluacioncontinua2.databinding.ItemValorBinding

class AdapterItem(private var lista: List<ListaActivity.TestPsicologico>) : RecyclerView.Adapter<AdapterItem.ViewHolder>() {

    inner class ViewHolder(val binding: ItemValorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemValorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val test = lista[position]
        holder.binding.tvTituloTP.text = test.titulo
        holder.binding.tvDescripcionTP.text = test.descripcionCorta
        holder.binding.tvFechaPublicacionTP.text = test.fechaPublicacion
    }

    

}