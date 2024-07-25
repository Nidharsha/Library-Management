package com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.springboot.entity.MemberShip;

import jakarta.transaction.Transactional;

public interface MemberShipRepo extends JpaRepository<MemberShip,String>{
    
    @Modifying
    @Transactional
    @Query(value = "SELECT * from member_ship where status=?1", nativeQuery = true)
    public List<MemberShip> getPendingMembership(String status);
}
