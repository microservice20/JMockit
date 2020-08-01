/*
 * Copyright 2015 Sharmarke Aden.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.greeter.systemtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot Greeter Application.
 *
 * @author saden
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration(
        exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class GreeterApplication {

    public static void main(String[] args) throws Exception {
        GreeterApplication application = new GreeterApplication();

        application.run(args);
    }

    public void run(String[] args) {
        SpringApplication.run(GreeterApplication.class, args);
    }

}
