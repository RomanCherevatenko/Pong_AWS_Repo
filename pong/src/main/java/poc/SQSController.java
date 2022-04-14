package poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;


@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class SQSController {
    public static void main(String[] args) {
        SpringApplication.run(SQSController.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSController.class);

    @SqsListener(value = "https://sqs.us-east-1.amazonaws.com/453888930431/Roman-Queue")
    public void loadMessageFromSQS(String message) {
        LOGGER.info("message from SQS Queue {}", message);
    }

}


