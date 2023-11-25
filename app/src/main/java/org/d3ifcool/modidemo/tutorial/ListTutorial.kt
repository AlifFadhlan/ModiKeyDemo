package org.d3ifcool.modidemo.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.d3ifcool.modidemo.databinding.ActivityListTutorialBinding

class ListTutorial : AppCompatActivity() {

    private val viewModel: TutorViewModel by lazy {
        ViewModelProvider(this)[TutorViewModel::class.java]
    }

    private lateinit var binding: ActivityListTutorialBinding
    private lateinit var myAdapter: TutorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = TutorAdapter()
        with(binding.recyclerViewTut){
            layoutManager = GridLayoutManager(applicationContext,2)
            setHasFixedSize(true)
            adapter = myAdapter
        }

        viewModel.getData().observe(this) {
            myAdapter.updateData(it)
        }
    }
}