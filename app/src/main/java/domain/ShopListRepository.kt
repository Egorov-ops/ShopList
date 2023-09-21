package domain

interface ShopListRepository  {
    fun addShopItem(shopItem: ShopItem)
    fun getShopList():List<ShopItem>
    fun getShopItem(shopItemId: ShopItem):ShopItem
    fun editShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItemId:ShopItem)
}