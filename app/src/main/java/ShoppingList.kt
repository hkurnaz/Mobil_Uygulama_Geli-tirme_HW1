class ShoppingList {
    val itemList = mutableListOf<Item>()

    fun addItem(item: Item) {
        itemList.add(item)
    }

    fun displayItems() {
        if (itemList.isEmpty()) {
            println("There is no item.")
        }
        else {
            itemList.forEach {
                println("Name: ${it.name}, Price: ${it.price}")
            }
        }
    }


    fun deleteItem(i: Int) {
        if (i in 0 until itemList.size) {
            val deletedItem = itemList.removeAt(i)
            println("${deletedItem.name} is deleted successfully!")
        }
    }
}
