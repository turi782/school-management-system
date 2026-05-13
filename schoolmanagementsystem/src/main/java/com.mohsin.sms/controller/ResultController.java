package com.mohsin.sms.controller;


import com.mohsin.sms.dto.ResultDTO;
import com.mohsin.sms.entity.Result;
import com.mohsin.sms.service.ResultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @PostMapping
    public Result addResult(@RequestBody ResultDTO dto) {
        return service.addResult(dto);
    }
}
