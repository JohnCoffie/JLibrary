package jlibrary.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jlibrary.entity.Book;
import jlibrary.entity.BookCategory;
import jlibrary.service.BookManager;
import jlibrary.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView toAddBookPage(Model model,HttpServletRequest request){
		List<BookCategory> categoryList = bookManager.findAllBookCategories();
		model.addAttribute("categoryList", categoryList);
		return new ModelAndView(Constants.BOOK_ADD_PAGE);
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ModelAndView addBook(HttpServletRequest request){
		Book book = new Book();
		BookCategory category = new BookCategory();
		
		book.setBookName( request.getParameter("bookName") );
		book.setAuthor( request.getParameter("author") );
		category.setBookCategoryId( Integer.parseInt(request.getParameter("category")) );
		book.setBookCategory( category );
		book.setPrice( Double.parseDouble(request.getParameter("price")) );
		book.setEntryDate( new Date() );
		book.setTotalNumber( Short.parseShort(request.getParameter("category")) );
		book.setIntro( request.getParameter("intro") );
		
		String dateString = request.getParameter("publishDate");
		try {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date publishDate = sdf.parse(dateString.toString());
			book.setPublishDate( publishDate );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bookManager.addBook(book);
		
		return new ModelAndView("redirect:/"+Constants.BOOK_LIST_ACTION);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView toUpdateBookPage(Model model,HttpServletRequest request){
		int id = Integer.valueOf(request.getParameter("bookId"));
		Book book = bookManager.getBookById(id);
		List<BookCategory> categoryList = bookManager.findAllBookCategories();
		model.addAttribute("book", book);
		model.addAttribute("categoryList", categoryList);
		return new ModelAndView(Constants.BOOK_UPDATE_PAGE);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updateBookPage(HttpServletRequest request){
		Book book = bookManager.getBookById( Integer.parseInt(request.getParameter("bookId")) );
		BookCategory category = new BookCategory();
		
		book.setBookId( Integer.parseInt(request.getParameter("bookId")) );
		book.setBookName( request.getParameter("bookName") );
		book.setAuthor( request.getParameter("author") );
		category.setBookCategoryId( Integer.parseInt(request.getParameter("category")) );
		book.setBookCategory( category );
		book.setPrice( Double.parseDouble(request.getParameter("price")) );
		//book.setEntryDate( new Date() );
		book.setTotalNumber( Short.parseShort(request.getParameter("amount")) );
		book.setIntro( request.getParameter("intro") );
		
		String dateString = request.getParameter("publishDate");
		try {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date publishDate = sdf.parse(dateString.toString());
			book.setPublishDate( publishDate );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bookManager.updateBook(book);

		return new ModelAndView("redirect:/"+Constants.BOOK_LIST_ACTION);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String removeBooks(HttpServletRequest request){
		String bookIdList = request.getParameter("bookIdList");
		List<Integer> list = new ArrayList<Integer>();
		
		String[] ids = bookIdList.split(","); 
		for (int i = 0; i < ids.length; i++) {
			list.add( Integer.valueOf(ids[i]) );
		}
		bookManager.removeBooks(list); 
		
		return "redirect:list"; 
	}
}
