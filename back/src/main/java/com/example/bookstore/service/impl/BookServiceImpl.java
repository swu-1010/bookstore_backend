package com.example.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bookstore.entity.Book;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2022-10-18
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Override
    public Page<Book> getBookByCate(Integer pageNum, Integer pageSize, Integer category) {
//        System.out.println(pageNum + " " + pageSize);
        Page<Book> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if (category == 0) {
            return this.page(page, queryWrapper);
        }
        queryWrapper.eq("category", category);
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Book> getBookByIds(String ids) {

        List<Integer> list = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        String[] array = ids.split(",");
        for (String i:array) {
            QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("name", "author", "price", "img", "publisher").eq("id", Integer.valueOf(i));
            bookList.add(this.getOne(queryWrapper));
        }
        return bookList;
    }

    @Override
    public Page<Book> searchBookByKey() {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book getByName(String name) {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.eq("name", name);
        return this.getOne(bookQueryWrapper);
    }

    //根据Id删除书籍
    public void deleteByIds(String ids) {

    }

}
