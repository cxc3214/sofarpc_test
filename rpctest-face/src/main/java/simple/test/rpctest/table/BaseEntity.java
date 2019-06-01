package simple.test.rpctest.table;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import simple.test.rpctest.common.Des;


@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable, IdKeyModel<K> {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	// geter and seter
	/** The deleted. */
	@Des("是否删除")
	protected Boolean deleted =false;

	/**
	 * Gets the deleted.
	 * 
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 * 
	 * @param deleted
	 *            the new deleted
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        BaseEntity<K> model = (BaseEntity<K>) obj;
        return model.getId() == this.getId();
    }

    @Override
    public int hashCode() {
    	return super.hashCode();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override  
    public String toString() {
        return this.getClass().getName() + " [ID=" + this.getId() + "]";
    }
    
}
