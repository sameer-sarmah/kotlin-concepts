interface Speciality
 class Medicine() : Speciality{
     override fun toString(): String = "Medicine"
}
 class ComputerScience() : Speciality{
     override fun toString(): String = "ComputerScience"
}

interface Job<T : Speciality>{
  fun work(skill:T)
}
 class Doctor() : Job<Medicine>{
  override fun work(skill: Medicine): Unit {
    println("Speciality is ${skill} and they heal people")
  }
}
 class SoftwareEngineer() : Job<ComputerScience>{
  override fun work(skill: ComputerScience): Unit  {
    println("Speciality is ${skill} and they build software")
  }
}

fun main(args: Array<String>) {
    val med=Medicine()
    val doctor = Doctor()
    doctor.work(med)
    val cs=ComputerScience()
    val eng=SoftwareEngineer()
    eng.work(cs)
}