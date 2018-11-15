package com.oleynikov.testuran.data_classes

import com.google.gson.annotations.SerializedName

data class Exhibit(
    @SerializedName("list")
    val list: List<Item>
) {
    data class Item(
        @SerializedName("images")
        val images: List<String>,
        @SerializedName("title")
        val title: String
    )
}