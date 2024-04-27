package com.rabiabayar.hw3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rabiabayar.hw3.ToDoAdapter
import com.rabiabayar.hw3.Item

class FirstPageFragment : Fragment() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var toDoAdapter: ToDoAdapter
    private val itemList: MutableList<Item> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first_page, container, false)

        titleEditText = view.findViewById(R.id.editTextText)
        descriptionEditText = view.findViewById(R.id.editTextText2)
        addButton = view.findViewById(R.id.button2)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        toDoAdapter = ToDoAdapter(itemList) { position ->
            // `itemList`'ten öğeyi silin
            itemList.removeAt(position)
            // `ToDoAdapter`'ı güncelleyin
            toDoAdapter.notifyItemRemoved(position)
        }

        recyclerView.adapter = toDoAdapter

        addButton.setOnClickListener {
            handleAddButtonClick()
        }

        return view
    }

    private fun handleAddButtonClick() {
        // Title ve Description değerlerini alın
        val title = titleEditText.text.toString().trim()
        val description = descriptionEditText.text.toString().trim()

        // Alanlar boşsa, uyarı mesajı gösterin
        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(requireContext(), "Fill all the blanks", Toast.LENGTH_SHORT).show()
            return
        }

        val newItem = Item(title, description)
        itemList.add(newItem)

        toDoAdapter.notifyDataSetChanged()

        titleEditText.text.clear()
        descriptionEditText.text.clear()
    }
}
