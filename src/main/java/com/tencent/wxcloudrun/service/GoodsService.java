package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Errand;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.model.IdleItem;

import java.util.Optional;


public interface GoodsService {
    Optional<Good> getGoodsDetail(Integer gid);

    int insertIdleItem(IdleItem idleItem);

    int insertErrand(Errand errand);
}