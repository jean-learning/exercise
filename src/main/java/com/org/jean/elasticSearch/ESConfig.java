package com.org.jean.elasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESConfig {
    @Bean
    public RestHighLevelClient buildClient(){
        return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")
//                new HttpHost("localhost", 9300, "http")
                ));
    }

}
