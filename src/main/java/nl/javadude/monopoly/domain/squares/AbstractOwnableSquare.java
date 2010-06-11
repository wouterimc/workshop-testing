package nl.javadude.monopoly.domain.squares;

import nl.javadude.monopoly.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public abstract class AbstractOwnableSquare extends AbstractSquare implements IOwnable, IAutomatic {
	private static final Logger LOGGER = LoggerFactory.getLogger(Realty.class);
	protected long cost;
	protected Player owner;

	public AbstractOwnableSquare(String name, long cost) {
		super(name);
		this.cost = cost;
	}

	public long getCost() {
		return cost;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * Pay the rent to the owner of this square.
	 * @param player
	 */
	public void execute(Player player) {
		if (owner != null && !owner.equals(player)) {
			long rent = getRent();
			player.pay(rent, owner);
			LOGGER.info("Player {} paid {} rent to {}", new Object[] {player, rent, owner});
		}
	}

	public boolean isUnowned() {
		return owner == null;
	}
	
	public boolean canBuy() {
		return isUnowned();
	}
	
	public Player getOwner() {
		return owner;
	}
}
