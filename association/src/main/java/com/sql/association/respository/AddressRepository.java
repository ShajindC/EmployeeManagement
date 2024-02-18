package com.sql.association.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.association.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
