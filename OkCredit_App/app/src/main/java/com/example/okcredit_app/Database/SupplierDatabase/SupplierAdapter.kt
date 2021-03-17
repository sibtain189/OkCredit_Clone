package com.example.okcredit_app.Database.SupplierDatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okcredit_app.R

class SupplierAdapter(private val supplierList: List<Supplier>,val listener: SupplierItemClickListener): RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder>() {

    inner class SupplierViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val mTVTitle1=view.findViewById<TextView>(R.id.tvTitle1)
        val linear= view.findViewById<LinearLayout>(R.id.linearSupplier)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_supplier,parent,false)
        return SupplierViewHolder(view)
    }

    override fun getItemCount(): Int {
       return supplierList.size
    }

    override fun onBindViewHolder(holder: SupplierViewHolder, position: Int) {
        holder.mTVTitle1.text=supplierList[position].name
        holder.linear.setOnClickListener {

            listener.onSupplierPosition(supplierList[position])

        }
    }



}