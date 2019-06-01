package simple.test.rpctest.table;

import javax.persistence.MappedSuperclass;

/**
 * 系统管理使用 ID自增列作为主键
 * 使用逻辑删除 逻辑删除的字段为 deleted.
 *
 * @author cxc
 */
@MappedSuperclass
public abstract class SystemBaseModel  extends AutoIDModel {

	
}
