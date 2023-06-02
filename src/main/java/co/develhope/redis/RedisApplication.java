package co.develhope.redis;

import co.develhope.redis.configurations.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
		//Config configurazione = new Config("redis-15639.c267.us-east-1-4.ec2.cloud.redislabs.com"
		//		, 15639, "npDlog6dLJqm56NCS9ifOewYy461TfBm", 0);
		//configurazione.getConnection();
	}

}
