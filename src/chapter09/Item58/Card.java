package chapter09.Item58;

import java.util.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        //58-4
        //버그를 찾아보자. - for문 안에 i.next()를 주목, 이 next()는 Suit 하나당 한 번씩만 불려야 하는데, 안쪽 반복문에서 호출되는 바람에 Rank 하나당 한번 씩 호출된다.
        //348P
//        for(Iterator<Suit> i = suits.iterator(); i.hasNext();) {
//            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
//                deck.add(new Card(i.next(), j.next()));
//            }
//        }

        //58-6
        //문제는 고쳤지만 보기 좋진 않다. 더 나은 방법이 있다!
        //349P
        for(Iterator<Suit> i = suits.iterator(); i.hasNext();) {
            Suit suit = i.next();
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
                deck.add(new Card(suit, j.next()));
            }
        }

        //58-7
        //컬렉션이나 배열의 중첩 반복을 위한 권장 관용구
        //349P
        for(Suit suit : suits) {
            for(Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }
}