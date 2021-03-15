package board.practice_ko.controller

import board.practice_ko.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class BoardForm {

    @Autowired
    private lateinit var boardService : BoardService

    @GetMapping("/")
    fun home(model : Model) : String{
        model.addAttribute("board", boardService.findAllDesc())
        return "main";
    }

    @GetMapping("/board/boardSave")
    fun boardSave() : String {
        return "board/boardSave"
    }

    @GetMapping("/board/boardDetail/{id}")
    fun boardDetail(@PathVariable id : Long, model : Model) : String {
        var responseDto = boardService.findById(id)
        model.addAttribute("board", responseDto)
        return "board/boardDetail"
    }

    @GetMapping("/board/boardUpdate/{id}")
    fun boardUpdate(@PathVariable id : Long, model: Model) : String {
        var responseDto = boardService.findById(id)
        model.addAttribute("board", responseDto)
        return "board/boardUpdate"
    }


}