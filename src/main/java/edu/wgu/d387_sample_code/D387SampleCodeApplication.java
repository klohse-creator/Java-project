package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		Properties properties = new Properties();
		try {
			InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
			properties.load(stream);
			System.out.println(properties.getProperty("translation"));
		}
			catch (Exception e) {
			e.printStackTrace();
		}


		try {
			InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
			properties.load(stream);
			System.out.println(properties.getProperty("translation"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}




}
}
