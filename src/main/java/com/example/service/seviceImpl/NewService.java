package com.example.service.seviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.converter.NewConverter;
import com.example.dto.NewDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository ;
	
	@Autowired
	private CategoryRepository categoryRepository ;
	
	@Autowired
	private NewConverter newConverter ;
	
	@Override
	public NewDTO save(NewDTO newDto) 
	{	
		NewEntity newEntity = new NewEntity();
		if(newDto.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOne(newDto.getId());
			newEntity = newConverter.toEntity(newDto, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDto);
		}
		CategoryEntity category = categoryRepository.findOneByCode(newDto.getCategoryCode());
		newEntity.setCategory(category);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity) ;
	}

	

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newRepository.delete(id);
		}
	}



	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = 	newRepository.findAll(pageable).getContent();
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}



	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}



	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> result = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for(NewEntity item : entities) {
			NewDTO dto = newConverter.toDTO(item);
			result.add(dto);
		}
		return result;
	}



	

}
