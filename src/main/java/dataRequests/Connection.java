package dataRequests;

import org.springframework.beans.factory.annotation.Value;

public class Connection {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    public Connection(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

}
