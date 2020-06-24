package jake.demos.controller;

import jake.demos.http.vo.Goods;
import jake.demos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("")
    public ResponseEntity<Goods> listGoods() {
        return goodsService.listGoods().ok();
    }
}
