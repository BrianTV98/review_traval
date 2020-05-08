package com.example.reviewtraval.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reviewtraval.R
import com.example.reviewtraval.data.Model.NewFeedModel
import com.example.reviewtraval.databinding.ItemNewFeedLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_new_feed_layout.view.*

class NewFeedAdapter (val context: Context,val list : List<NewFeedModel>) : RecyclerView.Adapter<NewFeedAdapter.NewFeedViewHodel>(){

    class NewFeedViewHodel(view:View): RecyclerView.ViewHolder(view) {
        val imv_avata = view.findViewById<CircleImageView>(R.id.imv_avata_owner)
        val tv_name = view.findViewById<TextView>(R.id.name_owner)
        val btn_more = view.findViewById<Button>(R.id.btn_more)
        val content = view.findViewById<TextView>(R.id.tv_content)
        val imv_media = view.findViewById<ImageView>(R.id.imv_media)
        val btn_like = view.findViewById<Button>(R.id.btn_like)
        val btn_commnet = view.findViewById<Button>(R.id.btn_commnent)
        val btn_share = view.findViewById<Button>(R.id.btn_share)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewFeedViewHodel {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_new_feed_layout, parent, false)

        view.btn_commnent.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context, R.style.BottomSheetDialogTheme)
            val bottomSheetView :View = LayoutInflater.from(context).inflate(R.layout.layout_bottom_sheet_comment,parent)
            bottomSheetView.findViewById<Button>(R.id.btn_send).setOnClickListener {
                Toast.makeText(context,"Share", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
        return NewFeedViewHodel(view)

    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: NewFeedViewHodel, position: Int) {
        holder.tv_name.text = list.get(position).owner.toString()
    }

}