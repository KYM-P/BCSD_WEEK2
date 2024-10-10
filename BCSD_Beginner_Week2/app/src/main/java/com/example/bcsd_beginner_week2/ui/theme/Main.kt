package com.example.bcsd_beginner_week2.ui.theme

fun main () { // PQ용 변경 사항
    // 과제 1
    var list1 = listOf(1, 2, 3)
    var list2 = listOf(2, 3, 4)
    var list3 = (list1 + list2).distinct();

    println(list3) //It might be [1, 2, 3, 4]

    // 과제 2
    println(list3.sequenceN())

    // 과제 3
    var Beginner1 = BCSDLab_Beginner("a", 0)
    var Regular1 = BCSDLab_Regular("b", false)
    var Mentor1 = BCSDLab_Mentor("c", "~@~")
    Beginner1.plusCount()
    println("Beginner1 emoji: ${Beginner1.emoji}, Count: ${Beginner1.getCount()}")
    println("Regular1 emoji: ${Regular1.emoji}, paid: ${Regular1.paidInThisMonth}")
    println("Mentor1 emoji: ${Mentor1.emoji}, email: ${Mentor1.email}")

    // 과제4
    var BCSDMemberList: MutableList<BCSDLabUser> = mutableListOf()
    BCSDMemberList.add(BCSDLab_Beginner("양준모", 0))
    BCSDMemberList.add(BCSDLab_Beginner("이재민", 5))
    BCSDMemberList.add(BCSDLab_Regular("홍연아", false))
    BCSDMemberList.add(BCSDLab_Regular("이수정", true))
    BCSDMemberList.add(BCSDLab_Mentor("양유연", "~@~"))
    BCSDMemberList.add(BCSDLab_Mentor("박진영", "~@~"))
    var BeginnerList: MutableList<BCSDLab_Beginner> = mutableListOf()
    var failBeginnerList: MutableList<BCSDLab_Beginner> = mutableListOf()
    var noPaidRegularList: MutableList<BCSDLab_Regular> = mutableListOf()
    var startNameIsYangList: MutableList<BCSDLabUser> = mutableListOf()
    BCSDMemberList.filterIsInstance<BCSDLab_Beginner>().forEach {
        BeginnerList.add(it)
        if(it.getCount() >= 3)failBeginnerList.add(it)
    }
    BCSDMemberList.filterIsInstance<BCSDLab_Regular>().filterNot{ it.paidInThisMonth }.forEach { noPaidRegularList.add(it) }
    BCSDMemberList.filter { it.name.startsWith("양") }.forEach { startNameIsYangList.add(it) }
    println("BeginnerList : ${BeginnerList}")
    println("failBeginnerList : ${failBeginnerList}")
    println("noPaidRegularList : ${noPaidRegularList}")
    println("startNameIsYangList : ${startNameIsYangList}")
}
// 과제 2
fun List<Int>.sequenceN(n: Int = 2): List<Int>{
    val list = mutableListOf<Int>()
    for(item in 0 until this.size step(n)){
        list.add(this[item])
    }
    return list
}

// 과제 3
/*
class BCSDLab_Beginner (var name: String,private var assignmentFailCount:Int = 0 ) {
    val emoji: String = ":새싹:"
    fun getCount(): Int {return this.assignmentFailCount}
    fun setCount(value: Int) { if(value >= 0) this.assignmentFailCount = value }
    fun plusCount() { ++this.assignmentFailCount }
}
class BCSDLab_Regular (var name: String, var paidInThisMonth: Boolean = false ) {
    val emoji: String = ":녹색_사과:"
}
class BCSDLab_Mentor (var name: String = "", var email: String = "" ) {
    val emoji: String = ":반짝임:"
}
 */
// 과제4
abstract class BCSDLabUser {
    abstract val emoji: String
    abstract var name: String
}
data class BCSDLab_Beginner(override var name: String,private var assignmentFailCount:Int = 0 ): BCSDLabUser() {
    override val emoji: String = ":새싹:"
    fun getCount(): Int {return this.assignmentFailCount}
    fun setCount(value: Int) { if(value >= 0) this.assignmentFailCount = value }
    fun plusCount() { ++this.assignmentFailCount }
}
data class BCSDLab_Regular (override var name: String, var paidInThisMonth: Boolean = false ): BCSDLabUser() {
    override val emoji: String = ":녹색_사과:"
}
data class BCSDLab_Mentor (override var name: String = "", var email: String = "" ) : BCSDLabUser() {
    override val emoji: String = ":반짝임:"
}
