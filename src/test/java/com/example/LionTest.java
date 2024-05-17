package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittenCount = lion.getKittens();
        int expectedKittenCount = 1;
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        String predator = "Хищник";
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(predator)).thenReturn(expectedFood);
        List<String> resultFood = lion.getFood();
        Assert.assertEquals(expectedFood, resultFood);
    }

    @Test
    public void shouldThrowExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Кот", null);
        });
        Assert.assertEquals(EXPECTED_ERROR, exception.getMessage());
    }
}
