package type_bounds


//it is also called self referential types or recursive types
interface Entity<T : Entity<T>> {
    fun create(item: T): T
    fun delete(id: String): Unit
    fun update(item: T): T
    fun read(id: String): T
}

//class Product extends Entity[Order] should not be allowed ,only Product extends Entity[Product] should be allowed
//also class Order extends Entity[Product] should not be allowed,therefore we have introduced self type
class Product(var name: String) : Entity<Product> {
    override fun create(item: Product): Product {
       val product=Product("T shirt")
        println("product with ${product.name} created")
       return product
    }

    override fun delete(id: String): Unit {
        println("product with $id deleted")
    }

    override fun update(item: Product): Product {
        println("product with ${item.name} updated")
        return item
    }

    override fun read(id: String): Product {
        val product=Product("T shirt")
        println("product with ${product.name} read")
        return product
    }
}

class Order(var id: String) : Entity<Order> {
    override fun create(item: Order): Order {
        val order=Order("12345")
        println("order with ${order.id} created")
        return order
    }

    override fun delete(id: String): Unit{
        println("order with ${id} deleted")
    }

    override fun update(item: Order): Order{
        val order=Order("12345")
        println("order with ${order.id} updated")
        return order
    }

    override fun read(id: String): Order {
        val order=Order("12345")
        println("order with ${order.id} read")
        return order
    }
}

