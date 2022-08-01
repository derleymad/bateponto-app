package com.github.derleymad.bateponto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.derleymad.bateponto.model.Calc

class Adapter(
    private val list : List<Calc>
) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calc_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCurrent = list[position]
        holder.bind(itemCurrent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(itemCurrent:Calc){
            val dia = itemView.findViewById<TextView>(R.id.tv_dia)
            val entrada = itemView.findViewById<TextView>(R.id.tv_entrada)
            val saida = itemView.findViewById<TextView>(R.id.tv_saida)
            val total = itemView.findViewById<TextView>(R.id.tv_total)

            dia.text = itemCurrent.dia.toString()
            entrada.text = itemCurrent.entrada.toString()
            saida.text = itemCurrent.saida.toString()
            total.text = itemCurrent.total.toString()

        }
    }
}