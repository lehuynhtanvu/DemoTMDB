package com.vule.demotmdb.extension

import android.view.View
import android.widget.Toast
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.Status


inline fun <reified T> View.bindResource(resource: Resource<T>?, onSuccess: (Resource<T>) -> Unit) {
    if (resource != null) {
        when (resource.status) {
            Status.LOADING -> Unit
            Status.SUCCESS -> onSuccess(resource)
            Status.ERROR ->
                Toast.makeText(context,
                    resource.errorEnvelope?.status_message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
