package com.lundberg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
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
        StringRandomizer stringRandomizer = PowerMockito.spy(new StringRandomizer());

        // When
        when(stringRandomizer, method(StringRandomizer.class, "getRandomUUID"))
                .withNoArguments()
                .thenReturn(MOCKED_STRING);
        stringRandomizer.execute();

        // Then
        assertEquals(MOCKED_STRING, stringRandomizer.getUuid());
        verifyPrivate(stringRandomizer).invoke("getRandomUUID");
    }
}
