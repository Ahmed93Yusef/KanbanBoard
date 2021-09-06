package com.watermelon.kanbanboard.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.kanbanboard.databinding.FragmentTodoBinding
import com.watermelon.kanbanboard.ui.add.AddFragment
import com.watermelon.kanbanboard.ui.base.BaseFragment
import com.watermelon.kanbanboard.ui.interfaces.CustomDialogFragment

class TodoFragment(private val listener: CustomDialogFragment) : BaseFragment<FragmentTodoBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTodoBinding
        get() = FragmentTodoBinding::inflate

    override fun setup() {}

    override fun callBack() {
//        val adapter = ItemAdapter(DataManager.Data)
//        binding.todoRecyclerview.adapter = adapter
        binding.addButton.setOnClickListener { listener.showDialog(AddFragment(listener)) }
    }
}