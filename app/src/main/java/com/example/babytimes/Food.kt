package com.example.babytimes

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.babytimes.databinding.FoodBinding


class Food : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food)

    }

    //Click listener that will navigate to main menu when button (from layout) is clicked. Also requires activity entry in manifest
    fun MainMenu(view: View) {
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
    }

    private var binding: FoodBinding? = null
    private val binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?
        savedInstanceState: Bundle?,
    ): View {
        binding = FoodBinding.inflate(inflater, container, attachToParent: false)

        val food = resources.getStringArray(R.array.select)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_items, food)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

}