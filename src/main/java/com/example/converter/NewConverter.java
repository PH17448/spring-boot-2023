package com.example.converter;

import org.springframework.stereotype.Component;

import com.example.dto.NewDTO;
import com.example.entity.NewEntity;


@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO newDto) {
		NewEntity newEntity = new NewEntity();
		newEntity.setTitle(newDto.getTitle());
		newEntity.setContent(newDto.getContent());
		newEntity.setThumbnail(newDto.getThumbnail());
		newEntity.setShortDescription(newDto.getShortDescription());
		return newEntity ;
	}
	
	public NewDTO toDTO (NewEntity newEntity) {
		NewDTO newDto = new NewDTO();
		if(newEntity.getId() != null) {
			newDto.setId(newEntity.getId());
		}
		newDto.setTitle(newEntity.getTitle());
		newDto.setContent(newEntity.getContent());
		newDto.setThumbnail(newEntity.getThumbnail());
		newDto.setShortDescription(newEntity.getShortDescription());
		newDto.setCreatedDate(newEntity.getCreatedDate());
		newDto.setCreatedBy(newEntity.getCreateBy());
		newDto.setModifiedDate(newEntity.getModifiedDate());
		newDto.setModifiedBy(newEntity.getModifiedBy());
		return newDto ;
	}
	
	public NewEntity toEntity(NewDTO newDto , NewEntity oldNewEntity) {
		oldNewEntity.setTitle(newDto.getTitle());
		oldNewEntity.setContent(newDto.getContent());
		oldNewEntity.setThumbnail(newDto.getThumbnail());
		oldNewEntity.setShortDescription(newDto.getShortDescription());
		return oldNewEntity ;
	}
	
}
