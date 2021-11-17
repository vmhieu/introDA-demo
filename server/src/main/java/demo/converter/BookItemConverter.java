package demo.converter;

import org.springframework.stereotype.Component;

import demo.model.entity.book.*;
import demo.model.dto.book.*;

@Component
public class BookItemConverter {
	public BookItemEntity toEntity(BookItemDTO dto) {
		BookItemEntity entity = new BookItemEntity();
		entity.setBarcode(dto.getBarcode());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
	public BookItemDTO toDTO(BookItemEntity entity) {
		BookItemDTO dto = new BookItemDTO();
		if(entity.getId() != 0) {
			dto.setId(entity.getId());
		}
		dto.setBarcode(entity.getBarcode());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		return dto;
	}
	
	public BookItemEntity toEntity(BookItemDTO dto, BookItemEntity entity) {
		entity.setBarcode(dto.getBarcode());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
}
