package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.CnBlogs;
import com.qfedu.commonadmin.mapper.CnBlogsMapper;
import com.qfedu.commonadmin.service.CnBlogsService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:06
 */
@Service
public class CnBlogsServiceImpl implements CnBlogsService {
    @Autowired
    private CnBlogsMapper cnBlogsMapper;
    @Override
    public R save(CnBlogs cnBlogs) {
        return ResultUtil.setRes(cnBlogsMapper.insert(cnBlogs));
    }
}
