package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collectibles;
	private int counter;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.counter = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (this.counter == this.collectibles.length) {
			Collectible[] newCollectibles = new Collectible[2 * this.collectibles.length];
			for (int j = 0; j < this.counter; j++) {
				newCollectibles[j] = this.collectibles[j];
			}
			this.collectibles = newCollectibles;
		}
		this.collectibles[this.counter] = collectible;
		this.counter++;
	}

	@Override
	public float getTotalWeight() {
		float sumWeights = 0;
		for (int i = 0; i < this.counter; i++) {
			sumWeights += this.collectibles[i].getWeight();
		}
		return sumWeights;
	}

	@Override
	public int getCurrentCount() {
		return this.counter;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return this.collectibles;
	}
}
