package chapter06.item35;

//35-1
//ordinal을 잘못 사용한 예 - 따라 하지 말 것!
//221P
public enum EnsembleV1 {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}