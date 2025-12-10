package com.shivam.inventory.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // explicit constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setSku(request.getSku());
        product.setCategory(request.getCategory());
        product.setQuantity(request.getQuantity());
        product.setReorderLevel(request.getReorderLevel());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setSku(request.getSku());
        product.setCategory(request.getCategory());
        product.setQuantity(request.getQuantity());
        product.setReorderLevel(request.getReorderLevel());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Page<Product> list(String search, String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (search != null && !search.trim().isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search, pageable);
        }

        if (category != null && !category.trim().isEmpty()) {
            return productRepository.findByCategoryContainingIgnoreCase(category, pageable);
        }

        return productRepository.findAll(pageable);
    }
}
