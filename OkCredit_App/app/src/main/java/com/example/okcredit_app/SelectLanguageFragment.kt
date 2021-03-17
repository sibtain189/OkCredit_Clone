package com.example.okcredit_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
//import com.example.okcredit_app.HomeFragmentDirections.actionHomeFragmentToGiveNumberFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_select_language.*


class SelectLanguageFragment : Fragment(R.layout.fragment_select_language){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val navController=findNavController()



        ivEnglish.setOnClickListener {
            ivEnglish.toggle()
        }
        ivHindi.setOnClickListener {
            ivHindi.toggle()
        }
        ivMarathi.setOnClickListener {
            ivMarathi.toggle()
        }
        ivHinglish.setOnClickListener {
            ivHinglish.toggle()
        }
        ivGujrati.setOnClickListener {
            ivGujrati.toggle()
        }
        ivTamil.setOnClickListener {
            ivTamil.toggle()
        }
        ivTelugu.setOnClickListener {
            ivTelugu.toggle()
        }
        ivPunjabi.setOnClickListener {
            ivPunjabi.toggle()
        }
        ivMalyalam.setOnClickListener {
            ivMalyalam.toggle()
        }
        ivKannada.setOnClickListener {
            ivKannada.toggle()
        }
        ivBangla.setOnClickListener {
            ivBangla.toggle()
        }


        tvNext.setOnClickListener {
            val action=SelectLanguageFragmentDirections.actionSelectLanguageFragmentToVerifyMobileFragment()
            findNavController().navigate(action)
        }

    }

}
