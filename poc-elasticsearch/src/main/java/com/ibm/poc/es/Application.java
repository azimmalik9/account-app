package com.ibm.poc.es;

import com.ibm.poc.es.model.Account;
import com.ibm.poc.es.model.Book;
import com.ibm.poc.es.service.AccountService;
import com.ibm.poc.es.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private BookService bookService;

    @Autowired
    private AccountService accountService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();
        postBook();

        List<Book> books = bookService.findByTitle("Satish");
        books.forEach(x -> log.info("Find by Title " + x));



    }

    private void postBook() {
        bookService.save(new Book("1001", "Elasticsearch Basics", "Satish Yeruva1", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Satish Yeruva2", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Satish Yeruva3", "21-MAR-2017"));
        bookService.save(new Book("1004", "Elasticsearch Basics", "Satish Yeruva4", "23-FEB-2017"));
        bookService.save(new Book("1005", "Satish Book1", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1006", "Satish Book2", "Satish Yeruva5", "23-FEB-2017"));
        bookService.save(new Book("1007", "Satish Book3", "Satish Yeruva5", "23-FEB-2017"));
        bookService.save(new Book("1008", "Satish Book4", "Satish Yeruva5", "23-FEB-2017"));
    }


    private void printElasticSearchInfo() {

        log.info("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            log.info(k + " = " + v);
        });
        log.info("<--ElasticSearch--");
    }
}
