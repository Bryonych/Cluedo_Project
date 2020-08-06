import java.util.*;

public class Suggestion extends Tuple {
	int playerNo;
	CharacterCard suspect;
	WeaponCard weapon;
	RoomCard crimeScene;
	//list of suggestion cards so that subsequent players can compare with their hand
	List<Card> suggestionCards = new ArrayList<Card>();
	
	public Suggestion(int playerNo, CharacterCard sCharacter, WeaponCard sWeapon, RoomCard sRoom) {
		super(sCharacter, sWeapon, sRoom);
		this.playerNo = playerNo;
		suspect = sCharacter;
		weapon = sWeapon;
		crimeScene = sRoom;
		suggestionCards.add(suspect);
		suggestionCards.add(weapon);
		suggestionCards.add(crimeScene);
	}
	
	public String toString() {
		return "Player " + playerNo + " made the suggestion:\n" + suspect.getName() + ", in the " + crimeScene.getName() +", with the " + weapon.getName();
	}
	
	public List<Card> getCards(){
		return suggestionCards;
	}
	
}
