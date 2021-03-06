package demo.entity.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<BookEntity> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	
	
}
