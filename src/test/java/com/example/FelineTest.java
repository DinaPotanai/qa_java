package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnActualFelineFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void eatMeatReturnFelineFood() throws Exception {
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult, "Тип еды не соответствует ожидаемой для семейства кошачьих");
    }

    @Test
    public void getFamilyReturnFelineFamily(){
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult, "Тип семейства не соответствует ожидаемому");
    }

    @Test
    public void getKittensReturnFelineKittens() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        assertEquals(expectedResult, actualResult, "Количество котят не соответствует ожидаемому");
    }
}