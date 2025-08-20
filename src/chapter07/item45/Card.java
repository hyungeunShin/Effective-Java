package chapter07.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
                       EIGHT, NINE, TEN, JACK, QUEEN, KING }

    private final Suit suit;
    private final Rank rank;

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private static final List<Card> NEW_DECK_V1 = newDeckV1();
    private static final List<Card> NEW_DECK_V2 = newDeckV2();

    //45-4
    //데카르트 곱 계산을 반복 방식으로 구현
    //275P
    private static List<Card> newDeckV1() {
        List<Card> result = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    //45-5
    //데카르트 곱 계산을 스트림 방식으로 구현
    //276P
    private static List<Card> newDeckV2() {
        return Stream.of(Suit.values())
                     .flatMap(suit -> Stream.of(Rank.values()).map(rank -> new Card(suit, rank)))
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK_V1);
        System.out.println(NEW_DECK_V2);
    }
}