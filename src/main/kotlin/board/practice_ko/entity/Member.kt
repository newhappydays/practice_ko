package board.practice_ko.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private val id: Long? = null
}
