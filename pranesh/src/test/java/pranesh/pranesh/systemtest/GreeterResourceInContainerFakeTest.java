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
import com.fitbur.testify.Cut;
import com.fitbur.testify.Fake;
import com.acme.greeter.systemtest.resource.GreeterResource;
import com.acme.greeter.systemtest.service.Greeter;
import com.fitbur.testify.junit.system.SpringBootSystemTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

/**
 * Test Greeter Resource inside the container using a "fake" instance of
 Greeter Service. This ability comes in handy when testing service endpoints
 * that may cost money (i.e. Credit Card processing service).
 *
 * @author saden
 */
@App(GreeterApplication.class)
@RunWith(SpringBootSystemTest.class)
public class GreeterResourceInContainerFakeTest {

    @Cut
    GreeterResource cut;

    @Fake
    Greeter greeting;

    @Test
    public void givenHayeSaveShouldSavePhrase() {
        //Arrange
        String phrase = "Haye";

        //prevent call tot he real service. if we were testing a credit card
        //charge service this ability comes in handy!
        willThrow(RuntimeException.class).given(greeting).save(phrase);

        try {
            //Act
            cut.save(phrase);

        } catch (RuntimeException e) {

            //Assert
            verify(greeting).save(phrase);
        }
    }

}
