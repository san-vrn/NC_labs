package com.application.csvReader;

import com.application.contracts.Contracts;
import com.application.repository.Repository;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;


class CSV_ReaderTest {

    @Test
    void read() throws IOException {
        Repository repo = new Repository();
        CSV_Reader readerCSV = new CSV_Reader();
        String fileName = "src/main/resources/ContractsCSV.csv";
        repo = readerCSV.read(repo, fileName);
        repo.displayAllContracts();
    }
}