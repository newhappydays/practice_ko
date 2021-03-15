package board.practice_ko

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class PracticeKoApplication

fun main(args: Array<String>) {
	runApplication<PracticeKoApplication>(*args)
}
