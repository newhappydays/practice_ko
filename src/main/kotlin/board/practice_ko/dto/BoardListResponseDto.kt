package board.practice_ko.dto

import board.practice_ko.entity.Board
import java.time.LocalDateTime

class BoardListResponseDto(val board: Board){
    var id = board.id
    var title = board.title
    var content = board.content
    var author = board.author
    var modifiedDate = board.modifiedDate
}