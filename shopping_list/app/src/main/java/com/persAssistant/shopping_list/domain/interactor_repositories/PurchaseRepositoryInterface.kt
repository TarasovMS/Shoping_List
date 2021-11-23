package com.persAssistant.shopping_list.domain.interactor_repositories

import androidx.lifecycle.LiveData
import com.persAssistant.shopping_list.data.database.dao.entity.RoomPurchase
import com.persAssistant.shopping_list.domain.entities.Purchase
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import java.util.*

abstract class PurchaseRepositoryInterface {
    abstract fun getChangeSingle(): LiveData<List<RoomPurchase>>
    abstract fun insert(purchase: Purchase): Completable
    abstract fun getAll(): Single<LinkedList<Purchase>>
    abstract fun getById(id: Long): Maybe<Purchase>
    abstract fun getAllByListId(id: Long): Single<LinkedList<Purchase>>
    abstract fun getAllByCategoryId(id: Long): Single<LinkedList<Purchase>>
    abstract fun update(purchase: Purchase): Completable
    abstract fun delete(purchase: Purchase): Completable
}