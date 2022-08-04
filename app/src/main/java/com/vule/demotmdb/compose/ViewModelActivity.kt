package com.vule.demotmdb.compose

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class ViewModelActivity : AppCompatActivity() {

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int
    ): T = DataBindingUtil.setContentView(this, resId)
}
