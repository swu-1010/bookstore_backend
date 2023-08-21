package com.example.bookstore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.entity.Book;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-10-18
 */
public interface BookService extends IService<Book> {
    Page<Book> getBookByCate(Integer pageNum, Integer pageSize, Integer category);
    List<Book> getBookByIds(String ids);

    void deleteByIds(String ids);
    Page<Book> searchBookByKey();
    Book update(Book book);
    Book getByName(String name);
}
