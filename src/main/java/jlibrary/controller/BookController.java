package jlibrary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jlibrary.entity.Book;
import jlibrary.service.BookManager;
import jlibrary.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book") 
public class BookController {
	
	@Autowired
	private BookManager bookManager;

	@RequestMapping("/list")
	public ModelAndView getBookList(Model model,HttpServletRequest request){
		List<Book> bookList = bookManager.findAllBooks();
		model.addAttribute("bookList", bookList);
		return new ModelAndView(Constants.BOOK_LIST_PAGE);
	}
}
