package model.handlerinterface;

import java.util.List;

import model.bean.Owner;

public interface OwnerHandlerInterface {
	public int addOwner(Owner owner);
	
	
	// not listed
	public Owner getOwner(int id);
	public List<Owner> getAllOwners();
	public boolean isExist(int id);
	public boolean isExist(String username);
	public boolean isExist(String username, String password);
	public void updateOwner(Owner owner);
}
