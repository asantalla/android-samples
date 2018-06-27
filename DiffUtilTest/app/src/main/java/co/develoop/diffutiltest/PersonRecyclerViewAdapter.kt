package co.develoop.diffutiltest

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PersonRecyclerViewAdapter(
        private var people: List<Person>
) : RecyclerView.Adapter<PersonRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonRecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return PersonRecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int =
            people.size

    override fun onBindViewHolder(holder: PersonRecyclerViewHolder, position: Int) {
        holder.bind(people[position])
    }

    override fun onBindViewHolder(holder: PersonRecyclerViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            payloads.forEach {
                val bundle = it as Bundle
                if (bundle.containsKey("age")) {
                    holder.updateAge(bundle.getString("age"))
                }
            }
        } else {
            holder.bind(people[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.person_item
    }

    fun update(newPeople: List<Person>) {
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(PersonDiffCallback(people, newPeople))
        people = newPeople
        diffResult.dispatchUpdatesTo(this)
    }
}

class PersonRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(person: Person) {
        itemView.findViewById<TextView>(R.id.name).text = person.name
        itemView.findViewById<TextView>(R.id.age).text = person.age.toString()
        itemView.findViewById<TextView>(R.id.id).text = person.id.toString()
    }

    fun updateAge(newAge: String) {
        itemView.findViewById<TextView>(R.id.age).text = newAge
    }
}

class PersonDiffCallback(
        private val oldPeople: List<Person>,
        private val newPeople: List<Person>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =
            oldPeople.size

    override fun getNewListSize(): Int =
            newPeople.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldPeople[oldItemPosition].id == newPeople[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldPeople[oldItemPosition] == newPeople[newItemPosition]

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val bundle = Bundle()
        bundle.putString("age", newPeople[newItemPosition].age.toString())
        return bundle
    }
}