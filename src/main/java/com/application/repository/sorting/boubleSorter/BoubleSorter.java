package com.application.repository.sorting.boubleSorter;

import com.application.contracts.Contracts;
import com.application.repository.sorting.iSorter;

import java.util.Comparator;

/**
 * the BubbleSorter class is required for bubble sorting in the "Repository"
 */
public class BoubleSorter implements iSorter {


    /**
     * This is a method for sorting the "Repository" collection by the conditions passed through the comparator
     * @param contracts array containing contracts
     * @param comparator this is a comparator for transmitting sorting conditions
     */
    @Override
    public void sort(Contracts[] contracts, Comparator<Contracts> comparator) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < contracts.length - 1; i++) {
                if (contracts[i] != null && contracts[i+1] != null && (comparator.compare(contracts[i], contracts[i + 1]) > 0)) {
                    Contracts temp = contracts[i];
                    contracts[i] = contracts[i+1];
                    contracts[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
