package net.skillspire.review;

// POINT: the one class with main. @SpringBootApplication = "Spring, start up from here":
//        read the libraries in pom.xml, scan THIS package (and the packages under it) for
//        annotated classes, create them, then start Tomcat and wait for requests.
// ASK:   "A class in package net.skillspire.other has @RestController. Does Spring find it?"
//        (No: it's outside net.skillspire.review. Its URLs give a 404.)

// Same file in review-jdbc and review-jpa.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

}
