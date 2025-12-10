package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnLionKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        int expectedResult = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult, "Количество детенышей не соответствует ожидаемому");
    }

    @Test
    public void getFoodReturnLionFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult, "Тип еды не соответствует ожидаемой для львов");
    }

    @Test
    public void constructorIncorrectSex() {
        assertThrows(Exception.class, () -> new Lion("Женщина", feline));
    }

}