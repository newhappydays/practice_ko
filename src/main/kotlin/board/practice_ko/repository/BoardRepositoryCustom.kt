package board.practice_ko.repository

import board.practice_ko.entity.Board

interface BoardRepositoryCustom {

    fun findAllDesc() : List<Board>
}