import java.util.*

class Main {
    private val itemList = mutableListOf<Item>()

    fun start() {
        println("***** Welcome to Shopping List App *****")

        val scanner = Scanner(System.`in`)
        var userInput: Int

        do {
            displayMenu()
            userInput = scanner.nextInt()

            when (userInput) {
                1 -> addItem()
                2 -> displayItems()
                3 -> deleteItem()
                4 -> println("Exiting the Shopping List App. Goodbye!")
                else -> println("Invalid option. Please enter a valid option.")
            }
        } while (userInput != 4)
    }

    private fun displayMenu() {
        println("\nMake your choice : (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Items")
        println("3. Delete Item")
        println("4. Exit")
        print("Your choice is : ")
    }

    private fun addItem() {
        println("\nSelect item type you want to add:")
        println("1. Food")
        println("2. Cloth")
        print("Your choice is: ")

        val scanner = Scanner(System.`in`)
        val itemType = scanner.nextInt()

        when (itemType) {
            1 -> {
                println("\nEnter your food features:")
                print("Name: ")
                val name = readLine() ?: ""
                var price: Double
                while (true) {
                    print("Price: ")
                    val priceInput = readLine()
                    price = try {
                        priceInput!!.toDouble()
                    } catch (e: NumberFormatException) {
                        println("Please enter valid price!")
                        continue
                    }
                    break
                }
                print("Weight: ")
                val weight = readLine() ?: ""

                val food = Food.Food(name, price, weight)
                itemList.add(food)
                println("$name added successfully!")
            }
            2 -> {
                println("\nEnter you cloth features:")
                print("Name: ")
                val name = readLine() ?: ""
                var price: Double
                while (true) {
                    print("Price: ")
                    val priceInput = readLine()
                    price = try {
                        priceInput!!.toDouble()
                    } catch (e: NumberFormatException) {
                        println("Invalid input. Please enter a valid price.")
                        continue
                    }
                    break
                }
                print("Type: ")
                val type = readLine() ?: ""

                val cloth = Cloth.Cloth(name, price, type)
                itemList.add(cloth)
                println("$name added successfully!")
            }
            else -> println("Invalid number. Enter the item type you want to add (1 for Food, 2 for Cloth): ")
        }
    }



    private fun displayItems() {
        if (itemList.isEmpty()) {
            println("\nShopping list is empty.")
        } else {
            println("\nItems in the shopping list:")
            itemList.forEachIndexed { index, item ->
                println("${index + 1}. ${item.name} ${item.price}$")
                if (item is Food.Food) {
                    println("   Weight: ${item.weight}kg")
                } else if (item is Cloth.Cloth) {
                    println("   Type: ${item.type}")
                }
            }
        }
    }

    private fun deleteItem() {
        if (itemList.isEmpty()) {
            println("\nThere are no items already.")
            return
        }

        println("\nEnter the item number you want to delete: ")
        val scanner = Scanner(System.`in`)
        val index = scanner.nextInt()

        if (index in 1..itemList.size) {
            val deletedItem = itemList.removeAt(index - 1)
            println("${deletedItem.name} is deleted successfully!")
        } else {
            println("Invalid number. Please enter a valid number.")
        }
    }
}

fun main() {
    val main = Main()
    main.start()
}
