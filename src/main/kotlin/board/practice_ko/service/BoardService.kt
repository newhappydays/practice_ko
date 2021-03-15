package board.practice_ko.service

import board.practice_ko.dto.BoardListResponseDto
import board.practice_ko.dto.BoardResponseDto
import board.practice_ko.dto.BoardSaveRequestDto
import board.practice_ko.dto.BoardUpdateRequestDto
import board.practice_ko.entity.Board
import board.practice_ko.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import java.util.*
import java.util.stream.Collectors
import kotlin.streams.toList

@Service
class BoardService{

    @Autowired
    private lateinit var boardRepository: BoardRepository

    @Transactional
    fun save(requestDto : BoardSaveRequestDto): Long? {
        return boardRepository.save(requestDto.toEntity()).id
    }

    @Transactional(readOnly = true)
    fun findAllDesc(): List<BoardListResponseDto> {
        var a : List<Board> = boardRepository.findAllDesc()
        for(i in 0 until a.size){
            print("뭐냐 ${a[i].id}")
        }
        print("몇개임?? ${a.size} 시발")

        return boardRepository.findAllDesc().stream()
                .map{ BoardListResponseDto(it) }
                .toList()
    }

    @Transactional
    fun findById(id : Long) : BoardResponseDto {
        val entity = boardRepository.findById(id)
                .orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$id") }
        return BoardResponseDto(entity)
    }

    @Transactional
    fun delete(id : Long){
        val entity = boardRepository.findById(id)
            .orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$id") }
        boardRepository.delete(entity)
    }

    @Transactional
    fun update(id : Long, requestDto: BoardUpdateRequestDto) : Long{
        val entity = boardRepository.findById(id)
                .orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$id") }

        entity.update(requestDto.title, requestDto.content)
        return id
    }

}