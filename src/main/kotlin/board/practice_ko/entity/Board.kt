package board.practice_ko.entity

import javax.persistence.*

@Entity
class Board : BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    var id : Long? = null

    @Column(length = 500, nullable = false)
    var title: String? = null

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String? = null

    var author: String? = null

    constructor(title: String?, content: String?, author : String) : super() {
        this.title = title
        this.content = content
        this.author = author
    }

    fun update(title: String, content: String){
        this.title = title
        this.content = content
    }



}