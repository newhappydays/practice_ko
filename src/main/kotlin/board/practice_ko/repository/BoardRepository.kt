package board.practice_ko.repository

import board.practice_ko.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> , BoardRepositoryCustom{}