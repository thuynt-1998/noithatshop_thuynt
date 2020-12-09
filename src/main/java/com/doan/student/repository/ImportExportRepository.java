package com.doan.student.repository;

import com.doan.student.entity.ImportExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ImportExportRepository extends JpaRepository<ImportExportEntity, Long> {
    ImportExportEntity save(ImportExportEntity entity);
    Boolean existsByCode(String code);
    @Modifying
    @Query("update ImportExportEntity set export_product=:export where code=:code")
    ImportExportEntity updateExportProduct(@Param("export")BigInteger exportProduct , @Param("code") String code);
    @Modifying
    @Query("update ImportExportEntity set import_product=:import where code=:code")
    ImportExportEntity updateImportProduct(@Param("import")BigInteger importProduct , @Param("code") String code);

}
