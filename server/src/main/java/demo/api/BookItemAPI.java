package demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.api.output.BookItemOutput;
import demo.logicApplication.bookDAO.IBookItemService;
import demo.model.dto.book.BookItemDTO;

@CrossOrigin
@RestController
public class BookItemAPI {

	@Autowired
	private IBookItemService bookItemService;
	
	@GetMapping(value = "/bookItem")
	public BookItemOutput showBookItem(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
										@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookItemOutput result = new BookItemOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListResult(bookItemService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (bookItemService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/bookItem")
	public BookItemDTO updateBookItem(@RequestBody BookItemDTO model) {
		return bookItemService.save(model);
	}
	
	@PutMapping(value = "/bookItem/{id}")
	public BookItemDTO updateBookItem(@RequestBody BookItemDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return bookItemService.save(model);
	}
	
	@DeleteMapping(value = "/bookItem")
	public void deleteBookItem(@RequestBody long[] ids) {
		bookItemService.delete(ids);
	}
}
