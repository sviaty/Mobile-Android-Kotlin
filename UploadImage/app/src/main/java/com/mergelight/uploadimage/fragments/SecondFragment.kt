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
import com.mergelight.uploadimage.R
import com.mergelight.uploadimage.activities.MainActivity
import com.mergelight.uploadimage.constants.Constants
import com.mergelight.uploadimage.models.UploadRequestBody
import com.mergelight.uploadimage.models.UploadResponse
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

class SecondFragment : Fragment(), UploadRequestBody.UploadCallback {

    private lateinit var viewOfFragment: View

    private lateinit var ivImage: ImageView
    private lateinit var btnUpload: Button
    private lateinit var progressBar: ProgressBar

    private var selectedImageUri: Uri? = null

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment life cycle 1", "onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_second, container, false)
        Log.d("Fragment life cycle 1", "onCreateView")

        setupView()
        setupListenner()

        return viewOfFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment life cycle 1", "onViewCreated")
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
        ivImage = viewOfFragment.findViewById(R.id.image_view)
        btnUpload = viewOfFragment.findViewById(R.id.button)
        progressBar = viewOfFragment.findViewById(R.id.progressBar)
    }

    private fun setupListenner(){
        ivImage.setOnClickListener {
            openImageChooser()
        }

        btnUpload.setOnClickListener {
            uploadImage()
        }
    }

    private fun openImageChooser() {
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI).also {
            val mimeTypes = arrayOf("image/jpeg", "image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startForResult.launch(it)
        }
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        Log.d("image","resultCode : "+result.resultCode)

        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data?.data
            ivImage.setImageURI(selectedImageUri)
        }
    }

    private fun uploadImage() {
        if(selectedImageUri == null){
            Toast.makeText(
                activity,
                "Pas d'image selectionner",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val parcelFileDescriptor = activity?.contentResolver?.openFileDescriptor(selectedImageUri!!, "r", null) ?: return
        val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        val file = File(activity?.cacheDir,activity?.contentResolver?.getFileName(selectedImageUri!!))
        val outputStream = FileOutputStream(file)
        inputStream.copyTo(outputStream)
        progressBar.progress = 0

        val body = UploadRequestBody(file,"image",this)
        val multi = MultipartBody.Part.createFormData(
            "image",
            file.name,
            body
        )
        val desc = RequestBody.create(MediaType.parse("multipart/form-data"),"json")

        /*
        var retrofit = ApiRetrofitClient.apiService
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = retrofit.uploadImage2(multi, desc)
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()

                    Snackbar.make(rootLayout, responseBody!!.message, Snackbar.LENGTH_LONG)
                    progressBar.progress = 100
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (t: Throwable) {
                t?.printStackTrace()
            }
        }
        */

        var retrofit = ApiRetrofitClient.apiService
        retrofit.uploadImage(multi, desc).enqueue(object : Callback<UploadResponse> {
            override fun onResponse(call: Call<UploadResponse>, response: Response<UploadResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()

                    Toast.makeText(
                        activity,
                        responseBody!!.message,
                        Toast.LENGTH_SHORT
                    ).show()

                    val activity = activity as MainActivity
                    activity.changeFragment(FirstFragment.newInstance())
                }
            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                Toast.makeText(
                    activity,
                    t.message!!,
                    Toast.LENGTH_SHORT
                ).show()

                progressBar.progress = 0
            }

        })

    }

    private fun ContentResolver.getFileName(selectedImageUri: Uri): String {
        var name = ""
        val returnCursor = this.query(selectedImageUri,null,null,null,null)
        if (returnCursor!=null){
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            name = returnCursor.getString(nameIndex)
            returnCursor.close()
        }

        return name
    }

    override fun onProgressUpdate(percentage: Int) {
        progressBar.progress = percentage
    }
}