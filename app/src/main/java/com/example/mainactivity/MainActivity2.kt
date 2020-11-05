package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mainactivity.MainActivity.Companion.KEY_INTENT_USER
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.main_item_list.view.*

class MainActivity2 : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        user = intent.getParcelableExtra<User>(KEY_INTENT_USER)

        setupUser()

    }

    private fun setupUser() {
        Glide.with(this).load(user?.userProfileAvatar).into(ivAvatar)
        tvName.text = user?.userName
        tvLastMessage.text = user?.userLastMessage
        tvLastView.text = user?.userLastView
    }
}