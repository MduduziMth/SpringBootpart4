package springbootpart3;



import com.soap.wsdl.*;
import jdk.internal.jline.internal.Urls;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;


@SpringBootApplication

public class MyApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup() throws MalformedURLException {
        URL url = new URL("http://localhost:9090/ws/countries.wsdl");
        CountriesPortService countriesPortService = new CountriesPortService(url);
        CountriesPort countriesPort = countriesPortService.getCountriesPortSoap11();
        GetCountryRequest request = new GetCountryRequest();
        request.setName("United Kingdom");

        GetCountryResponse response = countriesPort.getCountry(request);

        Currency currency = response.getCountry().getCurrency();
        String capital = response.getCountry().getCapital();
        int population =response.getCountry().getPopulation();

        System.out.println("Currency: " + currency);
        System.out.println("Capital: " + capital);
        System.out.println("Population: " + population);

        return null;

    }
}

