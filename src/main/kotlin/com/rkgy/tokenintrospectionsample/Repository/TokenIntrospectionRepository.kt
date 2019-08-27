package com.rkgy.tokenintrospectionsample.Repository

import com.rkgy.tokenintrospectionsample.Entity.AccessToken
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface TokenIntrospectionRepository {
    @Select("SELECT * FROM AccessToken")
    fun select(): List<AccessToken>
}
