package com.itlxl.service;

import com.itlxl.mapper.BrandMapper;
import com.itlxl.pojo.Brand;
import com.itlxl.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    // 1、调用BrandMapper.selectAll()
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取BrandMapper
        BrandMapper bm = sqlSession.getMapper(BrandMapper.class);

        // 4、调用方法
        List<Brand> brands = bm.selectAll();

        // 5、释放资源
        sqlSession.close();
        // 6、返回
        return brands;
    }

    /**
     * 添加用户
     */
    public void add(Brand brand){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取BrandMapper
        BrandMapper bm = sqlSession.getMapper(BrandMapper.class);
        // 4、调用方法
        bm.add(brand);
        // 5、提交事务
        sqlSession.commit();
        // 6、释放资源
        sqlSession.close();
    }

    /**
     * 根据id查询用户
     */
    public Brand selectById(int id){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取BrandMapper
        BrandMapper bm = sqlSession.getMapper(BrandMapper.class);
        // 4、调用方法
        Brand brand = bm.selectById(id);
        // 5、释放资源
        sqlSession.close();
        // 6、返回
        return brand;
    }

    /**
     * 修改用户数据
     * @param brand
     */
    public void update(Brand brand){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取BrandMapper
        BrandMapper bm = sqlSession.getMapper(BrandMapper.class);
        // 4、调用方法
        bm.update(brand);
        // 5、提交事务
        sqlSession.commit();
        // 6、释放资源
        sqlSession.close();
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){
        // 2、获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取BrandMapper
        BrandMapper bm = sqlSession.getMapper(BrandMapper.class);
        // 4、调用方法
        bm.delete(id);
        // 5、提交事务
        sqlSession.commit();
        // 6、释放资源
        sqlSession.close();
    }
}
