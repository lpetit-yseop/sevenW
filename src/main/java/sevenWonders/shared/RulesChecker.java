package sevenWonders.shared;

import java.util.Map.Entry;

import sevenWonders.core.gameElements.Board;
import sevenWonders.core.gameElements.Card;
import sevenWonders.core.gameElements.Resource;

public class RulesChecker {
	public static boolean isPlayable(Card playerCard, Board board, String language) {
		return checkCost(playerCard, board) && checkName(playerCard, board, language);
	}

	private static boolean checkName(Card playerCard, Board board, String language) {
		String cardName = playerCard.getName(language);
		for (Card card : board.getPlayedCards()) {
			if (cardName.equals(card.getName(language))) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCost(Card playerCard, Board board) {
		for (Entry<Resource, Integer> costPerResource: playerCard.getCost().entrySet()) {
			Resource costResource = costPerResource.getKey();
			Integer costForResource = costPerResource.getValue();
			
			Integer playersAmountForResource = board.getResources().get(costResource);
			if (costForResource > playersAmountForResource) {
				return false;
			}
		}
		return true;
	}
}
