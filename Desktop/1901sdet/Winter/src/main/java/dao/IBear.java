package dao;

import entity.Bear;

public interface IBear {

	public Bear getBear(int id);
	public boolean deleteBear(Bear id);
	public boolean createBear(Bear bear);
	public boolean updateOrCreateBear(Bear bear);
	
}
