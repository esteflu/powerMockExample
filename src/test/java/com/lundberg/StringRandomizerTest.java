package com.lundberg;

import com.lundberg.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringRandomizer.class)
public class StringRandomizerTest {

    private static final String MOCKED_STRING = "mockedString";

    @Test
    public void test_string_randomizer() throws Exception {
        // Given
        StringRandomizer stringRandomizer = spy(new StringRandomizer());

        // When
        doReturn(MOCKED_STRING).when(stringRandomizer, "getRandomUUID");
        stringRandomizer.execute();

        // Then
        assertEquals(MOCKED_STRING, stringRandomizer.getUuid());
        verifyPrivate(stringRandomizer).invoke("getRandomUUID");
    }
}
