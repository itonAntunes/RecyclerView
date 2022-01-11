package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerview.models.Moto
import kotlinx.android.synthetic.main.res_item_moto.view.*

// onItemClicked capta os clicks executados dentro do recyclerView, está sendo tratado dentro do MotoViewHolder(bind).
class MotoAdapter(private val onItemCliked: (Moto) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    // estou criando a variavel que vai receber a lista dos dados mokados.
    private var items : List<Moto> = ArrayList()

    // está é a definição de qual layout será inflado ao executar o recyclerview.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_moto, parent,false)
        )
    }

    // Estou definindo os vinculos que aquele recycler view terá, como a posição dos itens da lista e o click.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MotoViewHolder -> {
                holder.bind(items[position], onItemCliked)
            }
        }
    }

    // essa função contabiliza quantos itens será exibido na tela, neste caso todos os itens da lista.
    override fun getItemCount(): Int {

        return items.size
    }

    // está função vincula a variavel motos a uma lista de moto e define "items" como recebedor desta lista.
    fun setDataSet(motos: List<Moto>){
        this.items = motos
    }

    // Nesta classe estou atribuindo as variaveis onde elas seram exibidas.
    class MotoViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        private val motoName = itemView.name_moto
        private val motoAutomake = itemView.automaker_moto
        private val motoPreview = itemView.preview_img

        // nesta função está sendo definido qual item deve ser mostrado dentro do layout.
        fun bind(moto: Moto, onItemCliked: (Moto) -> Unit){
            motoName.text = moto.name
            motoAutomake.text = moto.automaker

            // definições de carregamento e erro (existe a possibilidade de personalizar o icone para ilustrar o processo).
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            // o Glide é uma dependencia que possibilita a visualização de itens vindo da INTERNET previamente autorizado no "manifests".
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(moto.preview)
                .into(motoPreview)

            // estou executando a função criada na MainActivity para que possa abrir um LINK sempre que for clicado na recyclerView.
            itemView.setOnClickListener {
                onItemCliked(moto)
            }
        }
    }
}