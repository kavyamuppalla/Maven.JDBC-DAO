package daos;

import models.ProductDto;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ProductDaoTest {

    @Test
    public void findAllTest() {

        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
        List<ProductDto> productDtos = jdbcDao.findAll();
        Assert.assertEquals(5, productDtos.size());
    }
    @Test
    public void findByIdTest() {
        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
        ProductDto productDtos = jdbcDao.findById(1);
        Assert.assertEquals("MACBOOKPRO15",productDtos.getName());
    }
    @Test
    public void insertTest() {
        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
        ProductDto dto = new ProductDto();
        dto.setId(6);
        dto.setName("watch");
        dto.setDescription("watch description");
        dto.setPrice(280);
        dto.setQuantity(1);
        dto.setStart_date(new Date(new java.util.Date().getTime()));
        dto.setEnd_date(new Date(new java.util.Date().getTime()));
        dto.setCreated_by("abc");
        ProductDto productDtos = jdbcDao.create(dto);
           int actual = productDtos.getId();
        Assert.assertEquals(6,actual);
    }


//    @Test
//    public void updateTest() {
//        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
//        ProductDto dto = new ProductDto();
//
//        dto.setName("apple watch");
//
//        ProductDto productDtos = jdbcDao.create(dto);
//        int actual = productDtos.getId();
//        Assert.assertEquals("applewatch",actual);
//    }


     @Test
     public void updateTest() {
        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
        ProductDto dto = new ProductDto();
         ProductDto productDto = jdbcDao.findById(4);
        productDto.setName("apple watch");

        ProductDto productDto1 = jdbcDao.update(productDto);

        String actual = productDto1.getName();
        Assert.assertEquals("apple watch",actual);
    }

    @Test
    public void deleteTest() {
        JdbcDao<ProductDto> jdbcDao = new ProductDaoImpl();
        ProductDto dto = new ProductDto();
        jdbcDao.delete(5);
        List<ProductDto> productDtos = jdbcDao.findAll();

        Assert.assertEquals(6,productDtos.size());
    }


}
