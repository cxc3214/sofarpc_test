package simple.test.rpctest.table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import simple.test.rpctest.common.Des;


// TODO: Auto-generated Javadoc
/**
 * The Class UUIDModel.
 */
@MappedSuperclass
public abstract class UUIDModel extends Model<String> {
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2402690499830913377L;
	
	/** The id. */
	@Id
    @Column(length=36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @Des("编号")
	protected String id;

	/* (non-Javadoc)
	 * @see simple.system.simpleweb.platform.model.IdKeyModel#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	

}
