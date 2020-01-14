package io.sangco.web;

import io.sangco.web.domain.Board;
import io.sangco.web.domain.User;
import io.sangco.web.enums.BoardType;
import io.sangco.web.repository.BoardRepository;
import io.sangco.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("sangco")
                    .password("test")
                    .email("sangco@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글"+index)
                            .subTitle("순서"+index)
                            .content("컨텐츠")
                            .boardType(BoardType.FREE)
                            .createdDateTime(LocalDateTime.now())
                            .updatedDateTime(LocalDateTime.now())
                            .user(user).build())
            );
        };
    }
}
