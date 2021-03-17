package com.example.okcredit_app.HomeFragments.TabFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.customer_chatbot.view.*
import kotlinx.android.synthetic.main.supplier_chatbot.view.*

class SupplierChatBotAdapter: RecyclerView.Adapter<SupplierChatBotAdapter.SupplierChatBotHolder>() {

    var chatList= mutableListOf<ChatBotModelSupplier>()

    inner class SupplierChatBotHolder(val view: View): RecyclerView.ViewHolder(view){
        init {
            itemView.setOnClickListener {
                chatList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierChatBotHolder {
        return SupplierChatBotHolder(LayoutInflater.from(parent.context).inflate(R.layout.supplier_chatbot, parent, false))
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: SupplierChatBotHolder, position: Int) {
        val currentMessage = chatList[position]

        when (currentMessage.idSupplier) {
            ConstantsSupplier.SEND_ID_SUPPLIER -> {
                holder.itemView.tv_message1.apply {
                    text = currentMessage.messageSupplier
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_4.visibility = View.GONE
                holder.itemView.tv_time3.apply {
                    text=currentMessage.timeSupplier
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_4.visibility=View.GONE
            }
            ConstantsSupplier.RECEIVE_ID_SUPPLIER -> {
                holder.itemView.tv_bot_message2.apply {
                    text = currentMessage.messageSupplier
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_3.visibility = View.GONE
                holder.itemView.tv_time4.apply {
                    text=currentMessage.timeSupplier
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_3.visibility=View.GONE
            }
        }

    }

    fun insertMessage(chatBotModel: ChatBotModelSupplier) {
        this.chatList.add(chatBotModel)
        notifyItemInserted(chatList.size)
    }

}