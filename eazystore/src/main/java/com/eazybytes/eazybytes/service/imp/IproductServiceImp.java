package com.eazybytes.eazybytes.service.imp;

import com.eazybytes.eazybytes.dto.ProductDto;
import com.eazybytes.eazybytes.entity.Product;
import com.eazybytes.eazybytes.repository.ProductRepository;
import com.eazybytes.eazybytes.service.IproductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IproductServiceImp implements IproductService {


    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(this::transformToDto)
                .collect(Collectors.toList());
    }

    private ProductDto transformToDto (Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        productDto.setProductId(product.getId());
        return productDto;
    }
}
