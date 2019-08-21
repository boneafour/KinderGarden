package com.example.kindergarden3.Database;

public class ShortInfoData {

	int _id;
	String _stReg;
	String _stMKR;
	String _stNameKG;
	String _stAdress;

	public ShortInfoData(){
	}

	public ShortInfoData(String _stReg, String _stMKR, String _stNameKG, String _stAdress){
		this._stReg = _stReg;
		this._stMKR = _stMKR;
		this._stNameKG = _stNameKG;
		this._stAdress = _stAdress;
	}

	public int getShortInfoID(){
		return this._id;
	}
	public void setShortInfoID(int id){
		this._id = id;
	}

	public String getShortInfoReg(){
		return this._stReg;
	}
	public void setShortInfoReg(String _stReg){
		this._stReg = _stReg;
	}

	public String getShortInfoMKR(){
		return this._stMKR;	}
	public void setShortInfoMKR(String _stMKR){
		this._stMKR = _stMKR;
	}

	public String getShortInfoName(){
		return this._stNameKG;	}
	public void setShortInfoName(String _stNameKG){
		this._stNameKG = _stNameKG;
	}

	public String getShortInfoAdress(){
		return this._stAdress;	}
	public void setShortInfoAdress(String _stAdress){
		this._stAdress = _stAdress;
	}
}
