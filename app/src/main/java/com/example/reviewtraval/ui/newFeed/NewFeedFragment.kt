package com.example.reviewtraval.ui.newFeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.reviewtraval.BR
import com.example.reviewtraval.HistoryFragment
import com.example.reviewtraval.R
import com.example.reviewtraval.databinding.FragmentNewFeedBinding
import com.example.reviewtraval.ui.home.HomeFragment

/**
 * A simple [Fragment] subclass.
 */
class NewFeedFragment : Fragment() {

    lateinit var binding: FragmentNewFeedBinding

    private val homFragment by lazy { HomeFragment() }

    private val historyFragment by lazy { HistoryFragment() }

    private var idMenuSelected: Int = R.id.navigation_home

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_new_feed, container, false)

        binding.setVariable(BR.newFeedListener, this)

        requireActivity().supportFragmentManager.beginTransaction().add(R.id.container, homFragment)
            .commit()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavtigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    if (idMenuSelected != it.itemId) {
                        idMenuSelected = it.itemId
                        openFragment(homFragment)
                    }

                }
                R.id.navigation_history -> {

                    if (idMenuSelected != it.itemId) {
                        idMenuSelected = it.itemId
                        openFragment(historyFragment)
                    }
                }
            }

        }
    }

    fun openFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()


    }
}