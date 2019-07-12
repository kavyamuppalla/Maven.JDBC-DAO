package daos;

import com.sun.jdi.connect.Connector;
import com.sun.tools.classfile.Opcode;
import models.ProductDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDaoImpl implements JdbcDao<ProductDto> {

    public ProductDto findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE pid=" + id);
            if(rs.next())
            {
                ProductDto productDto = new ProductDto();

                productDto.setId( rs.getInt("pid") );
                productDto.setName( rs.getString("name") );
                productDto.setDescription( rs.getString("description") );
                productDto.setPrice( rs.getFloat("price") );
                productDto.setQuantity(rs.getInt("quantity"));
                productDto.setStart_date(rs.getDate("start_date"));
                productDto.setEnd_date(rs.getDate("end_date"));
                productDto.setCreated_by(rs.getString("created_by"));
                return productDto;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from PRODUCT");
            List products = new ArrayList();
            while (rs.next()) {
                ProductDto productDto = new ProductDto();
                productDto.setId(rs.getInt("pid"));
                //productDto.setId( rs.getInt("pid") );
                productDto.setName( rs.getString("name") );
                productDto.setDescription( rs.getString("description") );
                productDto.setPrice( rs.getFloat("price") );
                productDto.setQuantity(rs.getInt("quantity"));
                productDto.setStart_date(rs.getDate("start_date"));
                productDto.setEnd_date(rs.getDate("end_date"));
                productDto.setCreated_by(rs.getString("created_by"));
                products.add(productDto);
            }
            return products;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ProductDto update(ProductDto dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRODUCT SET NAME=?, DESCRIPTION=?, PRICE=?, QUANTITY=?, START_DATE=?, END_DATE=?, CREATED_BY=? WHERE pid=?");
            preparedStatement.setString(1,dto.getName());
            preparedStatement.setString(2,dto.getDescription());
            preparedStatement.setFloat(3,dto.getPrice());
            preparedStatement.setInt(4,dto.getQuantity());
            preparedStatement.setDate(5, (Date) dto.getStart_date());
            preparedStatement.setDate(6,(Date) dto.getEnd_date());
            preparedStatement.setString(7,dto.getDescription());
            preparedStatement.setInt(8,dto.getId());
            int i = preparedStatement.executeUpdate();
            if(i==1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ProductDto create(ProductDto dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into zipcode.PRODUCT values(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,dto.getId());
            preparedStatement.setString(2,dto.getName());
            preparedStatement.setString(3,dto.getDescription());
            preparedStatement.setFloat(4,dto.getPrice());
            preparedStatement.setInt(5,dto.getQuantity());
            preparedStatement.setDate(6, dto.getStart_date());
            preparedStatement.setDate(7, dto.getEnd_date());
            preparedStatement.setString(8,dto.getDescription());
            int i = preparedStatement.executeUpdate();
            if(i==1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        ProductDto productDto = new ProductDto();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM PRODUCT WHERE pid=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
