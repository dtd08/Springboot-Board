package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    
    // 글 작성
    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "";
    }
    
    // 게시글 리스트
    @GetMapping("board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    // 상세 페이지
    @GetMapping("/board/view")  // localhost:8092/board/view?id=1
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    // 글 삭제
    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
}
