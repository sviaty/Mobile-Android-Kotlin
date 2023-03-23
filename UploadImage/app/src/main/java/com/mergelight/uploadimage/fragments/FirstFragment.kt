package com.mergelight.uploadimage.fragments

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mergelight.uploadimage.R
import com.mergelight.uploadimage.activities.MainActivity
import com.mergelight.uploadimage.adapters.MainRecyclerViewAdapter
import com.mergelight.uploadimage.constants.Constants
import com.mergelight.uploadimage.models.GetUploadsImagesResponse
import com.mergelight.uploadimage.models.UploadRequestBody
import com.mergelight.uploadimage.models.UploadResponse
import com.mergelight.uploadimage.models.UploadsImages
import com.mergelight.uploadimage.retrofit.ApiRetrofitClient
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FirstFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var rvData: RecyclerView
    private lateinit var dataUploads: Array<UploadsImages>

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getDatas()
        Log.d("Fragment life cycle 1", "onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_first, container, false)
        Log.d("Fragment life cycle 1", "onCreateView")

        setupView()
        setupListenner()
        //setupRecyclerView()

        return viewOfFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment life cycle 1", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment life cycle 1", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment life cycle 1", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment life cycle 1", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment life cycle 1", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment life cycle 1", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment life cycle 1", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment life cycle 1", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment life cycle 1", "onDetach")
    }

    private fun setupView(){
        rvData = viewOfFragment.findViewById(R.id.rv_data)

    }

    private fun setupListenner(){

    }

    private fun setupRecyclerView(){
        rvData.layoutManager = LinearLayoutManager(activity)
        rvData.adapter =  MainRecyclerViewAdapter(dataUploads)
    }

    private fun getDatas() {
        var retrofit = ApiRetrofitClient.apiService
        retrofit.getUploadsImages().enqueue(object : Callback<GetUploadsImagesResponse> {
            override fun onResponse(call: Call<GetUploadsImagesResponse>, response: Response<GetUploadsImagesResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()
                    dataUploads = responseBody!!.mData
                    setupRecyclerView()
                }
            }

            override fun onFailure(call: Call<GetUploadsImagesResponse>, t: Throwable) {

            }

        })

    }
}