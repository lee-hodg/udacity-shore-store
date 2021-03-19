package com.udacity.shoestore.ui.shoeadd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeAddFragmentBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.SharedShoeViewModel


class ShoeAddFragment : Fragment() {


    private lateinit var binding: ShoeAddFragmentBinding
    private val viewModel: SharedShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_add_fragment,
                container,
                false
        )

        // cancel button takes us back to the shoe listing
        binding.cancelButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_shoeAddFragment_to_shoe_listing_destination)
        }

        // the save button needs to create a new Shoe object and add to the list
        binding.saveButton.setOnClickListener {
            val shoeName = binding.shoenameEdittext.text
            val shoeCompany = binding.companyEdittext.text
            val shoeSize = binding.shoesizeEdittext.text
            val shoeDescription = binding.descriptionEdittext.text
            if(shoeName.isNullOrEmpty() || shoeSize.isNullOrEmpty() || shoeCompany.isNullOrEmpty() || shoeDescription.isNullOrEmpty()) {
                Toast.makeText(context, getString(R.string.field_required), Toast.LENGTH_SHORT).show()
            } else {
                // add the shoe
                viewModel.addShoe(
                        Shoe(shoeName.toString(), shoeSize.toString().toDouble(),
                             shoeCompany.toString(),shoeDescription.toString(),
                                mutableListOf(R.mipmap.generic_shoe))
                )
                // back to listing
                view?.findNavController()?.navigate(R.id.action_shoeAddFragment_to_shoe_listing_destination)
            }
        }


        return binding.root
    }


}