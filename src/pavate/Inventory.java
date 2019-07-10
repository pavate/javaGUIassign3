package pavate;

/**
 * @author acer
 */
class Inventory {

	private String id;
	private int qoh;
	private int rop;
	private double sellPrice;
	private String name;

	public Inventory() {
		// TODO - implement Inventory.Inventory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param sellPrice
	 */
	public Inventory(String id, String name, double sellPrice) {
		
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param qoh
	 * @param rop
	 * @param sellPrice
	 */
	public Inventory(String id, String name, int qoh, int rop, double sellPrice) {
		
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public int getQoh() {
		return this.qoh;
	}

	/**
	 * 
	 * @param qoh
	 */
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	public int getRop() {
		return this.rop;
	}

	/**
	 * 
	 * @param rop
	 */
	public void setRop(int rop) {
		this.rop = rop;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	/**
	 * 
	 * @param price
	 */
	public void setSellPrice(double price) {
		this.sellPrice = price;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override()
	public String toString() {
		// TODO - implement Inventory.toString
		throw new UnsupportedOperationException();
	}

}