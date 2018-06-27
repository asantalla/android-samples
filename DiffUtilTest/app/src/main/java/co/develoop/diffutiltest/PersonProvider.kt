package co.develoop.diffutiltest

import java.util.*

class PersonProvider {



    companion object {
        fun getPersonList(): List<Person> {
            return listOf(
                    Person(1, 20, "James"),
                    Person(2, 15, "Kirk"),
                    Person(3, 31, "Robert"),
                    Person(4, 16, "Lars")
            )
        }

        fun sortByAge(persons: List<Person>): List<Person> {
            return persons.sortedBy { it.age }
        }

        fun unsort(persons: List<Person>): List<Person> {
            return when (Random().nextInt(2)) {
                0 -> persons.sortedBy { it.name }
                else -> persons.sortedBy { it.id }
            }
        }
    }
}

data class Person(
        val id: Int,
        var age: Int,
        val name: String
)