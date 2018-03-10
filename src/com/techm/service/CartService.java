package com.techm.service;

import java.util.ArrayList;

import com.techm.bean.MedicineBean;
import com.techm.dao.SearchDao;

public class CartService {

	
	private static ArrayList<MedicineBean> items;

	public CartService(){
	    items = new ArrayList<MedicineBean>();
	}

	public void insert(MedicineBean mb){
	    items.add(mb);
	}

	public void remove(MedicineBean mb){
	    //items.removeAll(items);
	    items.clear();
	}

	public int getSize(){
	    return items.size();
	}

	public ArrayList<MedicineBean> getIt(){
	    return items;
	}

	

	
}