package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerview.models.Moto
import kotlinx.android.synthetic.main.res_item_moto.view.*

class MotoAdapter(private val onItemCliked: (Moto) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Moto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_moto, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MotoViewHolder -> {
                holder.bind(items[position], onItemCliked)
            }
        }
    }

    override fun getItemCount(): Int {

        return items.size
    }

    fun setDataSet(motos: List<Moto>){
        this.items = motos
    }

    class MotoViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        private val motoName = itemView.name_moto
        private val motoAutomake = itemView.automaker_moto
        private val motoPreview = itemView.preview_img

        fun bind(moto: Moto, onItemCliked: (Moto) -> Unit){
            motoName.text = moto.name
            motoAutomake.text = moto.automaker

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(moto.preview)
                .into(motoPreview)

            itemView.setOnClickListener {
                onItemCliked(moto)
            }
        }
    }
}