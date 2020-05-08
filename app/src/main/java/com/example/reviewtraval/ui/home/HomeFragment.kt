package com.example.reviewtraval.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reviewtraval.R
import kotlinx.android.synthetic.main.fragment_home2.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initRecycleView()
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    private fun initRecycleView() {
//        rcv.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter = NewFeedAdapter(context,)
//        }
    }

}
