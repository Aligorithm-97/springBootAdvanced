package com.example.springadvanced.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterController {
    private final CounterService myCounterService;

    @DeltaTime
    @GetMapping("/increase")
    public String increaseCounter()
    {
        long cLoc = myCounterService.increase("osman");
        return "OK-" + cLoc;
    }

}
