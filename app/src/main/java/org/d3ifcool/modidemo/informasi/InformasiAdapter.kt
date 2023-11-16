package org.d3ifcool.modidemo.informasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.modidemo.R
import org.d3ifcool.modidemo.databinding.ListInformasiBinding

class InformasiAdapter : RecyclerView.Adapter<InformasiAdapter.ViewHolder>() {
    private val data = mutableListOf<InfoModel>()

    fun updateData(newData: List<InfoModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListInformasiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(infoModel: InfoModel) = with(binding) {
            itemInformasi.text = infoModel.nama
            deskripsiInformasi.text = infoModel.deskripsi
            Glide.with(gambarInformasi.context)
                .load(InformasiApi.getInformasiUrl(infoModel.imageId))
                .error(R.drawable.round_broken_image_24)
                .into(gambarInformasi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListInformasiBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}