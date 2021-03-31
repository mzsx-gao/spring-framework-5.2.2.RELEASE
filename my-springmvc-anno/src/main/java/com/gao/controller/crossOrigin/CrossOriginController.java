package com.gao.controller.crossOrigin;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称: CrossOriginController
 * 描述: 跨域问题示例
 *
 * @author gaoshudian
 * @date 2021/3/31 21:08
 */
@RestController
@RequestMapping("/crossOrigin")
public class CrossOriginController {

//    @CrossOrigin(origins = "*",allowedHeaders = "x-requested-with",allowCredentials = "true",maxAge = 3600,
//            methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.DELETE})
    @RequestMapping("/test")
    public Map queryArea(@RequestParam String name) {
        Map map = new HashMap<>();
        map.put("name",name);
        return map;
    }
}
