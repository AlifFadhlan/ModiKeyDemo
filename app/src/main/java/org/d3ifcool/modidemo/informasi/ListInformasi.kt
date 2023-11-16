package org.d3ifcool.modidemo.informasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3ifcool.modidemo.R
import org.d3ifcool.modidemo.databinding.ActivityListInformasiBinding

class ListInformasi : AppCompatActivity() {

    private val viewModel: InformasiViewModel by lazy {
        ViewModelProvider(this)[InformasiViewModel::class.java]
    }

    private lateinit var binding: ActivityListInformasiBinding
    private lateinit var myAdapter: InformasiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = InformasiAdapter()
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@ListInformasi)
            setHasFixedSize(true)
            adapter = myAdapter
        }
        viewModel.getData().observe(this) {
            myAdapter.updateData(it)
        }
    }
}