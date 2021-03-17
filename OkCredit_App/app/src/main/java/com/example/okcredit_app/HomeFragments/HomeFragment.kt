package com.example.okcredit_app.HomeFragments

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
//import com.example.okcredit_app.HomeFragmentDirections
import com.example.okcredit_app.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home){

    private var viewPager:ViewPager2?=null
    private var tabLayout: TabLayout?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setViewPagerAdapter()
    }

    private fun initView() {
       viewPager=view?.findViewById(R.id.vPager1)
        tabLayout=view?.findViewById(R.id.tabLayout1)
    }

    private fun setViewPagerAdapter() {
        val homePagerAdapter=HomePageAdapter(context as FragmentActivity)
        vPager1?.adapter=homePagerAdapter
        tabLayout?.let{

            vPager1?.let {

                it1 ->

                TabLayoutMediator(it,it1,TabLayoutMediator.TabConfigurationStrategy { tab, position ->  
                    
                    when(position){

                        0 -> tab.text="CUSTOMER"
                        1 -> tab.text="SUPPLIER"
                    }
                }).attach()
            }

        }
    }

}
