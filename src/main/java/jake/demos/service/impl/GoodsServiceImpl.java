package jake.demos.service.impl;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Goods;
import jake.demos.repository.GoodsMapper;
import jake.demos.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
