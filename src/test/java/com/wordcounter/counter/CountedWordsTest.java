package com.wordcounter.counter;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountedWordsTest {

    @Test
    public void countWordsWithProvidedExample() {

        // given
        List<String> exampleWords = Arrays.asList("a", "mate", "material", "may", "maybe", "right", "maybe");
        CountedWords countedWords = new CountedWords();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("material", 1);
        expected.put("maybe", 2);
        expected.put("right", 1);

        // when
        exampleWords.forEach(countedWords::checkWordAgainstCountedWords);
        Map<String, Integer> result = countedWords.getCountedWords();

        // then
        assertThat(result, is(expected));
    }

    @Test
    public void countWordsWhereAllWordsAreDifferent() {
        // given
        List<String> exampleWords = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        CountedWords countedWords = new CountedWords();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 1);
        expected.put("c", 1);
        expected.put("d", 1);
        expected.put("e", 1);
        expected.put("f", 1);
        expected.put("g", 1);

        // when
        exampleWords.forEach(countedWords::checkWordAgainstCountedWords);
        Map<String, Integer> result = countedWords.getCountedWords();

        // then
        assertThat(result, is(expected));
    }

    @Test
    public void countWordsWhereAllWordsAreTheSame() {
        // given
        List<String> exampleWords = Arrays.asList("word", "word", "word", "word", "word", "word", "word", "word");
        CountedWords countedWords = new CountedWords();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("word", 8);

        // when
        exampleWords.forEach(countedWords::checkWordAgainstCountedWords);
        Map<String, Integer> result = countedWords.getCountedWords();

        // then
        assertThat(result, is(expected));
    }
}