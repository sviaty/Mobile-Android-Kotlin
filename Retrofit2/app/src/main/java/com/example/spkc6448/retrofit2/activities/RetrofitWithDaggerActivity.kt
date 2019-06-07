package com.example.spkc6448.retrofit2.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.spkc6448.retrofit2.R
import com.example.spkc6448.retrofit2.clients.UnivClientInterface
import com.example.spkc6448.retrofit2.models.UnivListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitWithDaggerActivity: AppCompatActivity() {

    @Inject
    var mUnivClientInterface: UnivClientInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUnivList()
    }

    private fun getUnivList(){
        mUnivClientInterface!!.getUnivList().enqueue(object : Callback<UnivListModel> {
            override fun onResponse(univListModelResponse: Call<UnivListModel>, univListResponse: Response<UnivListModel>) {
                if (univListResponse.isSuccessful) {
                    val univListModel = univListResponse.body()
                    Log.d("univListResponse : ", "nombre d univ = "+univListModel?.mUnivList?.size)
                } else {

                }
            }
            override fun onFailure(call: Call<UnivListModel>, t: Throwable) {
                Log.e("univListError : ", "Retrofit error : $t")
            }
        })
    }
}