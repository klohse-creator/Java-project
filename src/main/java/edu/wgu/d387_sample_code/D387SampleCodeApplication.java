package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;


import java.io.InputStream;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;



@SpringBootApplication
public class D387SampleCodeApplication {

	public static String[] messages = new String[]{"", ""};

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		/*Properties properties = new Properties();
		ExecutorService messageExecutor = newFixedThreadPool(2);
		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
				properties.load(stream);
				messages[0] = properties.getProperty("welcome");
				System.out.println(messages[0]);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
				properties.load(stream);
				messages[1] = properties.getProperty("welcome");
				System.out.println(messages[1]);

			} catch (Exception e) {
				e.printStackTrace();
			}


		});

	} */
	}
}

