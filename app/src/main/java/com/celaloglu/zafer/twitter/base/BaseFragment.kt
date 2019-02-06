package com.celaloglu.zafer.twitter.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.celaloglu.zafer.twitter.TwitterApplication
import com.celaloglu.zafer.twitter.di.component.DaggerFragmentComponent
import com.celaloglu.zafer.twitter.di.component.FragmentComponent

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var binding: B
    protected lateinit var fragmentComponent: FragmentComponent

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
                getLayoutId(), container, false)
        fragmentComponent = DaggerFragmentComponent
                .builder()
                .appComponent(TwitterApplication.appComponent)
                .build()
        return binding.root
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}