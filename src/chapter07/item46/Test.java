package chapter07.item46;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {
    static class Album {
        private final String artist;
        private final int sales;

        public Album(String artist, int sales) {
            this.artist = artist;
            this.sales = sales;
        }

        public String getArtist() {
            return artist;
        }

        public int getSales() {
            return sales;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "artist='" + artist + '\'' +
                    ", sales=" + sales +
                    '}';
        }
    }

    public static void main(String[] args) {
        Album album1 = new Album("jake", 100);
        Album album2 = new Album("jake", 250);
        Album album3 = new Album("jack", 990);
        Album album4 = new Album("jack", 140);

        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);

        Map<String, Album> topHits = albums.stream()
                                           .collect(Collectors.toMap(Album::getArtist, a -> a, BinaryOperator.maxBy(Comparator.comparing(Album::getSales))));

        System.out.println("topHits = " + topHits);
    }
}
