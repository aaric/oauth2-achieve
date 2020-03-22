package com.incarcloud.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * OAuth2服务端配置
 *
 * @author Aaric, created on 2020-03-13T11:43.
 * @version 0.2.0-SNAPSHOT
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // 0.2.0-SNAPSHOT
    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    // 0.5.0-SNAPSHOT
    /*@Autowired
    private RedisConnectionFactory connectionFactory;*/

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    // 0.2.1-SNAPSHOT
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 使用HikariCP数据库连接池
        return DataSourceBuilder.create().build();
    }

    // 0.2.1-SNAPSHOT
    /*@Bean
    public TokenStore tokenStore() {
        // 基于JDBC保存令牌数据
        return new JdbcTokenStore(dataSource());
    }*/

    // 0.5.0-SNAPSHOT
    /*@Bean
    public TokenStore tokenStore() {
        // 基于Redis保存令牌数据
        return new RedisTokenStore(connectionFactory);
    }*/

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();

        // 0.6.0-SNAPSHOT
        /*jwtAccessTokenConverter.setSigningKey("oauth2");*/

        // 0.7.0-SNAPSHOT
        // keytool -genkey -alias oauth2 -keyalg RSA -keysize 2048 \
        //   -dname "CN=OAuth2 Server,OU=OAuth2,O=jwt,L=Wuhan, ST=Hubei,C=CN" \
        //   -validity 3650 -keypass kp123345 -keystore oauth2.jks -storepass sp123456
        ClassPathResource resource = new ClassPathResource("oauth2.jks");
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, "sp123456".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("oauth2");
        jwtAccessTokenConverter.setKeyPair(keyPair);

        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public ClientDetailsService clientDetails() {
        // 基于JDBC保存客户端信息数据
        return new JdbcClientDetailsService(dataSource());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 保存令牌数据
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtTokenEnhancer())
                .reuseRefreshTokens(false);
        // http://localhost:8080/oauth/token?client_id=client&client_secret=secret&grant_type=password&scope=app&username=user&password=123456
        /*endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);*/
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 0.2.0-SNAPSHOT
        /*clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("https://www.incarcloud.com");*/

        // 0.4.0-SNAPSHOT
        /*clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("password")
                .scopes("app");*/

        // 0.2.1-SNAPSHOT
        // 读取客户端配置
        clients.withClientDetails(clientDetails());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }
}
