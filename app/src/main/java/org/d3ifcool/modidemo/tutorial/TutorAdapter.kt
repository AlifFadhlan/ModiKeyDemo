package org.d3ifcool.modidemo.tutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.modidemo.R
import org.d3ifcool.modidemo.databinding.ListTutorialBinding


class TutorAdapter : RecyclerView.Adapter<TutorAdapter.ViewHolder>(){
    private val data = mutableListOf<TutorModel>()

    fun updateData(newData: List<TutorModel>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListTutorialBinding) :
        RecyclerView.ViewHolder(binding.root) {
                fun bind (tutorModel: TutorModel) = with(binding) {
                    titleTutor.text = tutorModel.namaT
                    Glide.with(imageTutor.context)
                        .load(TutorApi.getTutorUrl(tutorModel.imageIdT))
                        .error(R.drawable.round_broken_image_24)
                        .into(imageTutor)
                }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListTutorialBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}