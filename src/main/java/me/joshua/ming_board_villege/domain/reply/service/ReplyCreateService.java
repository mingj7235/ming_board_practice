package me.joshua.ming_board_villege.domain.reply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.reply.dto.request.ReplyRequestDto;
import me.joshua.ming_board_villege.domain.reply.dto.response.ReplyResponseDto;
import me.joshua.ming_board_villege.domain.reply.entity.Reply;
import me.joshua.ming_board_villege.domain.reply.service.core.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyCreateService {

    private final ReplyService replyService;

    public ReplyResponseDto.Response createReply (final ReplyRequestDto.@NotNull Create request) {
        return ReplyResponseDto.Response.from(replyService.save(Reply.from(request)));
    }

}
