package jake.demos.repository;

import jake.demos.http.vo.Goods;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Repository
public interface GoodsMapper {
    List<Goods> listGoods();
}
