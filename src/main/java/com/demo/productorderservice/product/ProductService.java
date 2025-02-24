package com.demo.productorderservice.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductService {

    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody  AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final long productId) {
            final Product product = productPort.getProduct(productId);
        GetProductResponse response = new GetProductResponse(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy());
        return ResponseEntity.ok(response);
    }

}
