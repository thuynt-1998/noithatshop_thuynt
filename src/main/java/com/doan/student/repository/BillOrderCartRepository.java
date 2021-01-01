package com.doan.student.repository;

import com.doan.student.entity.BillOrderCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface BillOrderCartRepository extends JpaRepository<BillOrderCartEntity, Long> {
    BillOrderCartEntity save(BillOrderCartEntity entity);
    BillOrderCartEntity findFirstByOrderByIdDesc();
    boolean existsByOrderCartId(Long id);
    BillOrderCartEntity findByOrderCartId(Long id);

}
