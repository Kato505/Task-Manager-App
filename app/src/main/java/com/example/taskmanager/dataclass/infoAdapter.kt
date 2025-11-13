package com.example.taskmanager.dataclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.IntLayoutBinding

class infoAdapter(val listner: handleclicks,val list: List<Data>) : RecyclerView.Adapter<infoAdapter.adp>()  {

    interface handleclicks{
        fun ed(data: Data)
        fun dlt(data: Data)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): adp {
        val binding= IntLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return adp(binding)
    }

    override fun onBindViewHolder(
        holder: adp,
        position: Int
    ) {
        list[position].let { data ->
            holder.binding.apply {
                title1.text = data.title
                title2.text = data.description
                date.text = "Date: ${data.date}"
                editBtn.setOnClickListener {
                    listner.ed(data)
                }
                dltBtn.setOnClickListener {
                    listner.dlt(data)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class adp (val binding: IntLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}