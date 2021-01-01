package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.BillOrderCartConverter;
import com.doan.student.converter.CustomerConverter;
import com.doan.student.converter.OrderCartConverter;
import com.doan.student.entity.BillOrderCartEntity;
import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.OrderCartEntity;
import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.BillOrderCartDTO;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.repository.BillOrderCartRepository;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.repository.OrderCartRepository;
import com.doan.student.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCartServices  implements OrderCartService {
    @Autowired
    private OrderCartConverter orderCartConverter;
    @Autowired
    private OrderCartRepository orderCartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private BillOrderCartConverter billOrderCartConverter;
    @Autowired
    private BillOrderCartRepository billOrderCartRepository;

    @Override
    public OrderCartDTO saveOrderCart(OrderCartDTO dto) {
            if (orderCartRepository.findAll().isEmpty()) {
                dto.setCode("OCC-00001");
            } else {
                String code = Constant.convertCode(orderCartRepository.findFirstByOrderByIdDesc().getCode(), "OCC-");
                dto.setCode(code);
            }
            return orderCartConverter.EntityToDtoResponse(orderCartRepository.save(orderCartConverter.DtoToEntity(dto)));
    }
    @Override
    public List<OrderCartDTO> getByCustomer(CustomerDTO user) {
        List<OrderCartDTO> list  = new ArrayList<>();
        for (OrderCartEntity entity : orderCartRepository.findByByCustomer(customerConverter.DtoToEntity( user))) {
            list.add(orderCartConverter.EntityToDtoResponse(entity));
        }
        return list;
    }

    @Override
    public List<OrderCartDTO> getAll() {
         List<OrderCartDTO> list  = new ArrayList<>();
        for (OrderCartEntity entity : orderCartRepository.findByOrderByModifiedDateDesc()) {
            list.add(orderCartConverter.EntityToDtoResponse(entity));
        }
        return list;
    }

    @Override
    public String existsByCode(String code) {
        return orderCartRepository.existsByCode(code)? Constant.EXISTS: Constant.NO;
    }

    @Override
    public List<OrderCartDTO> findByStatus(String status) {
        List<OrderCartEntity> entityList= status.equals("all")? orderCartRepository.findAll(): orderCartRepository.findByStatusContains(status) ;
        List<OrderCartDTO> list = new ArrayList<>();
        for(OrderCartEntity entity : entityList)
        {
            list.add(orderCartConverter.EntityToDtoResponse(entity));
        }
        return list;
    }

    @Override
    public List<OrderCartDTO> findByStatusAndCustomer(String status, CustomerDTO name) {
        List<OrderCartDTO> list = new ArrayList<>();
        for(OrderCartEntity entity : orderCartRepository.findByByCustomerAndStatusContains(customerConverter.DtoToEntity( name),status))
        {
            list.add(orderCartConverter.EntityToDtoResponse(entity));
        }
        return list;
    }



    @Override
    public long countByOrderCartNew() {
        long count=0;
        try{
            count= orderCartRepository.countByStatusContains(Constant.ORDER);

        }
        catch (Exception e){

        }
        return count;
    }


    @Override
    public String updateOrderCart(String status, Long id) {
        try{
            orderCartRepository.updateRoomStatus(id, status);
            return Constant.YES;
        }
        catch (Exception e){
           return Constant.NO;
        }
    }

    @Override
    public BillOrderCartDTO saveBill(BillOrderCartDTO dto) {
        if(billOrderCartRepository.existsByOrderCartId(dto.getOrderCart().getId()))
        {
            billOrderCartConverter.EntityToDto(billOrderCartRepository.findByOrderCartId(dto.getOrderCart().getId()));
        }
        if (billOrderCartRepository.findAll().isEmpty()) {
            dto.setCode("BOC-00001");
        } else {
            String code = Constant.convertCode(orderCartRepository.findFirstByOrderByIdDesc().getCode(), "BOC-");
            dto.setCode(code);
        }
        BillOrderCartEntity entity= billOrderCartRepository.save(billOrderCartConverter.DtoToEntity(dto));
        orderCartRepository.updateRoomStatus(dto.getOrderCart().getId(),Constant.CREATEBill);
        return billOrderCartConverter.EntityToDto(billOrderCartRepository.save(billOrderCartConverter.DtoToEntity(dto)));
    }
}
