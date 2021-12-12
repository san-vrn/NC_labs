package com.application.repository;

import com.application.contracts.Contracts;
import com.application.d_injector.Autoinjectable;
import com.application.d_injector.Injector;
import com.application.repository.sorting.iSorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * This class is intended for storing Contracts
 */
public class Repository {

    private Contracts[] contracts;
    private int size;

    //private iSorter sorter = new BoubleSorter();
    @Autoinjectable
    private iSorter sorter;


    public Repository() {
        this.contracts = new Contracts[10];
        this.size = 0;
        Injector inj = new Injector(this);
    }

    /**
     * This is a method for adding a contract to an array
     * @param contract stores a Contract type object
     */
    public void add(Contracts contract){
        if (size == contracts.length-1){
            increaseMassive();
        }
        contracts[size++] = contract;
    }

    /**
     * This method removes the contract from the array by id
     * @param id value for transmitting the contract id
     */
    public void remove(int id){
        int index = getIndexElement(id);
        if (index == -1) return;
        System.arraycopy(contracts, index + 1, contracts, index, size - index);
        size--;
        if((contracts.length - size) > 11){
            decreaseMassive();
        }
    }

    /**
     * This is a method for getting a Contract type object by id
     * @param id value for transmitting the contract id
     * @return an object of type Optional containing a Сontract
     */
    public Optional<Contracts> getContract(int id) {
        for (int i = 0; i < size; i++) {
            if (contracts[i].getID() == id) return Optional.of(contracts[i]);
        }
        return Optional.empty();
    }

    /**
     *This is a method for increasing array cells
     */
    private void increaseMassive(){
        Contracts[] tempArray = new Contracts[contracts.length + 10];
        System.arraycopy(contracts, 0, tempArray, 0, contracts.length);
        contracts = tempArray;
    }

    /**
     *this is a method for decreasing array cells
     */
    private void decreaseMassive(){
        Contracts[] tempArray = new Contracts[contracts.length - 10];
        System.arraycopy(contracts, 0, tempArray, 0, contracts.length - 10);
        contracts = tempArray;
    }

    /**
     *This is a method for getting the cell number that contains a contract with a given id
     * @param id the value of the desired contract
     * @return cell number in the array
     */
    private int getIndexElement(int id){
        for (int i = 0; i < size; i++) {
            if (contracts[i].getID() == id) return i;
        }
        return -1;
    }

    /**
     * This method searches the Repository collection with the specified conditions using the predicate
     * @param filterPredicate search conditions passed to the method via a predicate
     * @return returns a "Repository" collection with contracts satisfying the predicate conditions
     */
    public Repository search(Predicate<Contracts> filterPredicate){
        Repository repoTemp = new Repository();
        for(Contracts tempContract:contracts){
            if(tempContract!= null && filterPredicate.test(tempContract)){
                repoTemp.add(tempContract);
            }
        }
        return repoTemp;
    }

    /**
     * This is a method for sorting the "Repository" collection by the conditions passed through the comparator
     * @param comparator this is a comparator for transmitting sorting conditions
     */
    public void sort(Comparator<? extends Contracts> comparator){
        sorter.sort(contracts, (Comparator<Contracts>) comparator);
    }

    /**
     * This is a method for extracting contracts from the Repository collection
     */
    public void displayAllContracts(){
        for (Contracts cTemp: contracts) {
            if(cTemp != null){
                System.out.println(cTemp);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return size == that.size && Arrays.equals(contracts, that.contracts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(contracts);
        return result;
    }
}

