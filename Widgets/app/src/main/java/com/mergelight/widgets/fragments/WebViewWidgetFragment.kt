package com.mergelight.widgets.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.mergelight.widgets.R


class WebViewWidgetFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var webView: WebView

    companion object {
        fun newInstance(): WebViewWidgetFragment {
            return WebViewWidgetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_web_view_widget, container, false)
        Log.d("Fragment Edit Text", "onCreateView")

        setupView()
        //setupListenner()
        setupWebView()

        return viewOfFragment
    }

    private fun setupView(){
        webView = viewOfFragment.findViewById(R.id.webView)
    }

    private fun setupWebView(){
        val url = "https://meteofrance.com/"

        //webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }
}