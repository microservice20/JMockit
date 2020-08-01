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

import com.fitbur.testify.App;
import com.fitbur.testify.Module;
import com.fitbur.testify.Real;
import com.fitbur.testify.client.ClientInstance;
import com.acme.greeter.fixture.PostgresTestConfig;
import com.fitbur.testify.junit.system.SpringBootSystemTest;
import com.fitbur.testify.need.NeedContainer;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.CREATED;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test Greeter Resource inside the container from the client perspective real
 * instance of the Greeting Service and Postgres database running inside of
 * Docker container. This ability comes in handy when you want to test against
 * real production environment.
 *
 * @author saden
 */
@App(GreeterApplication.class)
@Module(PostgresTestConfig.class)
@NeedContainer(value = "postgres", version = "9.4")
@RunWith(SpringBootSystemTest.class)
public class GreeterResourceClientInstanceNeedContainerTest {

    @Real
    ClientInstance<WebTarget> cut;

    @Test
    public void givenHelloGetShouldReturnHello() {
        //Arrange
        String phrase = "Hello";

        //Act
        Response result = cut.getTarget()
                .path("/")
                .request()
                .post(Entity.text(phrase));

        //Assert
        assertThat(result).isNotNull();
        assertThat(result.getStatus()).isEqualTo(CREATED.getStatusCode());
        assertThat(result.hasEntity()).isFalse();
    }

}
