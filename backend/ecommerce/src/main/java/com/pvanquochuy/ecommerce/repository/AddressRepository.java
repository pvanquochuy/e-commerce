package com.pvanquochuy.ecommerce.repository;

import com.pvanquochuy.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
