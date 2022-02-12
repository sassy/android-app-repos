/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog
import com.example.dogglers.const.Layout


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dog_image = view?.findViewById<ImageView>(R.id.item_image)
        val dog_name  = view?.findViewById<TextView>(R.id.item_name)
        val dog_age = view?.findViewById<TextView>(R.id.item_age)
        val dog_hobbies = view?.findViewById<TextView>(R.id.item_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val layoutType = if (layout == Layout.GRID) R.layout.grid_list_item else R.layout.vertical_horizontal_list_item

        val adapterLayout = LayoutInflater.from(parent.context).inflate(layoutType, parent,false)

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val dog = dataset[position]
        // TODO: Set the image resource for the current dog
        val resources = context?.resources
        holder.dog_image?.setImageResource(dog.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.dog_name?.text = dog.name
        // TODO: Set the text for the current dog's age
        holder.dog_age?.text = "Age: " + dog.age

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dog_hobbies?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
