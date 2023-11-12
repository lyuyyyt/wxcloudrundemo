package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where GID = #{GID}")
    Good getGood(@Param("GID") int gid);

    @Select("SELECT * FROM goods WHERE MATCH(Gdes) AGAINST (#{keyword} IN NATURAL LANGUAGE MODE)")
    ArrayList<Good> getGoods(@Param("keyword") String keyword);

    @Select("select * from goods where Gcategory = #{Gcategory} and Status = 1")
    ArrayList<Good> getSellingGoods(@Param("Gcategory") int Gcategory);

    @Select("select * from goods_image where GID = #{GID}")
    ArrayList<GoodsImage> getgoodimage(@Param("GID") int gid);

    @Insert("insert into goods(Gdes, Gprice, Gcampus, Status, Gcategory, UID) values (#{Gdes}, #{Gprice}, #{Gcampus}, #{Gstatus}, #{Gcategory}, #{UID})")
    @Options(useGeneratedKeys = true, keyProperty = "GID", keyColumn = "GID")
    void insertGood(Good good);

    @Insert("insert into idle_item (GID) values (#{GID})")
    void insertIdleItem(IdleItem idleItem);

    @Insert("insert into errand (GID, deadline) values (#{GID}, #{deadline})")
    void insertErrand(Errand errand);
}