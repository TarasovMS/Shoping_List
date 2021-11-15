package com.persAssistant.shopping_list.domain.interactor_interfaces

import com.persAssistant.shopping_list.domain.enitities.ShoppingList

//abstract class ShoppingListInteractorInterface : ShoppingListRepositoryInterface()
abstract class ShoppingListInteractorInterface {
    abstract fun getChangeSingle()
    abstract fun insert(shoppingList: ShoppingList)
    abstract fun getAll()
    abstract fun getById(id: Long)
    abstract fun update(shoppingList: ShoppingList)
    abstract fun delete(shoppingList: ShoppingList)
}