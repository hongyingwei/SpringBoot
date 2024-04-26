package com.jsu.greet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
@EnableTransactionManagement
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Value("${server.port:8080}")
//    String port;
//
//    @Value("${server.servlet.context-path:/}")
//    String contextPath;
//
//    @Bean
//    CommandLineRunner commandLineRunner() {
////         return args -> {
////         };
////        return new CommandLineRunner() {
////            @Override
////            public void run(String... args) throws Exception {
////                browse("http://localhost:8088");
////            }
////        };
//
//        return args -> browse("http://localhost:" + port + contextPath);
//    }
//
//    private void browse(String url) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//         Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
//         Method openURL = fileMgr.getDeclaredMethod("openURL", String.class);
//         Object o = openURL.invoke(null, url);
//         System.out.println("opening " + url + " result: " + o);
//    }
}
