package jake.demos.controller;

import jake.demos.config.DB.DataForumConfig;
import jake.demos.http.vo.Topic;
import jake.demos.service.TopicService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    @Autowired
    private TopicService forumService;
    @Autowired
    private DataForumConfig dataForumConfig;

    /**
     * 查询所有帖子
     */
    @GetMapping("")
    public ResponseEntity<Topic> listTopic() {
        logger.warning(String.format("%s", dataForumConfig.getUrl()));
        return forumService.listTopic().ok();
    }
}
