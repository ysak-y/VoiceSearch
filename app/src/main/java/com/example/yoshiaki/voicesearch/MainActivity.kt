package com.example.yoshiaki.voicesearch

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.amazonaws.regions.Regions
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.services.s3.AmazonS3Client
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.StringSignature
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImageView = findViewById(R.id.imageView) as ImageView
        Glide.with(this)
                .load("https://s3.amazonaws.com/yoshiaki-raspi-camera/picture.jpg")
                .signature(StringSignature(System.currentTimeMillis().toString()))
                .into(mImageView)

        /*
        val task = object: AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                val credentialsProvider = CognitoCachingCredentialsProvider(
                        applicationContext,
                        "us-east-1:b4e94924-d51e-4888-957c-2fd1bea3b11d", // Identity Pool ID
                        Regions.US_EAST_1 // Region
                )
                val sS3Client = AmazonS3Client(credentialsProvider)
                val content = sS3Client.getObject("yoshiaki-raspi-camera", "picture.jpg").objectContent
                val img = BitmapFactory.decodeStream(content)
                mImageView?.setImageBitmap(img)
                return null
            }
        }
        task.execute()
        */
    }

    override fun onResume() {
        Log.d("VoiceSearch", "onResume: ")
        super.onResume()
    }
}