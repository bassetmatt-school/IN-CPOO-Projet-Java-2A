package utilitary;

public enum Month{
    JANUARY   (31,  0),
    FEBRUARY  (28,  1),
    MARCH     (31,  2),
    APRIL     (30,  3),
    MAY       (31,  4),
    JUNE      (30,  5),
    JULY      (31,  6),
    AUGUST    (31,  7),
    SEPTEMBER (30,  8),
    OCTOBER   (31,  9),
    NOVEMBER  (30, 10),
    DECEMBER  (31, 11);

    private final int length;
    private final int number;

    private Month(int length, int number) {
        this.length = length;
        this.number = number;
    }

    
}
