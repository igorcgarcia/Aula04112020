package com.example.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_item_list.view.*

class ContactsAdapter( private val userList:List<User>,
                        private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position],onItemClicked)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(user: User, onItemClicked: (Int) -> Unit) = with(itemView){

            tvName.text = user.userName
            tvLastMessage.text = user.userLastMessage
            tvLastView.text = user.userLastView
            Glide.with(itemView.context).load(user.userProfileAvatar).into(ivAvatar)

            if (user.userMessagesCount > 0 ) {

                tvLastView.setTextColor(ContextCompat.getColor(context,R.color.green))
                btMessagesCount.text = user.userMessagesCount.toString()
                btMessagesCount.isVisible = true
            }

            MainContainer.setOnClickListener(){
                onItemClicked(this@ViewHolder.adapterPosition)

                //modelo antigo para verificar o clique no recycle
////                Log.i("CLICK",this@ViewHolder.adapterPosition.toString())
//                //mainAdapterListener.onItemClicked(this@ViewHolder.adapterPosition)
            }


//            if (user.userCash > 0.0){
//                tvItemCash.text = context.getString(R.string.main_adapter_cash,user.userCash)
////                tvItemCash.visibility = VISIBLE
//                tvItemCash.isVisible = true
//            }
//            tvNick.text = user.userId
//            tvNome.text = user.userName
        }
    }
}