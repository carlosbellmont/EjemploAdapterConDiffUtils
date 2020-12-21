package com.example.ejemploadapterconlista

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StringAdapter(var listaString : MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    class StringViewHolder(var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    override fun getItemCount(): Int {
        return listaString.size + 1
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        if (position == itemCount -1) {
            holder.textView.text = "Añadir"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Añadiendo...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
                listaString.add("Elemento$position")
                notifyDataSetChanged()
            }
            return
        }
        if (position%2 == 0) {
            holder.textView.text = listaString[position]
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.purple_200))
        } else {
            holder.textView.text = "${listaString[position]} y Soy Impar"
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.teal_700))
        }

    }

}

