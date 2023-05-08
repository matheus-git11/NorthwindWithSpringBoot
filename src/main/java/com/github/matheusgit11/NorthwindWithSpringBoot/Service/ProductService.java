package com.github.matheusgit11.NorthwindWithSpringBoot.Service;

import com.github.matheusgit11.NorthwindWithSpringBoot.DTO.ProductDTO;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Category;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Product;
import com.github.matheusgit11.NorthwindWithSpringBoot.Entity.Suppliers;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.CategoryRepository;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.ProductRepository;
import com.github.matheusgit11.NorthwindWithSpringBoot.Repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;
    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public Optional<Product> save (ProductDTO productDTO){
        Optional<Suppliers> supplier = suppliersRepository.findById(productDTO.getSupplierId());
        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());

        if(supplier.isEmpty() || category.isEmpty()){
            return Optional.empty();
        }

        Product product = new Product();
            product.setProductName(productDTO.getProductName());
            product.setSupplier(supplier.get());
            product.setCategory(category.get());
            product.setQuantityPerUnit(productDTO.getQuantityPerUnit());
            product.setUnitPrice(productDTO.getUnitPrice());
            product.setUnitsInStock(productDTO.getUnitsInStock());
            product.setUnitsOnOrder(productDTO.getUnitsOnOrder());
            product.setReorderLevel(productDTO.getReorderLevel());
            product.setDiscontinued(productDTO.isDiscontinued());

     Product savedProduct = repository.save(product);

        return Optional.of(savedProduct);
    }

    public List<Product> getAll(){
       return repository.findAll();
    }

}
