//package com.wherewego.config;
//
//import java.sql.SQLException;
//import org.h2.tools.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class H2ServerConfig {
//
//  @Bean(initMethod = "start", destroyMethod = "stop")
//  public Server H2DatabaseServer() throws SQLException {
//    // 클라이언트에서 jdbc:h2:tcp://localhost:9091/mem:wherewego 경로로 접속 가능
//    return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
//  }
//}