package com.example.shoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.ShopListRepositoryImpl
import domain.DeleteShopItemUseCase
import domain.EditShopItemUseCase
import domain.GetShopListUseCase
import domain.ShopItem

class MainViewModel:ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getshopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editshopListUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
       val list = getshopListUseCase.getShopList()
        shopList.value= list
    }

    fun editShopItem(shopItem: ShopItem){
        val newItem = shopItem.copy(changed = !shopItem.changed)
        editshopListUseCase.editShopItem(newItem)
        getShopList()

    }
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }


}