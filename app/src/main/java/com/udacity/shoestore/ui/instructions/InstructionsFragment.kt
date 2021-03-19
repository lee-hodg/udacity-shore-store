package com.udacity.shoestore.ui.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.ui.welcome.WelcomeFragmentDirections


class InstructionsFragment : Fragment() {

    // https://medium.com/androiddevelopers/use-view-binding-to-replace-findviewbyid-c83942471fc
    private lateinit var binding: InstructionsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment,
            container,
            false
        )

        binding.shoeListButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsToShoeListing())
        }


        return binding.root
    }


}