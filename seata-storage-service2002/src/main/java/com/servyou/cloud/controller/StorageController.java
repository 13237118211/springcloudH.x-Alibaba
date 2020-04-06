package com.servyou.cloud.controller;

import com.servyou.cloud.domain.CommonResult;
import com.servyou.cloud.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"减少库存成功");
    }
}
