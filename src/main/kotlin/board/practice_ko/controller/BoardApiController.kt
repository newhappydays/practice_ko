package board.practice_ko.controller

import board.practice_ko.dto.BoardListResponseDto
import board.practice_ko.dto.BoardSaveRequestDto
import board.practice_ko.dto.BoardUpdateRequestDto
import board.practice_ko.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/board")
class BoardApiController(private var boardService : BoardService) {

    @PostMapping
    fun save(@RequestBody requestDto: BoardSaveRequestDto) : Long? {
        return boardService.save(requestDto)
    }

    @GetMapping
    fun findAllDesc() : List<BoardListResponseDto>{
        return boardService.findAllDesc()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : Long{
        boardService.delete(id)
        return id
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id : Long, @RequestBody requestDto: BoardUpdateRequestDto) : Long {
        return boardService.update(id, requestDto)
    }

}