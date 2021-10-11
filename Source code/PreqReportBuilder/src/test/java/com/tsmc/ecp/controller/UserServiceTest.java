/**
 * 
 */
package com.tsmc.ecp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tsmc.ecp.dao.UserDao;
import com.tsmc.ecp.model.User;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

    //先普通的注入一個userService bean
    @Autowired
    private UserService userService;
    
    @MockBean
    private UserDao userDao;

//    @Test
//    public void getUserById() throws Exception {
//        //普通的使用userService，他裡面會再去call userDao取得DB的data
//        User user = userService.getUserById(1);
//
//        //檢查結果
//        Assert.assertNotNull(user);
//        //Assert.assertEquals(user.getId(), new Integer(1));
//        Assert.assertEquals(user.getName(), "John");
//    }
    
    /*
     * Test with Mockito
     */
    @Test
    public void getUserById() throws Exception {
        // 定義當調用mock userDao的getUserById()方法，並且參數為3時，就返回id為200、name為I'm mock3的user對象
        Mockito.when(userDao.getUserById(3)).thenReturn(new User(200, "I'm mock 3"));

        // 返回的會是名字為I'm mock 3的user對象
        User user = userService.getUserById(3);

        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(new User(3, "I'm mock"));
        User user1 = userService.getUserById(3); // 回傳的user的名字為I'm mock
        User user2 = userService.getUserById(200); // 回傳的user的名字也為I'm mock
        
        Mockito.when(userService.insertUser(Mockito.any(User.class))).thenReturn(300);
        //User user3 = userService.getUserById(3); // 回傳的user的名字為I'm mock
        Integer rslt = userService.insertUser(new User(3, "I'm mock")); 
        
        Assert.assertNotEquals(null , rslt);
        // https://kucw.github.io/blog/2020/2/spring-unit-test-mockito/
    }
    
    
    ///
    @Test
    public void getDistinct() {
    	
    	List<String> lstUsers = new ArrayList<String>(); 
//    	lstUsers = lstUsers.stream()
//    			.distinct()
//    			.collect(Collectors.toList());
    	
    	List<Book> bookList = new ArrayList<Book>();
    	bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
    	bookList.add(new Book("The Two Towers", 1954, "0345339711"));
    	bookList.add(new Book("The Return of the King", 1955, "0618129111"));
    	
    	try {

        	Map<String, Book> convrtRsltMap = listToMap(bookList);
        	Assert.assertNotNull(convrtRsltMap);
		} catch (Exception e) {
			String excepString = ExceptionUtils.getStackTrace(e);
			// TODO: handle exception
		}
    
    }
    public Map<String, Book> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity()));
    }
    public class Book {
        public Book(String _name, int _rlsYear, String _isbn) {
			this.name = _name; 
			this.releaseYear = _rlsYear; 
			this.isbn = _isbn; 
		}
		private String name;
        private int releaseYear;
        private String isbn;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getReleaseYear() {
			return releaseYear;
		}
		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
        
        // getters and setters
        
    }

}
