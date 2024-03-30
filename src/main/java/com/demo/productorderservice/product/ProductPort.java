package com.demo.productorderservice.product;

interface ProductPort {
    void save(final Product product);

    Product getProduct(long productId);
}
