package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.RelevanceBrand;

import java.util.List;

public interface BrandService {
    public List<TbBrand> findAll();

    public PageResult findPage(int pageNum,int pageSize);


    public void add(TbBrand brand);


    public TbBrand findOne(Long id);

    public void update(TbBrand brand);

    public void delete(Long[] ids);


    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);


    RelevanceBrand selectRelevanceBrand();
}
