package co.com.jeferson.productsproject.Mapper;

import co.com.jeferson.productsproject.Model.Product;
import co.com.jeferson.productsproject.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    //Explicit mapping for product

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "brand", source = "brand")
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "brand", source = "brand")
    ProductDTO toDTO(Product product);
}

