
package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
