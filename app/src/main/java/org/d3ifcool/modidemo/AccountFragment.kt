package org.d3ifcool.modidemo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar
import org.d3ifcool.modidemo.databinding.FragmentAccountBinding
import org.d3ifcool.modidemo.informasi.ListInformasi

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    private lateinit var topAppBar : MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        topAppBar = binding.topAppBar

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.privacyNav -> {
                    val intent = Intent(context, ListInformasi::class.java)
                    startActivity(intent)
                    true
                }

                R.id.aboutNav -> {
                    val intent = Intent(context, ListInformasi::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
        return binding.root

    }

}