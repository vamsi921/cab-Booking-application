package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.IAdminDao;
import com.cg.mts.Entity.Admin;
import java.util.Optional;

@Repository("aDao")
public interface IAdminRepository extends IAdminDao, JpaRepository<Admin, Integer>{
//	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1"
//	public Optional<Admin> findByUsername(String username);
}
