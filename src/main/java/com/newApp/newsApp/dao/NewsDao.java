package com.newApp.newsApp.dao;

import com.newApp.newsApp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NewsDao  extends JpaRepository<News,String> {
    List<News> findByCategory(String category);
    Optional<News> findByTitle(String title);
//     void  deleteByCategory(String category);
//    News deleteById(int id);
//    @Modifying
//    @Transactional
//    @Query(value = "DELETE FROM  News WHERE category = ?1",nativeQuery = true)
//    void deleteByCategory(String category);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM News news WHERE news.category =:n")
    void deleteByCategory(@Param("n") String category);

}
