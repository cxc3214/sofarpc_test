package simple.test.rpctest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.test.rpctest.entity.Org;

public interface OrgDao extends JpaRepository<Org, Long>{
	
}
