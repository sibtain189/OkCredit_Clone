package com.example.okcredit_app.Database.CustomerDatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okcredit_app.R


class CustomerAdapter(private val customerList: List<Customer>,val listener: CustomerItemClickListener): RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>(){

   inner class CustomerViewHolder(val item: View): RecyclerView.ViewHolder(item){

       var mTvTitle=item.findViewById<TextView>(R.id.tvTitle)
       var linear=item.findViewById<LinearLayout>(R.id.linerCustomer)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdapter.CustomerViewHolder {
        val v= LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_item_customer,parent,false)
        return CustomerViewHolder(v)

    }

    override fun getItemCount(): Int {
       return customerList.size
    }

    override fun onBindViewHolder(holder: CustomerAdapter.CustomerViewHolder, position: Int) {
        holder.mTvTitle.text= customerList[position].name
        holder.linear.setOnClickListener {
            listener.onCustomerPosition(customerList[position])
        }
    }
}