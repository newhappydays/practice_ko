package board.practice_ko.dto

import board.practice_ko.entity.Board

class BoardSaveRequestDto(
        var title: String,
        var content: String,
        var author : String) {

    fun toEntity() : Board{
        return Board(title, content, author)
    }
}