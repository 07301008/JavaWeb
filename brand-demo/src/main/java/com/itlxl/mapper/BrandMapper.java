package com.itlxl.mapper;

import com.itlxl.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加用户
     */
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 修改用户数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除用户
     * @param id
     */
    void delete(int id);

}
