package model.handlerInterface;

import java.util.List;

import model.bean.Owner;

public interface OwnerHandlerInterface {
	public int addOwner(Owner owner);
	public boolean isMatch(String username, String password);
	public void updateOwner(Owner owner);
	
	// not listed
	public Owner getOwnerById(int id);
	public List<Owner> getAllOwners();
	public boolean isExist(int id);
	public boolean isExist(String username);
	
	
}
