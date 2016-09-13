package cs544.exercise5_1;

public class InventoryService implements IInvertoryService {

	public InventoryService() {
		// TODO Auto-generated constructor stub
	}

	public int getNumberInStock(int productNumber) {
		return productNumber-200;
		}


}
