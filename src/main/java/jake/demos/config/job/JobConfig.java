package jake.demos.config.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

/**
 * Created by Jake.lin on 2020/06/29
 */
@Configuration
public class JobConfig {
    private class MessagePrintTask implements Runnable {

        private String message;

        public MessagePrintTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "is running,message:" + message);
        }
    }

    private static TaskExecutor taskExecutor = new TaskExecutor() {
        @Override
        public void execute(Runnable runnable) {

        }
    };

    public void printMessages() {
        for (int i = 0; i<25; i++) {
            taskExecutor.execute(new MessagePrintTask(i + ""));
        }
    }

    public JobConfig(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

}
