package org.d3ifcool.modidemo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.d3ifcool.modidemo.databinding.ActivityMainBinding
import org.d3ifcool.modidemo.informasi.ListInformasi


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate layout

        setContentView(binding.root) // set content view

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeNav -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.timelineNav -> {
                    replaceFragment(TimelineFragment())
                    true
                }

                R.id.accountNav -> {
                    replaceFragment(AccountFragment())
                    true
                }

                else -> false
            }
        }

        replaceFragment(HomeFragment())


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    fun onCardClick(view: View){
        when(view.id) {
            R.id.card -> {
                val intent = Intent(this, ListInformasi::class.java)
                startActivity(intent)
            }
        }
    }

}