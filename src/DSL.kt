class Tank {
    val left = Direction.Left
    val right = Direction.Right
    val up=Direction.Up
    val down=Direction.Down

    val cannon=Weapon.Cannon
    val gun=Weapon.MachineGun

    val tenkmph="10 kmph"

    enum class Direction(val direction:String) {
        Left("Left"),
        Right("Right"),
        Up("Up"),
        Down("Down")
    }
    enum class Weapon(val weapon:String) {
        Cannon("Cannon"),
        MachineGun("Machine gun")
    }


    infix fun turns(direction: Direction) {
        println("turning $direction")
    }

    infix fun accelerate(acceleration:String) {
        println("accelerating at $acceleration")
    }

    infix fun decelerate(deceleration:String) {
        println("decelerating at $deceleration")
    }

    infix fun fire(weapon: Weapon) {
        println("firing at $weapon")
    }


}


 fun operate(block: Tank.(Tank) -> Unit) {
    val robot = Tank()
    robot.block(robot)
}



fun main(args: Array<String>) {
    operate {
    it turns left
    it accelerate tenkmph
    it turns right
    it fire cannon
}
}