package com.chen.mmall003.service;

import com.chen.mmall003.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mmall003.vo.TableDataVO;
import com.chen.mmall003.vo.TableProductVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-05-29
 */
public interface ProductService extends IService<Product> {

    public List<Product> findByCategoryId(String type, Integer categoryId);

    /**
     * 后台管理系统返回商品数据
     */
    public TableDataVO<TableProductVO> findAllTableData(Integer page, Integer limit);

}
