package simple.test.rpctest.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import simple.test.rpctest.common.Des;
import simple.test.rpctest.table.SystemBaseModel;

/**
 * The Class Org.
 */
@Entity
@Table(name = "s_org")
//@Cacheable
@Des("组织")
public class Org extends SystemBaseModel {	
	
	/** The org name. */
	@Des("组织名称")
	@Column(length = 100)
	private String	orgName;
	
	/** The org code. */
	@Des("组织代码")
	@Column(length = 50)
	private String orgCode	;
	
	/** The order num. */
	@Des("排序值")
	private int orderNum;

	/** The des. */
	@Des("描述")
	@Column(length = 500)
	private String des;
	
	/** The parent. */
	@ManyToOne
	@Des("父组织对象")
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private  Org parent;
	
	/** The actived. */
	@Des("是否激活")
	private boolean actived;
	
	/** The child. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	@OrderBy("orderNum asc")
	@Des("子组织对象们")
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Org> child;

	/**
	 * Gets the org name.
	 *
	 * @return the org name
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * Sets the org name.
	 *
	 * @param orgName the new org name
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * Gets the org code.
	 *
	 * @return the org code
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * Sets the org code.
	 *
	 * @param orgCode the new org code
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * Gets the order num.
	 *
	 * @return the order num
	 */
	public int getOrderNum() {
		return orderNum;
	}

	/**
	 * Sets the order num.
	 *
	 * @param orderNum the new order num
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * Gets the des.
	 *
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * Sets the des.
	 *
	 * @param des the new des
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Org getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Org parent) {
		this.parent = parent;
	}

	/**
	 * Gets the child.
	 *
	 * @return the child
	 */
	public List<Org> getChild() {
		return child;
	}

	/**
	 * Sets the child.
	 *
	 * @param child the new child
	 */
	public void setChild(List<Org> child) {
		this.child = child;
	}


	/**
	 * Checks if is actived.
	 *
	 * @return true, if is actived
	 */
	public boolean isActived() {
		return actived;
	}

	/**
	 * Sets the actived.
	 *
	 * @param actived the new actived
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
}
