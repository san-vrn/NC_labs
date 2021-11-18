package com.application.repository.Sorting;

import com.application.contracts.Contracts;
import java.util.Comparator;

/**
 * the SelectionSorter class is required for selection sorting in the "Repository"
 */
public class SelectionSorter implements iSorter {

    /**
     * This is a method for sorting the "Repository" collection by the conditions passed through the comparator
     * @param contracts array containing contracts
     * @param comparator this is a comparator for transmitting sorting conditions
     */
    @Override
    public void sort(Contracts[] contracts, Comparator<Contracts> comparator) {
        for (int i = 0; i < contracts.length - 1; i++) {
            int minIndex = i;
            Contracts min = contracts[i];
            for (int j = i + 1; j < contracts.length; j++) {
                if (contracts[j]!= null && comparator.compare(contracts[j], min) < 0) {
                    minIndex = j;
                    min = contracts[j];
                }
            }
            contracts[minIndex] = contracts[i];
            contracts[i] = min;
        }
    }
}
