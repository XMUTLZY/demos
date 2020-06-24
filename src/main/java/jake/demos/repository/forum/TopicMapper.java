package jake.demos.repository.forum;

import jake.demos.http.vo.Topic;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Repository
public interface TopicMapper {
    List<Topic> listTopic();
}
