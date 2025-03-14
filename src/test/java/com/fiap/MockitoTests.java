package com.fiap;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    Calculator c1 = new CalcAPI();

    @Mock
    QueryAPI apiMock;

    @Test
    public void test01() throws Exception {
        when(apiMock.validateSoma(5,6)).thenReturn(51);
        ((CalcAPI) c1).setAPI(apiMock);
        int r = c1.soma(5, 6);
        assertEquals(51, r);
    }

}
