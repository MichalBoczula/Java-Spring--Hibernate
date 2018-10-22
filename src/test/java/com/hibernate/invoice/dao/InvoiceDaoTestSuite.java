package com.hibernate.invoice.dao;

import com.hibernate.invoice.Invoice;
import com.hibernate.invoice.Item;
import com.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        final Product product = new Product("wood");
        final Item item = new Item("chair", new BigDecimal(100),
                10, new BigDecimal(1000));
        final Invoice testInvoice = new Invoice("123456");

        //When
        productDao.save(product);
        product.getItems().add(item);
        testInvoice.getItems().add(item);
        invoiceDao.save(testInvoice);
        item.setInvoice(testInvoice);
        item.setProduct(product);
        itemDao.save(item);

        final List<Item> itemTestListInProduct = product.getItems();
        final List<Item> itemTestListInInvoice = testInvoice.getItems();

        //Then
        assertEquals(1, itemDao.count());
        assertEquals(1, invoiceDao.count());
        assertEquals(1, productDao.count());
        assertEquals(1, itemTestListInProduct.size());
        assertEquals(1, itemTestListInInvoice.size());

        //CleanUp
        itemDao.delete(item.getId());
        invoiceDao.delete(testInvoice.getId());
        productDao.delete(product.getId());
    }
}