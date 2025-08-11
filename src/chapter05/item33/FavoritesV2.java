package chapter05.item33;

import java.util.*;

public class FavoritesV2 {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    //33-4
    //동적 형변환으로 런타임 타입 안전성 확보
    //202P
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        FavoritesV2 f = new FavoritesV2();
        
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, FavoritesV2.class);
       
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}