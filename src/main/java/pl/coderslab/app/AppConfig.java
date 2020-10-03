package pl.coderslab.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig {
}
