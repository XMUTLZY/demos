package jake.demos.service;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Goods;

/**
 * Created by Jake.lin on 2020/06/24
 */
public interface GoodsService {
    BaseResponse<Goods> listGoods();
    BaseResponse<String> buyGoods(Integer goodsId, Integer userId);
}
