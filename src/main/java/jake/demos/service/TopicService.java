package jake.demos.service;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Topic;

/**
 * Created by Jake.lin on 2020/06/24
 */
public interface TopicService {
    BaseResponse<Topic> listTopic();
}
