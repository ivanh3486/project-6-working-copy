package com.example.aggregator.service;

import com.example.aggregator.client.AggregatorRestClient;
import com.example.aggregator.model.Entry;
import org.springframework.stereotype.Service;
import com.example.dictionary.service.DictionaryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregatorService {

    private AggregatorRestClient restClient;
    private DictionaryService dictionaryService;

    public AggregatorService(AggregatorRestClient restClient, DictionaryService dictionaryService ) {
        this.restClient = restClient;
        this.dictionaryService = dictionaryService;
    }

    public Entry getDefinitionFor(String word) {
        return restClient.getDefinitionFor(word);
    }

    public List<Entry> getWordsThatContainSuccessiveLettersAndStartsWith(String chars) {

        List<Entry> wordsThatStartWith = restClient.getWordsStartingWith(chars);
        List<Entry> wordsThatContainSuccessiveLetters = restClient.getWordsThatContainConsecutiveLetters();

        List<Entry> common = new ArrayList<>(wordsThatStartWith);
        common.retainAll(wordsThatContainSuccessiveLetters);

        return common;
    }

    public List<Entry> getWordsThatContainSuccessiveLettersAndContains(String chars) {

        List<Entry> wordsThatContain = restClient.getWordsThatContain(chars);
        List<Entry> wordsThatContainSuccessiveLetters = restClient.getWordsThatContainConsecutiveLetters();

        List<Entry> common = new ArrayList<>(wordsThatContain);
        common.retainAll(wordsThatContainSuccessiveLetters);

        return common;
    }
    public List<Entry> getAllPalindromes() {
        // Implement the logic to retrieve all palindromes from your data source
        // This could involve calling the Dictionary service or processing data locally
        // For demonstration purposes, let's assume there's a method called getAllPalindromes in DictionaryService
        // Replace this with the actual logic based on your requirements.

        List<Entry> palindromes = dictionaryService.getAllPalindromes();

        // Additional processing or filtering if needed

        return dictionaryService.getAllpalindromes;
    }
}



