package com.simxid.slide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.request.RequestOptions

import com.simxid.slider.SliderLayout
import com.simxid.slider.SliderTypes.DefaultSliderView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var samples :List<Int> = listOf(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)

        slider.setPresetTransformer(SliderLayout.Transformer.Accordion)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        val reqOption = RequestOptions()
        reqOption.centerCrop()

        slider.setDuration(4000)
        for (i in samples.indices){
            var defaultSliderView = DefaultSliderView(this)
            defaultSliderView.image(samples[i]).setRequestOption(reqOption).setProgressBarVisible(true).setBackgroundColor(R.color.colorAccent)
            slider.addSlider(defaultSliderView)
        }
    }

    override fun onStop() {
        slider.stopAutoCycle()
        super.onStop()
    }
}
