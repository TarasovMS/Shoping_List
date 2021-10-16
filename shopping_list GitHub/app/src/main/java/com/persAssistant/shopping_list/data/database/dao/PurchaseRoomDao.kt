package com.persAssistant.shopping_list.data.database.dao

import androidx.room.*
import com.persAssistant.shopping_list.data.database.DbStruct
import com.persAssistant.shopping_list.data.database.dao.enitity.RoomPurchase
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface PurchaseRoomDao {

    // добавления записи в таблицу
    @Insert
    fun insert(roomPurchase: RoomPurchase): Long

    //запрос всех категорий
    @Query("SELECT * FROM ${DbStruct.Purchase.tableName}")
    fun getAll(): Single<List<RoomPurchase>>

    //запрос одного списка по айди
    @Query("SELECT * FROM ${DbStruct.Purchase.tableName} WHERE ${DbStruct.Purchase.Cols.id} = :id")
    fun getById(id: Long): Maybe<RoomPurchase>

    //запрос списка по List id
    @Query("SELECT * FROM ${DbStruct.Purchase.tableName} WHERE ${DbStruct.Purchase.Cols.listId} = :id")
    fun getAllByListId(id: Long): Single<List<RoomPurchase>>

    //обновление категории
    @Update
    fun update(roomPurchase: RoomPurchase): Int

    //удаление категории
    @Delete
    fun delete(roomPurchase: RoomPurchase): Int

}
