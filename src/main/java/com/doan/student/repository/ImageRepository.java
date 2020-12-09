package com.doan.student.repository;

import com.doan.student.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity save (ImageEntity entity);

}
