package com.doan.student.payload.response;

import com.doan.student.payload.dto.BillProviderDTO;

import java.util.List;

public class PageGetData {
    private int totalPage;
    private int totalSize;
    private Long totalRecord;
    private List<?> listDTO;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<?> getListDTO() {
        return listDTO;
    }

    public void setListDTO(List<?> listDTO) {
        this.listDTO = listDTO;
    }
}
