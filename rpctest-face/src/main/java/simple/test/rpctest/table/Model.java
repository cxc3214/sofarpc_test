package simple.test.rpctest.table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import simple.test.rpctest.common.Des;



/**
 * 所有基础模型的基类 提供了 id updateTime createTime version 四个字段.
 * 
 * @author Administrator
 * @param <ID>
 *            the generic type
 */
@MappedSuperclass
public abstract class Model<ID> extends BaseEntity<ID> {


	/** The Constant serialVersionUID. */
	@Transient
	// 不被序列化
	private static final long serialVersionUID = 4356379855403575219L;

	/** The create time. */
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Des("创建时间")
	protected Date createTime;

	/** The update time. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@Des("上一次更新时间")
	protected Date updateTime;

	/** The version. */
	@Version
	@Des("更新次数")
	protected Integer version = 0;

	/**
	 * Sets the creates the time.
	 * 
	 * @param createTime
	 *            the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the update time.
	 * 
	 * @return the update time
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * Sets the update time.
	 * 
	 * @param updateTime
	 *            the new update time
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Gets the version.
	 * 
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the new version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * On create.
	 */
	@PrePersist
	protected void onCreate() {
		createTime = updateTime = new Date();
		deleted = false;
	}

	/**
	 * On update.
	 */
	@PreUpdate
	protected void onUpdate() {
		updateTime = new Date();
	}

}
