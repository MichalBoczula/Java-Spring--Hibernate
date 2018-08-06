package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    public void testSomething(){
        //Given
        final Product wood = new Product("wood");
        final Item chair = new Item("Chair", new BigDecimal(100),
                10, new BigDecimal(1000));

        wood.getItems().add(chair);
        chair.setProduct(wood);

        //When
        productDao.save(wood);
        itemDao.save(chair);
        List<Item> itemList = wood.getItems();

        //Then
        assertEquals(1, productDao.count());
        assertEquals(1, itemDao.count());
        assertEquals(1, itemList.size());

        //CleanUp
        itemDao.delete(chair);
        productDao.delete(wood);
    }
}