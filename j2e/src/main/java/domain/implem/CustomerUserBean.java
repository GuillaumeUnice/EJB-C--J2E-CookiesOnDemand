package domain.implem;

import domain.CustomerUserManager;
import entities.CustomerUser;
import entities.Shop;
import entities.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class CustomerUserBean extends UserManagerBean implements CustomerUserManager {

	@Override
	public void changeloyaltyProgram(CustomerUser user, boolean loyalty) {
		user.setLoyaltyProgram(loyalty);
		entityManager.merge(user);
	}

	@Override
	public void changeloyaltyProgram(String email, boolean loyalty) {
		CustomerUser user = (CustomerUser) entityManager
				.find(User.class, email);
		changeloyaltyProgram(user, loyalty);
	}

	@Override
	public void changeGiftCardCredit(CustomerUser user, double gift) {
		user.setGiftCardCredit(gift);
		entityManager.merge(user);
	}

	@Override
	public void changeGiftCardCredit(String email, double gift) {
		CustomerUser user = (CustomerUser) entityManager
				.find(User.class, email);
		changeGiftCardCredit(user, gift);
	}

	@Override
	public void changePreferateShop(CustomerUser user, Shop preferate) {
		user.setFavouriteShop(preferate);
		entityManager.merge(user);
	}
	/**
	 * @param email String email de l'utilisateur client c'est son identifiant
	 * @param preferate Shop magasin
	 */
	@Override
	public void changePreferateShop(String email, Shop preferate) {
		CustomerUser user = (CustomerUser) entityManager.find(User.class, email);
		changePreferateShop(user, preferate);
	}
	/**
	 * Recuperer l'ensemble des CustomerUser
	 * @return List<CustomerUser> retourne la liste des utilisateurs clients
	 */
	@Override
	public List<CustomerUser> findAllCustomerUsers() {
		List<User> users = findAll();
		List<CustomerUser> customers = new ArrayList<CustomerUser>();
		for (User u : users)
			if (u instanceof CustomerUser)
				customers.add((CustomerUser) u);
		return customers;
	}

	@Override
	public void changeCreditCard(String email, Long creditCard) {
		CustomerUser cu = (CustomerUser)entityManager.find(User.class,email);
		changeCreditCard(cu,creditCard);
	}

	@Override
	public void changeCreditCard(CustomerUser user, Long creditCard) {
		user.setCreditCard(creditCard);
		entityManager.merge(user);
	}

}