package com.example.bookstore.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Category;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CategoryService;
import com.example.bookstore.service.FavorService;
import com.example.bookstore.utils.Result;
import com.example.bookstore.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-10-18
 */
@CrossOrigin(origins="http://localhost:8080") //跨域
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private FavorService favorService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public Result getAll(){
        return null;
    }

    //根据id查询Book
    @GetMapping("/getBookById")
    public Result getBookById(Integer id){
        return null;
    }

    //根据key搜索Book
    @GetMapping("/searchBookByKey")
    public Result searchBookByKey(Integer pageNum, Integer pageSize, Integer option, String key){
        return null;
    }

    //查根据id询cartbook
    @GetMapping("/getBookByIds")
    public Result getBookByIds(String ids){
        return null;
    }

    //根据category查询Book
    @GetMapping( "/getBookByCate")
    public Result getBookByCate(Integer pageNum, Integer pageSize, Integer category) {
        Result result = new Result();
        Page<Book> book = bookService.getBookByCate(pageNum, pageSize, category);
        return getBook(result, book);
    }

    private Result getBook(Result result, Page<Book> book) {
        for (int i=0; i < book.getRecords().size(); i++) {
            Category cate = categoryService.getCateById(book.getRecords().get(i).getCategory());
            if(cate != null)
                book.getRecords().get(i).put("cateName",cate.getName());
            book.getRecords().get(i).put("isFavor", favorService.getFavor(book.getRecords().get(i).getId()) == null ? 0 : 1);
        }
        result.setData(book);
        result.success("查询成功");
        return result;
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Book book){
        return null;
    }

    //上传图片
    @PostMapping("/uploadImg")
    public String uploadImage(@RequestParam(value = "img") MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return "文件有误！";
        }
        return UploadUtils.uploadImage(multipartFile);
    }

    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Book book){
        return null;
    }

    //根据ids删除
    @PostMapping("/deleteByIds")
    public Result deleteByIds(String ids){
        return null;
    }
}

