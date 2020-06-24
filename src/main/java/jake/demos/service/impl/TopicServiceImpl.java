package jake.demos.service.impl;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Topic;
import jake.demos.repository.forum.TopicMapper;
import jake.demos.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public BaseResponse<Topic> listTopic() {
        BaseResponse response = new BaseResponse();
        List<Topic> topicList = topicMapper.listTopic();
        response.setRecords(topicList);
        response.setTotalRecords(topicList.size());
        return response;
    }
}
