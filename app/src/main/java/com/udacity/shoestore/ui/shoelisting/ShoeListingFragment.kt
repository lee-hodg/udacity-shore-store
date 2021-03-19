package com.udacity.shoestore.ui.shoelisting

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding
import com.udacity.shoestore.ui.SharedShoeViewModel
import timber.log.Timber


class ShoeListingFragment : Fragment() {


    private lateinit var binding: ShoeListingFragmentBinding

    // https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    //    very ViewModel will be tied to a scope (either an Activity or a Fragment) and lives as long
    //    as the scope is available. An Activity or Fragment can have multiple ViewModel's but a
    //    ViewModel will always be tied to single Activity/Fragment.
    //    Here, the goal is to share data between Shoe details screen and the listing screen,
    //    which are essentially Fragments hosted in the same Activity. Hence, the requirement
    //    comes down to creating a ViewModel with Activity scope in each of the Fragment's and
    //    use to set/get the data, which you have done correctly as:
    // could also be viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
    private val sharedViewModel: SharedShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_listing_fragment,
            container,
            false
        )

        // dynamically add the shoes to the linear layout of the listing
        val shoesLayout = binding.root.findViewById<LinearLayout>(R.id.shoe_list_linear_layout)

        Timber.i("Add the shoes")
        sharedViewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val shoeItemBinding = DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater,
                    R.layout.shoe_item, container, false
                )
                shoeItemBinding.shoe = shoe

                shoesLayout.addView(shoeItemBinding.root)
            }
        })

        // preferred way is to have Navigation create the on click listener
        binding.newShoeButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        R.id.action_shoe_listing_destination_to_shoeAddFragment))

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}