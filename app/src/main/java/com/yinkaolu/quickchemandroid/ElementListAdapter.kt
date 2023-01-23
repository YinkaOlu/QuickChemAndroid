package com.yinkaolu.quickchemandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yinkaolu.quickchemandroid.data.model.PeriodicTable

class ElementListAdaptor(private val periodicTable: PeriodicTable) :
    RecyclerView.Adapter<ElementListAdaptor.ElementItemViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.element_list_item, parent, false)
        return ElementItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return periodicTable.mElements.size
    }

    class ElementItemViewHolder(val elementItemView: View) : RecyclerView.ViewHolder(elementItemView) {
        var showDetail = false
    }

    override fun onBindViewHolder(holder: ElementItemViewHolder, position: Int) {
//        val itemView = holder.elementItemView
//        val element = periodicTable.mElements[position]
//
//        itemView.symbol.text = element.symbol
//        itemView.atomicNumber.text = element.atomicNumber
//        itemView.standardAtomicWeight.text = element.standardAtomicWeight
//
//        itemView.elementCategory.text = "Category: ${element.elementCategory}\n"
//        itemView.group.text = "Group: ${element.group}\n"
//        itemView.density.text = "Density: ${element.density}\n"
//        itemView.boilingPoint.text = "Boiling Point: ${element.boilingPoint}\n"
//        itemView.meltingPoint.text = "Melting Point: ${element.meltingPoint}\n"
//        itemView.discovery.text = "${element.discovery}\n"
//        itemView.summary.text = "${element.summary}\n"
//
//        itemView.setOnClickListener {
//            holder.showDetail = !holder.showDetail
//            if (holder.showDetail) {
//                itemView.elementDetailCard.visibility = View.VISIBLE
//            } else {
//                itemView.elementDetailCard.visibility = View.GONE
//            }
//        }
    }
}