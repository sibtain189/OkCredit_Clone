package com.example.okcredit_app.VerifyAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VerifyFragmentAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position)
        {
            0 -> return DigitalBahiKhataFragment()
            1 -> return GreateCustomerFragment()
            2 -> return SafeSecureFragment()
            3 -> return TimelyConnectionFragment()
        }
        return DigitalBahiKhataFragment()
    }
}