package pl.bykowski.prework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class PreworkApplication {

  public static void main(String[] args) {
    SpringApplication.run(PreworkApplication.class, args);
  }

  @Bean("messageSource")
  public ReloadableResourceBundleMessageSource getMessageSource() {
    ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
    bundleMessageSource.setBasename("classpath:i18n/messages");
    bundleMessageSource.setDefaultEncoding("UTF-8");
    return bundleMessageSource;
  }

}
