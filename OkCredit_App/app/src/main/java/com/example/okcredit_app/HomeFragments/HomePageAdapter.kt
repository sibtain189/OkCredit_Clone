package com.example.okcredit_app.HomeFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.okcredit_app.HomeFragments.TabFragments.CustomerFragment
import com.example.okcredit_app.HomeFragments.TabFragments.SupllierFragment

class HomePageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){

            0 ->return CustomerFragment()
            1 ->return SupllierFragment()
        }
        return CustomerFragment()
    }
}