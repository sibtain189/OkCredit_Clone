package com.example.okcredit_app.HomeFragments.TabFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.okcredit_app.HomeFragments.TabFragments.Constants.RECEIVE_ID
import com.example.okcredit_app.HomeFragments.TabFragments.Constants.SEND_ID
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.customer_chatbot.view.*

class CustomerChatBotAdapter(): RecyclerView.Adapter<CustomerChatBotAdapter.CustomerChatbotHolder>() {
    var chatList= mutableListOf<ChatBotModel>()


    inner class CustomerChatbotHolder(val view: View):RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {

                //Remove message on the item clicked
                chatList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerChatbotHolder {
        return CustomerChatbotHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.customer_chatbot, parent, false))
    }

    override fun onBindViewHolder(holder: CustomerChatbotHolder, position: Int) {
        val currentMessage = chatList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_2.visibility = View.GONE
                holder.itemView.tv_time1.apply {
                    text=currentMessage.time
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_2.visibility=View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_1.visibility = View.GONE
                holder.itemView.tv_time2.apply {
                    text=currentMessage.time
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_1.visibility=View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return chatList.size
    }
    fun insertMessage(chatBotModel: ChatBotModel) {
        this.chatList.add(chatBotModel)
        notifyItemInserted(chatList.size)
    }
}