package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = mutableListOf<User>()
        val user1 = User("https://randomuser.me/api/portraits/men/19.jpg","Igor Garcia","última mensagem teste","YESTERDAY")
        val user2 = User("https://randomuser.me/api/portraits/men/51.jpg","Fabricio","olá","11:45 AM",3)
        val user3 = User("https://randomuser.me/api/portraits/men/29.jpg","Leda","Hey","12:11 PM",5)
        val user4 = User("https://randomuser.me/api/portraits/men/91.jpg","Pedro","PIG5","TODAY")

        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)

//        val recyclerView = findViewById<RecyclerView>(R.id.rvHomeUserList)
//        recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
//        recyclerView.adapter = ItemAdapter(users)

        findViewById<RecyclerView>(R.id.rvHomeUserList).apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ContactsAdapter(users) {position ->
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra(KEY_INTENT_USER,users[position])
                startActivity(intent)
            }
        }
    }

    companion object{
        const val KEY_INTENT_USER = "user"
    }
}