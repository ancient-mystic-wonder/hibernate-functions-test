package com.dtlim.repository;

import com.dtlim.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionRepositoryPerformanceTest {

    @Autowired
    private TransactionRepository repository;

    @Test
    public void averageTime() throws Exception {
        long total = 0;
        long times = 10;
        for(int i=0; i<times; i++) {
            total += timeSearch();
        }
        System.out.println("After " + times + " runs, average: " + total/times);
    }

    public long timeSearch() throws Exception {
        long start = System.currentTimeMillis();
        search();
        long end = System.currentTimeMillis();

        System.out.println("Start: " + start);
        System.out.println("End:   " + end);
        System.out.println("Time:  " + (end - start) + " ms");
        System.out.println();

        return end-start;
    }

    private void search() throws Exception {
        Date before = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-06");
        Date after = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-07");

        List<Transaction> transactions = repository.findAll(TransactionSpec.loggedBetween(before, after));

        System.out.println("Found: " + transactions.size());
    }
}
