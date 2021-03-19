package com.udacity.shoestore.ui.welcome

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding


class WelcomeFragment : Fragment() {


    private lateinit var binding: WelcomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        binding.buttonInstructions.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToInstructions())
        }

        return binding.root
    }


}