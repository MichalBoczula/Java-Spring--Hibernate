package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTestSuite {
    @Autowired
    private ItemDao itemDao;

    @Test
    public void testSomething(){
        //Given
        final Item chairs = new Item("chair", new BigDecimal(115),
                10, new BigDecimal(1150));

        //When
        itemDao.save(chairs);

        //Then
        assertEquals(1, itemDao.count());
        //CleanUp
        itemDao.delete(chairs);
    }
}