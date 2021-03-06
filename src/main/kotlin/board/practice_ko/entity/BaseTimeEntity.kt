package board.practice_ko.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity{

    @CreatedDate
    var createdDate : LocalDateTime? = null

    @LastModifiedDate
    var modifiedDate: LocalDateTime? = null
}