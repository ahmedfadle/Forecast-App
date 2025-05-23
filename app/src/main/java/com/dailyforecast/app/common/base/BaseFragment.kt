package com.dailyforecast.app.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>() :
    Fragment() {
    private var _binding: VB? = null

     val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding( )
        return binding.root
    }




    abstract fun getViewBinding( ): VB?

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun attachFragment( fragment:Fragment,bundle:Bundle,conytianer:Int){
        fragment.arguments=bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(conytianer, fragment, fragment.javaClass.name.toString())
            .disallowAddToBackStack()
            .commit()

    }
}