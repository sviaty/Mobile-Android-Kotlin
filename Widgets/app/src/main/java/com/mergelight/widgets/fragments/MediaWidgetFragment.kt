package com.mergelight.widgets.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.mergelight.widgets.R

class MediaWidgetFragment : Fragment() {

    private lateinit var viewOfFragment: View
    private lateinit var videoView: VideoView
    private lateinit var mediaController: MediaController

    companion object {
        fun newInstance(): MediaWidgetFragment {
            return MediaWidgetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfFragment = inflater.inflate(R.layout.fragment_media_widget, container, false)
        Log.d("Fragment Media", "onCreateView")

        setupView()
        //setupListenner()
        setupVideoView()

        return viewOfFragment
    }

    private fun setupView(){
        videoView = viewOfFragment.findViewById(R.id.videoView)
        mediaController = MediaController(activity);
    }

    private fun setupVideoView(){

        videoView.setVideoPath("android.resource://" + activity?.packageName + "/" + R.raw.video)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
    }
}