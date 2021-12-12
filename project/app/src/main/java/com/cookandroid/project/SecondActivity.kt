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
import kotlinx.android.synthetic.main.second_main.*

class SecondActivity : AppCompatActivity() {
    private val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        SoundPool.Builder().setMaxStreams(8).build()
    } else {
        SoundPool(8, AudioManager.STREAM_MUSIC, 0)
    }
    private val sounds = listOf(
            Pair(R.id.medi1, R.raw.sound1),
            Pair(R.id.medi2, R.raw.sound1)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_main)
        title = "긁힘"
        sounds.forEach { tune(it) }

        button.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val mIntent = Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://terms.naver.com/entry.naver?docId=2123418&cid=51000&categoryId=51000"))
                        startActivity(mIntent)
                    }
                })
        button2.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://terms.naver.com/entry.naver?docId=1249862&cid=40942&categoryId=32820"))
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