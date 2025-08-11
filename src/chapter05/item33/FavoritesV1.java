package chapter05.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FavoritesV1 {
    //33-1
    //타입 안전 이종 컨테이너 패턴 - API
    //199P
//    public <T> void putFavorite(Class<T> type, T instance);
//    public <T> T getFavorite(Class<T> type);

    //33-3
    //타입 안전 이종 컨테이너 패턴 - 구현
    //200P
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    //33-2
    //타입 안전 이종 컨테이너 패턴 - 클라이언트
    //199P
    public static void main(String[] args) {
        FavoritesV1 f = new FavoritesV1();
        
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, FavoritesV1.class);
       
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}