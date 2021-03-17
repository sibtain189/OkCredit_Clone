package com.example.okcredit_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.okcredit_app.VerifyAdapter.VerifyFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_verify_mobile.*


class VerifyMobileFragment : Fragment() {
    private var viewPager2: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verify_mobile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setViewPageAdapter()

        tvVerify.setOnClickListener {
            val navController=findNavController()
                val action=VerifyMobileFragmentDirections.actionVerifyMobileFragmentToGiveNumberFragment()
                navController.navigate(action)
        }
    }

    private fun setViewPageAdapter() {

        val fragmentAdapter=VerifyFragmentAdapter(context as FragmentActivity)
        viewPager2?.adapter=fragmentAdapter
        tabLayout?.let {
            viewPager2?.let {
                it1 ->
                TabLayoutMediator(it,it1, TabLayoutMediator.TabConfigurationStrategy{ tab, position ->  }).attach()
            }
        }

    }

    private fun initView() {
        viewPager2=view?.findViewById(R.id.verifyViewPager)
        tabLayout=view?.findViewById(R.id.verifyTabLayout)
    }
}

