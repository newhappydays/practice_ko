package board.practice_ko.repository

import board.practice_ko.entity.Board
import board.practice_ko.entity.QBoard.board
import com.querydsl.core.QueryFactory
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class BoardRepositoryImpl : BoardRepositoryCustom{

    @Autowired
    lateinit var em: EntityManager

    lateinit var queryFactory: JPAQueryFactory

    override fun findAllDesc(): List<Board> {
        queryFactory = JPAQueryFactory(em)

        return queryFactory
                .selectFrom(board)
                .orderBy(board.id.desc())
                .fetch()
    }

}