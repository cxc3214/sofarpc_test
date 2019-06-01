package simple.test.rpctest.table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import simple.test.rpctest.common.Des;


// TODO: Auto-generated Javadoc
/**
 * The Class AutoIDModel.
 */
@MappedSuperclass
public abstract class AutoIDModel extends Model<Long> {
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -68272959986217391L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)  
	@Des("编号")
	protected Long id;
	
	/* (non-Javadoc)
	 * @see simple.system.simpleweb.platform.model.IdKeyModel#getId()
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}	

}
