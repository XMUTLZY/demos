package jake.demos.service.impl;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Goods;
import jake.demos.repository.shop.GoodsMapper;
import jake.demos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public BaseResponse<Goods> listGoods() {
        BaseResponse response = new BaseResponse();
        List<Goods> goodsList = goodsMapper.listGoods();
        response.setRecords(goodsList);
        response.setTotalRecords(goodsList.size());
        return response;
    }

    @Override
    public BaseResponse<String> buyGoods(Integer goodsId, Integer userId) {
        int impactLine = goodsMapper.reduceGoodsNumber(goodsId);
        if (impactLine == 0) {
            return new BaseResponse<>("库存删减失败", HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new BaseResponse<>();
    }
}
