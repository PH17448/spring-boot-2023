package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.output.NewOutput;
import com.example.dto.NewDTO;
import com.example.service.INewService;

@RestController
@RequestMapping("/api")
public class NewAPI {
	
	@Autowired
	private INewService newService ;
	
	@GetMapping(value="/new")
	public NewOutput showNew(@RequestParam(value="page",required=false) Integer page ,
							@RequestParam(value="limit",required=false) Integer limit,
							@RequestParam(value="sortName",required=false) String sortName ,
							@RequestParam(value="sortBy",required=false) String sortBy) {
		NewOutput newOutPut = new NewOutput();
		if(page != null && limit != null && sortName == null && sortBy == null) {
			newOutPut.setPage(page);
			Pageable pageable = new PageRequest((int)page -1 ,(int)limit);
			newOutPut.setListResults(newService.findAll(pageable));
			newOutPut.setTotalPages((int) Math.ceil((newService.totalItem())/limit));
		}else if(page != null && limit != null && sortName != null && sortBy != null){
			newOutPut.setPage(page);
			newOutPut.setSortName(sortName);
			newOutPut.setSortBy(sortBy);
			@SuppressWarnings("static-access")
			Pageable pageable = new PageRequest((int)page -1 ,(int)limit,Sort.DEFAULT_DIRECTION.valueOf(sortBy),sortName);
			newOutPut.setListResults(newService.findAll(pageable));
			newOutPut.setTotalPages((int) Math.ceil((newService.totalItem())/limit));
		}else if(page == null && limit == null && sortName == null && sortBy == null){
			newOutPut.setListResults(newService.findAll());
		}
		
		return newOutPut;
	}
	
	
	@PostMapping(value="/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model) ;
	}
	@PutMapping(value="/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model ,@PathVariable("id") Long id) {
		model.setId(id);
		return newService.save(model) ;
	}
	
	@DeleteMapping(value="/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
