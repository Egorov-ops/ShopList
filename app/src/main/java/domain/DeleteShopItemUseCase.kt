package domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItemId:ShopItem){
        shopListRepository.deleteShopItem(shopItemId)
    }
}