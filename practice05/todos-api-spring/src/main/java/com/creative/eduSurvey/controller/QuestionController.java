package com.creative.eduSurvey.controller;

import com.creative.eduSurvey.dto.QuestionDto;
import com.creative.eduSurvey.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final String password = "01036965338";

    @GetMapping("/questions")
    public List<QuestionDto> GetQuestions(Boolean active) {
        List<QuestionDto> list = questionService.findAll();
        if(active != null) {
            return list.stream()
                    .filter((d)->active ? d.getIsActive() : !d.getIsActive())
                    .collect(Collectors.toList());
        }
        return list;
    }

    @PostMapping(value = "/questions", headers = "PASSWORD")
    public void postQuestions(@RequestBody QuestionDto dto, @RequestHeader("PASSWORD") String pw) {
        if(!pw.equals(password)) return;
        questionService.save(dto);
    }

    @PatchMapping(value = "/questions/{sn}", headers = "PASSWORD")
    public void patchQuestion(@PathVariable Long sn,
                              @RequestBody QuestionDto dto,
                              @RequestHeader("PASSWORD") String pw) {
        if(!pw.equals(password)) return;
        dto.setSn(sn);
        questionService.patch(dto);
    }

    @DeleteMapping(value = "/questions/{sn}", headers = "PASSWORD")
    public void deleteQuestion(@PathVariable Long sn, @RequestHeader("PASSWORD") String pw) {
        if(!pw.equals(password)) return;
        questionService.delete(sn);
    }
}
