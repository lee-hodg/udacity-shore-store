package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class SharedShoeViewModel : ViewModel() {


    //private var shoeList = mutableListOf<Shoe>()
    private val _shoeListLiveData: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoeListLiveData: LiveData<MutableList<Shoe>>
        get() = _shoeListLiveData

    init {
        _shoeListLiveData.value = mutableListOf(
                Shoe("Diamante Heels",37.5,"Prada",
                    "These shoes will really make an impression.",
                    mutableListOf(R.mipmap.heels)),
                Shoe("Sparkly Heels",42.7,"Gucci",
                    "For the discerning lady.",
                    mutableListOf(R.mipmap.heels2)),
                Shoe("Blue Heels",41.4,"Fendi",
                    "Feeling blue? We got you covered.",
                    mutableListOf(R.mipmap.blueheels)),
                Shoe("Red Heels",41.4,"JimmyChoo",
                    "Be the lady in red.",
                    mutableListOf(R.mipmap.redheels)),
                Shoe("Star Heels",38.1,"JimmyChoo",
                    "Be the star of your life.",
                    mutableListOf(R.mipmap.starheels)),
                Shoe("Premium Heels",45.3,"JimmyChoo",
                    "Putting the Choo in Shoe.",
                    mutableListOf(R.mipmap.chooheels))
            )

    }

    fun addShoe(shoe: Shoe){
        _shoeListLiveData.value?.add(shoe)
    }
}