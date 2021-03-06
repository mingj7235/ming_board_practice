package me.joshua.ming_board_villege.domain.board.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.global.common.base.BaseTime;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Board extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MBTI mbti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    public static Board create(final BoardRequestDto.@NotNull Create request) {
        return Board.builder()
                .subject(request.getSubject())
                .content(request.getContent())
                .createdTime(request.getCreatedDate())
                .build();
    }

    //FIXME : update logic (this logic should be checked before deploy)
    public static Board update(final @NotNull Board board,
                               final BoardRequestDto.@NotNull Update request) {
        board.setSubject(request.getSubject());
        board.setContent(request.getContent());
        return board;
    }

}
