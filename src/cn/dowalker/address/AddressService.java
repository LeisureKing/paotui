package cn.dowalker.address;


import java.util.List;

import cn.dowalker.bean.Address;

public class AddressService {
	AddressDao addressDao = new AddressDao();
	public void addAddress(Address address){
		addressDao.addAddress(address);
	}
	
	public Address findByAddressById(String id) {
		return addressDao.findByAddressById(id);
	}
	
	public List<Address> finAllAddress(String uid) {
		return addressDao.finAllAddress(uid);
	}

	public void deleteAddress(String id) {
		addressDao.deleteAddress(id);
	}
}
