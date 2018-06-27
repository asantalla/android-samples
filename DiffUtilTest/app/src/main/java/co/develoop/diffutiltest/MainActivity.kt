package co.develoop.diffutiltest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val people: List<Person> = PersonProvider.getPersonList()
    private val adapter: PersonRecyclerViewAdapter = PersonRecyclerViewAdapter(people)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personRecyclerView.adapter = adapter
        personRecyclerView.layoutManager = LinearLayoutManager(this)
        personRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        sortButton.setOnClickListener {
            adapter.update(PersonProvider.sortByAge(people))
        }

        unsortButton.setOnClickListener {
            adapter.update(PersonProvider.unsort(people))
        }

        multiplyBy2JamesAgeButton.setOnClickListener {
            val newPeople: MutableList<Person> = mutableListOf()

            people.forEach {
                newPeople.add(
                        Person(
                                id = it.id,
                                age = if (it.name == "James") it.age * 2 else it.age,
                                name = it.name
                        )
                )
            }
            adapter.update(newPeople)
        }
    }
}