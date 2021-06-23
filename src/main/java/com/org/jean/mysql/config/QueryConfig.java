package com.org.jean.mysql.config;

import com.org.jean.mysql.model.QueryProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
//@Component
//@ConfigurationProperties(prefix = "mysqldb")
//@PropertySource("classpath:query.properties")
@Configuration
public class QueryConfig {

    private String querybyid;
    @Value("${query.file}")
    private String fileName;

    @Bean
    public QueryProperties getQueryMap() {

        Class clazz = QueryConfig.class;
        InputStream inputStream = clazz.getResourceAsStream(fileName);

        QueryProperties queryProperties=new QueryProperties();
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//                list.add(line);
                queryProperties.setKey(line.substring(0,line.indexOf("=")));
                queryProperties.setQuery(line.substring((line.indexOf("=")+1)) );
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return queryProperties;

    }
}
