package jake.demos.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jake.demos.http.request.QuestionRequest;
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
    public BaseResponse<Topic> listTopicPaging(QuestionRequest request) {
        BaseResponse response = new BaseResponse();
        Page page = PageHelper.startPage(request.getPageIndex(), request.getPageSize());
        List<Topic> topicList = topicMapper.listTopic(request);
        response.setRecords(topicList);
        response.setTotalRecords((int) page.getTotal());
        return response;
    }
}
