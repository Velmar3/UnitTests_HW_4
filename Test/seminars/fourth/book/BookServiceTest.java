package seminars.fourth.book;

//        1. Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
//        Ответ: Тестовые заглушки экономят оперативную память и ресурсы процессора заменяя реальные объекты искусственными.
//        2. Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
//        Ответ: mock
//        3. Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение
//        в ответ на вызов метода?
//        Ответ: stub — объекты, также называемые заглушками, которые возвращают заранее определенные значения на определенные входные данные.
//        4. Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
//        Ответ: Fake небольшие фрагменты кода, контролируемые тестами, которые имитируют поведение фактических частей, которые они заменяют.

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void testFindById() {

        BookRepository mockRepository = mock(BookRepository.class);
        when(mockRepository.findById("1")).thenReturn(new Book("1", "Test Book", "Test Author"));
        BookService bookService = new BookService(mockRepository);

        Book result = bookService.findBookById("1");

        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
    }

    @Test
    public void testFindAllBooks() {

        BookRepository mockRepository = mock(BookRepository.class);
        when(mockRepository.findAll())
                .thenReturn(java.util.List.of(new Book("123", "Test Book", "Test Author")));
        BookService bookService = new BookService(mockRepository);

        List<Book> result = bookService.findAllBooks();

        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
        assertEquals("Test Author", result.get(0).getAuthor());
    }
}