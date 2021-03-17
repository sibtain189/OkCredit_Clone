package com.example.okcredit_app.HomeFragments.TabFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okcredit_app.R
import kotlinx.android.synthetic.main.fragment_person_customer.*
import kotlinx.android.synthetic.main.fragment_person_supplier.*

import kotlinx.coroutines.*

//import com.example.okcredit_app.databinding.FragmentAccountBinding
//import com.example.okcredit_app.databinding.FragmentProfileBinding

class SupplierPersonFragment : Fragment(R.layout.fragment_person_supplier){

    var chatList = mutableListOf<ChatBotModelSupplier>()
    private lateinit var adapter: SupplierChatBotAdapter
    private val args: SupplierPersonFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController=findNavController()

        var name=args.supplierName
        tvName.text="$name"

        recyclerView()
        clickEvents()

        btnPayment.setOnClickListener {
            paymentSms()
        }
        
        supplierBack.setOnClickListener {

            val action=SupplierPersonFragmentDirections.actionGlobalHomeFragment()
            findNavController().navigate(action)
        }
    }

    private fun clickEvents() {
        btnCredit.setOnClickListener {
            creditSms()
        }

        etCreditMoney.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_message_supplier.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun creditSms() {
        val message = etCreditMoney.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            chatList.add(ChatBotModelSupplier(message, ConstantsSupplier.SEND_ID_SUPPLIER, timeStamp))
            etCreditMoney.setText("")

            adapter.insertMessage(ChatBotModelSupplier(message , ConstantsSupplier.SEND_ID_SUPPLIER, timeStamp))

            rv_message_supplier.scrollToPosition(adapter.itemCount - 1)

        }
    }

    private fun paymentSms() {
        val response = etPaymentMoney.text.toString()
        val timeStamp = Time.timeStamp()
        if (response.isNotEmpty()) {
            //Adds it to our local list
            GlobalScope.launch {
                //Fake response delay
                delay(100)

                withContext(Dispatchers.Main) {
                    chatList.add(ChatBotModelSupplier(response, ConstantsSupplier.RECEIVE_ID_SUPPLIER, timeStamp))
                    etPaymentMoney.setText("")

                    //Inserts our message into the adapter
                    adapter.insertMessage(ChatBotModelSupplier(response, ConstantsSupplier.RECEIVE_ID_SUPPLIER, timeStamp))

                    //Scrolls us to the position of the latest message

                    rv_message_supplier.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
    private fun recyclerView() {
        adapter = SupplierChatBotAdapter()
        rv_message_supplier.adapter = adapter
        rv_message_supplier.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_message_supplier.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}
