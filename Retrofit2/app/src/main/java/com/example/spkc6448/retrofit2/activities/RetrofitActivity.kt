package com.example.spkc6448.retrofit2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.spkc6448.retrofit2.R
import com.example.spkc6448.retrofit2.clients.UnivClientInterface
import com.example.spkc6448.retrofit2.retrofit.RetrofitProvider
import com.example.spkc6448.retrofit2.models.UnivListModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitActivity : AppCompatActivity() {

    // injection du client avec dagger
    @Inject
    var mUnivClientInterface: UnivClientInterface? = null

    // déclaration du client
    private var mRetrofitProvider: RetrofitProvider? = null
    private lateinit var mUnivClient: UnivClientInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRetrofitProvider = RetrofitProvider("http://dufour-mikhael.fr/")
        mUnivClient = mRetrofitProvider?.univClientInterface!!

        getUnivList(mUnivClient)
        getUnivList(mUnivClientInterface!!)
        getUnivListWithRxJava()
    }

    private fun getUnivList(univClient: UnivClientInterface){
        univClient.getUnivList().enqueue(object : Callback<UnivListModel> {
            override fun onResponse(univListModelResponse: Call<UnivListModel>, univListResponse: Response<UnivListModel>) {
                if (univListResponse.isSuccessful) {
                    val univListModel = univListResponse.body()
                    val univListSize = univListModel?.mUnivList?.size
                    Log.d("univListWithRxJava : ", "nombre d univ = $univListSize")
                } else {

                }
            }
            override fun onFailure(call: Call<UnivListModel>, t: Throwable) {
                Log.e("univListError : ", "Retrofit error : $t")
            }
        })
    }

    private fun getUnivListWithRxJava() {
        mUnivClientInterface!!.getUnivListWithRxJava().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {   result ->
                    val univListSize = result?.mUnivList?.size
                    Log.d("univListWithRxJava : ", "nombre d univ = $univListSize")
                },
                {   error ->
                    Log.e("univListError : ", "retrofit error : $error")
                }
            )
    }
}
