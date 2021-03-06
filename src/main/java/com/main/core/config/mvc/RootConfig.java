package com.main.core.config.mvc;
import com.main.core.config.data.mybatis.MyBatisConfig;
import com.main.core.config.signal.websocket.WebSocketConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by superMan791 on 2017/5/6.
 */
@Configuration
@ComponentScan("com")
@Import(value={
        WebConfig.class,
        MyBatisConfig.class,
        WebSocketConfig.class


})
public class RootConfig {
}
