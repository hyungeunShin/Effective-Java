package chapter12.item87;

import java.io.Serializable;
import java.util.Objects;

//87-1
//기본 직렬화 형태에 적합한 후보
//459P ~ 460P
public class Name implements Serializable {
    /**
     * 성. null이 아니어야 함
     * @serial
     */
    private final String lastName;

    /**
     * 이름. null이 아니어야 함
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름. 중간이름이 없다면 null
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.middleName = middleName;
    }
}
