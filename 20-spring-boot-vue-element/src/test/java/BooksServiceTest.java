import com.kevin.SpringBootVueElementApplication;
import com.kevin.entity.Book;
import com.kevin.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootVueElementApplication.class)
public class BooksServiceTest {

    @Autowired
    BookService booksService;

    @Test
    public void getBooks(){

        List<Book> books = booksService.getBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        /*List<HashMap<String,Object>> books = booksService.getBooks();
        for (HashMap<String,Object> map : books) {
            for (Map.Entry<String,Object> entry: map.entrySet()) {
                System.out.println(entry.getKey() + "-------" + entry.getValue());
            }
        }*/
    }
}
