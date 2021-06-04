package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Serializable> {

}
