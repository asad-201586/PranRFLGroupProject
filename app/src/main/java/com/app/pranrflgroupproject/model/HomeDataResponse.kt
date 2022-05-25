package com.app.pranrflgroupproject.model


import com.google.gson.annotations.SerializedName

data class HomeDataResponse(
    @SerializedName("data")
    val data: List<Data>
): CommonResponse() {
    data class Data(
        @SerializedName("cat_alias")
        val catAlias: String,
        @SerializedName("cat_behaviour")
        val catBehaviour: CatBehaviour? = null,
        @SerializedName("cat_desc")
        val catDesc: String,
        @SerializedName("cat_id")
        val catId: String,
        @SerializedName("cat_name")
        val catName: String,
        @SerializedName("cat_type")
        val catType: String,
        @SerializedName("category_data")
        val categoryData: List<CategoryData>,
        @SerializedName("home_position")
        val homePosition: Int,
        @SerializedName("_id")
        val id: String,
        @SerializedName("is_static")
        val isStatic: Boolean,
    ) {
        data class CatBehaviour(
            @SerializedName("mobile_column")
            var column: Int,
            @SerializedName("type")
            val type: String
        )

        data class CategoryData(
            @SerializedName("alias")
            val alias: String,
            @SerializedName("cat_alias")
            val catAlias: String,
            @SerializedName("cat_name")
            val catName: String,
            @SerializedName("dis_image")
            val disImage: String,
            @SerializedName("dis_name")
            val disName: String,
            @SerializedName("_id")
            val id: String,
            @SerializedName("image")
            val image: String,
            @SerializedName("images")
            val images: String,
            @SerializedName("inventory")
            val inventory: List<Inventory>,
            @SerializedName("is_showcasing")
            val isShowcasing: Int,
            @SerializedName("item_name")
            val itemName: String,
            @SerializedName("sku_type")
            val skuType: String
        ) {
            data class Inventory(
                @SerializedName("capacity")
                val capacity: String,
                @SerializedName("discount")
                val discount: Double,
                @SerializedName("item_variation_option_id")
                val itemVariationOptionId: Int,
                @SerializedName("price")
                val price: Double,
                @SerializedName("qty_in_pcs")
                val qtyInPcs: Int,
                @SerializedName("regular_price")
                val regularPrice: Double,
                @SerializedName("stock_qty")
                val stockQty: Int,
                @SerializedName("variation_option_id")
                val variationOptionId: Int,
                @SerializedName("variation_option_name")
                val variationOptionName: String
            )
        }
    }
}