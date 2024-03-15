package com.techfood.controller;

import com.techfood.entity.Extra;
import com.techfood.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/extra")
public class ExtraController {

    private final ExtraService extraService;

    @Autowired
    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping
    public List<Extra> getAllExtras() {
        return extraService.findAll();
    }

    @GetMapping("/{id}")
    public Extra getExtraById(@PathVariable long id) {
        return extraService.findById(id);
    }

    @PostMapping
    public Extra createExtra(@RequestBody Extra extra) {
        return extraService.save(extra);
    }

    @PutMapping("/{id}")
    public Extra updateExtra(@RequestBody Extra extra, @PathVariable long id) {
        Extra foundExtra = extraService.findById(id);
        foundExtra.setId(id);
        foundExtra.setName(extra.getName());
        foundExtra.setPrice(extra.getPrice());
        return extraService.save(foundExtra);
    }

    @DeleteMapping("/{id}")
    public Extra deleteExtra(@PathVariable long id) {
        Extra foundExtra = extraService.findById(id);
        return extraService.delete(foundExtra);
    }
}
