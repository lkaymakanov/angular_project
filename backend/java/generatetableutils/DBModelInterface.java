package generatetableutils;


interface DBModelInterface {
	
	//construct the models
	public abstract String getJavaModel();
	public abstract String getJavaModelInsert();
	public abstract String getJavaModelUpdate();
	public abstract String getJavaModelDelete();
	
	public abstract boolean isValidModel();
	public abstract void initModel(Table t, boolean useSequence);
	public abstract void save();
}
