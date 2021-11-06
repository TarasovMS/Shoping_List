package com.persAssistant.shopping_list.presentation.purchase

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.persAssistant.shopping_list.R
import com.persAssistant.shopping_list.data.database.enitities.Category
import com.persAssistant.shopping_list.presentation.App
import com.persAssistant.shopping_list.presentation.list_of_category_fragment.OnCategoryClickListener
import com.persAssistant.shopping_list.presentation.list_of_category_fragment.adapter.CategoryAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class SelectionOfCategoryInTheDialog {

    interface DialogButtonsClickedListener{
        fun okClickListener(category: Category)
    }

    companion object{

        fun show(activity: Activity, showDialog: DialogButtonsClickedListener){
            val builder = AlertDialog.Builder(activity)
            val inflater: LayoutInflater = activity.layoutInflater
            val dialogView: View = inflater.inflate(R.layout.custom_dialog, null)

            builder.setView(dialogView)
            builder.create()
            val mAlertDialog = builder.show()

            val recyclerView: RecyclerView = dialogView.findViewById(R.id.recyclerView_category_custom_dialog)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.itemAnimator = DefaultItemAnimator()
            val categoryAdapter = CategoryAdapter(LinkedList(), object : OnCategoryClickListener {

                override fun clickedCategoryItem(category: Category) {
                    showDialog.okClickListener(category)
                    mAlertDialog.dismiss()
                }
                override fun deleteItem(category: Category) {}
                override fun editItem(category: Category) {}
            })
            initAdapter(categoryAdapter)
            recyclerView.adapter = categoryAdapter
        }

        private fun initAdapter(categoryAdapter: CategoryAdapter) {
            val app = App()
            app.categoryService.getAll()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({/*Есть данные*/
                    categoryAdapter.updateItems(it)
                }, {/*Ошибка*/ })
        }
    }
}