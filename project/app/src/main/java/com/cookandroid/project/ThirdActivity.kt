package com.cookandroid.project

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.third_main.*


class ThirdActivity : AppCompatActivity()  {

    private val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        SoundPool.Builder().setMaxStreams(8).build()
    } else {
        SoundPool(8, AudioManager.STREAM_MUSIC, 0)
    }
    private val sounds = listOf(
            Pair(R.id.medi3, R.raw.sound1),
            Pair(R.id.medi4, R.raw.sound1)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.third_main)
        title = "화상"
        sounds.forEach { tune(it) }

        buttonA.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://terms.naver.com/entry.naver?docId=2141643&cid=51000&categoryId=51000"))
                        startActivity(mIntent)
                    }
                })
        buttonB.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://terms.naver.com/entry.naver?docId=2141082&cid=51000&categoryId=51000"))
                        startActivity(mIntent)
                    }
                })
    }
    private fun tune(pitch: Pair<Int, Int>) {
        val soundId = soundPool.load(this, pitch.second, 1)
        findViewById<ImageButton>(pitch.first).setOnClickListener {
            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}