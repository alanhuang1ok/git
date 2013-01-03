package com.zqgame.mappers;

import com.zqgame.models.Blog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository(value = "blogMapper")
public interface BlogMapper extends BaseMappers<Blog, java.lang.Integer> {
    @Override
    @Insert("   insert into blogs(title , content , comment,created_at) values (#{title},#{content},#{comment},#{created_at})")
    int save(Blog blog);
}
