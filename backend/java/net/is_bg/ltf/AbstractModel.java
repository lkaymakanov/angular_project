package net.is_bg.ltf;

import net.is_bg.ltf.db.common.interfaces.IAbstractModel;

public class AbstractModel implements IAbstractModel {
	private long id;
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
