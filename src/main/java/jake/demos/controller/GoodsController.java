package jake.demos.controller;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Goods;
import jake.demos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public ResponseEntity<Goods> listGoods() {
        return goodsService.listGoods().ok();
    }

    /**
     * 用户订购商品
     */
    @GetMapping("/buy")
    public ResponseEntity<String> buyGoods(@RequestParam(value = "goods_id") Integer goodsId,
                                           @RequestParam(value = "user_id") Integer userId) {
        BaseResponse<String> response = goodsService.buyGoods(goodsId, userId);
        if (response.getHttpStatus() != HttpStatus.OK) {
            return response.failed();
        }
        return response.ok();
    }
}
