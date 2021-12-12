package com.application.repository.sorting;

import com.application.contracts.Contracts;

import java.util.Comparator;


public interface iSorter {
    void sort(Contracts[] contracts, Comparator<Contracts> comparator);
}