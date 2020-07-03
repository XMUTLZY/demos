package jake.demos.controller;

import jake.demos.http.request.QuestionRequest;
import jake.demos.http.vo.Topic;
import jake.demos.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService forumService;

    /**
     * 分页查询帖子
     */
    @PostMapping
    public ResponseEntity<Topic> listTopicPaging(@RequestBody QuestionRequest request) {
        return forumService.listTopicPaging(request).ok();
    }

}
