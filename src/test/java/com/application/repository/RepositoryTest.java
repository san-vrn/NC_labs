package com.application.repository;

import com.application.contracts.ContractOnInternet;
import com.application.contracts.Contracts;
import com.application.entity.person.Person;
import com.application.entity.person.personCharacteristics.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @org.junit.jupiter.api.Test
    void add() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(1, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 200);
        Repository repository = new Repository();
        repository.add(contract);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(1, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 100);
        ContractOnInternet contract1 = new ContractOnInternet(2, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 150);
        ContractOnInternet contract2 = new ContractOnInternet(3, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 100);
        ContractOnInternet contract3 = new ContractOnInternet(4, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 500);

        Repository repository1 = new Repository();
        Repository repository2 = new Repository();

        repository1.add(contract);
        repository1.add(contract1);
        repository1.add(contract2);
        repository1.add(contract3);
        repository1.remove(2);
        repository2.add(contract);
        repository2.add(contract2);
        repository2.add(contract3);

        assertEquals(repository1, repository2);
    }

    @org.junit.jupiter.api.Test
    void getContract() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(1, LocalDate.now(), LocalDate.parse("2025-10-10"), 1010, testPerson, 100);
        Optional<ContractOnInternet> opContract = Optional.of(contract);
        Repository repository = new Repository();
        repository.add(contract);
        assertEquals(opContract, repository.getContract(1));
    }

    @Test
    void search() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(1, LocalDate.now(), LocalDate.parse("2025-10-10"), 1011, testPerson, 100);
        ContractOnInternet contract1 = new ContractOnInternet(2, LocalDate.now(), LocalDate.parse("2025-10-10"), 1012, testPerson, 150);
        ContractOnInternet contract2 = new ContractOnInternet(3, LocalDate.now(), LocalDate.parse("2025-10-10"), 1013, testPerson, 100);
        ContractOnInternet contract3 = new ContractOnInternet(4, LocalDate.now(), LocalDate.parse("2025-10-10"), 1014, testPerson, 500);

        Repository repository1 = new Repository();
        repository1.add(contract);
        repository1.add(contract1);
        repository1.add(contract2);
        repository1.add(contract3);

        Predicate<Contracts> filterPredicate = c -> c.getID() %2 == 0;

        Repository repoTemp;
        repoTemp = repository1.search(filterPredicate);

        assertEquals(Optional.of(contract1), repoTemp.getContract(2));
        assertEquals(Optional.of(contract3), repoTemp.getContract(4));
    }

    @Test
    void sort() {
        Person testPerson = new Person(1, "Fedorov", "Fedor", "Fedorovich", LocalDate.parse("1995-10-10"), Gender.MALE, 2015106604);
        ContractOnInternet contract = new ContractOnInternet(1, LocalDate.now(), LocalDate.parse("2025-10-11"), 1012, testPerson, 100);
        ContractOnInternet contract1 = new ContractOnInternet(2, LocalDate.now(), LocalDate.parse("2025-10-13"), 1011, testPerson, 150);
        ContractOnInternet contract2 = new ContractOnInternet(3, LocalDate.now(), LocalDate.parse("2025-10-09"), 1014, testPerson, 100);
        ContractOnInternet contract3 = new ContractOnInternet(4, LocalDate.now(), LocalDate.parse("2025-10-12"), 1013, testPerson, 500);

        Repository repository1 = new Repository();
        repository1.add(contract3);
        repository1.add(contract);
        repository1.add(contract1);
        repository1.add(contract2);

        Repository trueRepository = new Repository();
        trueRepository.add(contract);
        trueRepository.add(contract1);
        trueRepository.add(contract2);
        trueRepository.add(contract3);

        //Comparator<? extends Contracts> pcomp = Comparator.comparing(Contracts::getContractEndDate);
        Comparator<? extends Contracts> pcomp = Comparator.comparing(Contracts::getID);
        repository1.sort(pcomp);
        repository1.displayAllContracts();
        assertEquals(trueRepository, repository1);
    }
}
