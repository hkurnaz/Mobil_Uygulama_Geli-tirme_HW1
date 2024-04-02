class Food {
    class Food(name: String, price: Double, val weight: String) : Item(name, price) {
        // Food sınıfı, Item sınıfından türetilmiş alt sınıf
        // Food sınıfına özel ek özellikler (weight) burada tanımlanır
    }

}