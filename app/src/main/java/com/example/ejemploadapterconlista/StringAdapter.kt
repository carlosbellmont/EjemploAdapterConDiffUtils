package com.example.ejemploadapterconlista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class StringAdapter : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    private var stringList = listOf<String>()

    class StringViewHolder(private var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.textView.text = stringList[position]
        holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.purple_200))
    }

    fun updateData(list : List<String>) {
        val oldStringList = stringList
        val differences : DiffUtil.DiffResult = DiffUtil.calculateDiff(DifferenceChecker(oldStringList, list))

        stringList = list.toList() // Añadimos una copia de la lista.

        differences.dispatchUpdatesTo(this)
        // Atención, no utilizamos el notifyDataSetChanged(). dispatchUpdatesTo lo hará por nosotros.
    }


    class DifferenceChecker(private var oldStringList: List<String>, private var newStringList: List<String>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldStringList.size
        }

        override fun getNewListSize(): Int {
            return newStringList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldStringList[oldItemPosition] == newStringList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldStringList[oldItemPosition].contentEquals(newStringList[newItemPosition])
        }

    }

}

