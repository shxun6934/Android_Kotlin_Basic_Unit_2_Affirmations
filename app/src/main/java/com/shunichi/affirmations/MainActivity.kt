package com.shunichi.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.shunichi.affirmations.data.Datasource
import com.shunichi.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = Datasource().loadAffirmations()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // binding.recyclerView.layoutManager = GridLayoutManager(this, 3)

        binding.recyclerView.withModels {
            data.forEachIndexed { index, data ->
                listItem {
                    id(index)
                    itemTitle(resources.getString(data.stringResourceId))
                    itemImage(ResourcesCompat.getDrawable(resources, data.imageResourceId, null))
                }
            }
        }
    }
}