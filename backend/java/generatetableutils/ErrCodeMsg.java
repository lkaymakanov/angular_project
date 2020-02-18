package generatetableutils;


class ErrCodeMsg {
	public enum ERRCODE {OK, ERR};
	private ERRCODE  err = ERRCODE.OK;
	private String errMsg = "";
	
	
	public void reportErr(Exception e){
		err = ERRCODE.ERR;
		errMsg += e.getMessage();
	}


	public ERRCODE getErr() {
		return err;
	}


	public String getErrMsg() {
		return errMsg;
	}
	
}
