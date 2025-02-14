package com.librarymanagement.tag.ui;

import com.librarymanagement.tag.application.TagService;
import com.librarymanagement.tag.ui.dto.response.GetTagHttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Operation(summary = "태그 전체 조회")
    @GetMapping("/v1/tags")
    public ResponseEntity<List<GetTagHttpResponse>> getTagList() {
        return ResponseEntity.ok().body(tagService.getTagList());
    }
}
