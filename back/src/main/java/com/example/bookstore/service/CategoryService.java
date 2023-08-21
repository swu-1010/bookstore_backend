package com.example.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookstore.entity.Category;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-10-18
 */
public interface CategoryService extends IService<Category> {

    List<Category> getAllCate();

    Category getCateById(Integer id);
}
