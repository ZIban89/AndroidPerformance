package ru.clevertec.nikonov.androidperformance.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.clevertec.nikonov.androidperformance.R
import ru.clevertec.nikonov.androidperformance.databinding.ActivityMainBinding
import ru.clevertec.nikonov.androidperformance.presentation.fragment.ProductsFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, ProductsFragment::class.java, null)
            commit()
        }
    }

}