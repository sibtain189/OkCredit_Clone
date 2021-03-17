package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okcredit_app.HomeFragments.TabFragments.Constants.RECEIVE_ID
import com.example.okcredit_app.HomeFragments.TabFragments.Constants.SEND_ID
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_person_customer.*
import kotlinx.android.synthetic.main.fragment_person_customer.rv_messages
import kotlinx.android.synthetic.main.item.*
import kotlinx.coroutines.*

//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding


class CustomerPersonFragment : Fragment(R.layout.fragment_person_customer) {

    var chatList = mutableListOf<ChatBotModel>()
    private lateinit var adapter: CustomerChatBotAdapter
    private val args: CustomerPersonFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var name = args.customerName

        tvAddName.text="$name"


        recyclerView()
        clickEvents()

        btnReceive.setOnClickListener {
            paymentSms()
        }

        tvViewProfile.setOnClickListener {

            val action= CustomerPersonFragmentDirections.actionCustomerPersonFragmentToProfileActivity()
            findNavController().navigate(action)

        }

        customerBack.setOnClickListener {

            val action=CustomerPersonFragmentDirections.actionGlobalHomeFragment()
            findNavController().navigate(action)

        }


    }
    
    private fun clickEvents() {
        btnSend.setOnClickListener {
            creditSms()
        }

        etSendMoney.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun creditSms() {
        val message = etSendMoney.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            chatList.add(ChatBotModel(message, SEND_ID, timeStamp))
            etSendMoney.setText("")


//            launch {
//                context?.let {sk ->
//                    val data= MyDatabase.getDatabase(sk).getSupplierChatDao()
//                         data.insert(SuppllierChatEnity(message, SEND_ID,timeStamp))
//                        data.getData()[0].
////                            chatList.clear()
////                            chatList.addAll(it)
//                adapter.insertMessage(data.getData())


            adapter.insertMessage(ChatBotModel(message, SEND_ID, timeStamp))

            rv_messages.scrollToPosition(adapter.itemCount - 1)


        }
    }

    private fun paymentSms() {
        val response = etReceiveMoney.text.toString()
        val timeStamp = Time.timeStamp()
        if (response.isNotEmpty()) {
            //Adds it to our local list
            GlobalScope.launch {
                //Fake response delay
                delay(100)

                withContext(Dispatchers.Main) {
                    chatList.add(ChatBotModel(response, RECEIVE_ID, timeStamp))
                    etReceiveMoney.setText("")

                    //Inserts our message into the adapter
                    adapter.insertMessage(ChatBotModel(response, RECEIVE_ID, timeStamp))

                    //Scrolls us to the position of the latest message

                    rv_messages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
    private fun recyclerView() {
        adapter = CustomerChatBotAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    }

//android:background="@drawable/round_button"

//android:background="@drawable/round_button"