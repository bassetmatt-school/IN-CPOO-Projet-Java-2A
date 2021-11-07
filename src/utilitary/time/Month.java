package utilitary.time;

public enum Month{
    JANUARY   ( 0,31, 31),
    FEBRUARY  ( 1,28, 59),
    MARCH     ( 2,31, 90),
    APRIL     ( 3,30,120),
    MAY       ( 4,31,151),
    JUNE      ( 5,30,181),
    JULY      ( 6,31,212),
    AUGUST    ( 7,31,243),
    SEPTEMBER ( 8,30,273),
    OCTOBER   ( 9,31,304),
    NOVEMBER  (10,30,334),
    DECEMBER  (11,31,365);

    private final int number;
    private final int length;
    private final int lengthCum;

    private Month(int number, int length, int lengthCum) {
        this.number = number;
        this.length = length;
        this.lengthCum = lengthCum;
    }

    
    public int getNumber() {
        return number;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getLengthCum() {
        return lengthCum;
    }

    public static Month numberToMonth(int num) throws IllegalArgumentException {
        Month month;
        switch (num) {
        case 0 :
            month = JANUARY  ;
            break;
        case 1 :
            month = FEBRUARY ;
            break;
        case 2 :
            month = MARCH    ;
            break;
        case 3 :
            month = APRIL    ;
            break;
        case 4 :
            month = MAY      ;
            break;
        case 5 :
            month = JUNE     ;
            break;
        case 6 :
            month = JULY     ;
            break;
        case 7 :
            month = AUGUST   ;
            break;
        case 8 :
            month = SEPTEMBER;
            break;
        case 9 :
            month = OCTOBER  ;
            break;
        case 10 :
            month = NOVEMBER ;
            break;
        case 11 :
            month = DECEMBER ;
            break;
        default :
            throw new IllegalArgumentException("Number must be between 0 and 11");
        }
        return month;
    }

    public static Month dayToMonth(int day) throws IllegalArgumentException{
        if (day < 0) {
            throw new IllegalArgumentException("Day must be positive");
        } else if (day < JANUARY.lengthCum) {
            return JANUARY;
        } else if (day < FEBRUARY.lengthCum) {
                return FEBRUARY;
        } else if (day < MARCH.lengthCum) {
                return MARCH;
        } else if (day < APRIL.lengthCum) {
                return APRIL;
        } else if (day < MAY.lengthCum) {
                return MAY;
        } else if (day < JUNE.lengthCum) {
                return JUNE;
        } else if (day < JULY.lengthCum) {
                return JULY;
        } else if (day < AUGUST.lengthCum) {
                return AUGUST;
        } else if (day < SEPTEMBER.lengthCum) {
                return SEPTEMBER;
        } else if (day < OCTOBER.lengthCum) {
                return OCTOBER;
        } else if (day < NOVEMBER.lengthCum) {
                return NOVEMBER;
        } else if (day < DECEMBER.lengthCum) {
                return DECEMBER;
        } else {
            throw new IllegalArgumentException("Day must be inferior to 365");
        }
    }
    
}










