package mk.ukim.finki.wp.labwp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LabWp2Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWp2Application.class, args);
    }

}
