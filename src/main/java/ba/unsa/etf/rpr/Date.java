package ba.unsa.etf.rpr;

/**
 *Class Date represents an ordinary date in our lifes
 */

public class Date implements Comparable{
    int[] months;
    private int day;
    private int month;
    private int year;
    {
        months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public Date(int day, int month, int year) throws IllegalArgumentException{
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    public int getDay() {
        return day;
    }

    /**
     * Method that sets the day
     * @param day an integer
     * @throws IllegalArgumentException if day is illegal
     */
    public void setDay(int day) throws IllegalArgumentException{
        if(day<1 || day>months[month-1])
            throw new IllegalArgumentException("The day" + day + "is not valid");
        this.day=day;
    }

    public int getMonth() {
        return month;
    }

    /**
     * Methods that sets the month
     * @param month an integer
     * @throws IllegalArgumentException if month is illegal
     */
    public void setMonth(int month) throws IllegalArgumentException{
        if(month<1 || month>12)
            throw new IllegalArgumentException("The month" + month + "is not valid!");
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Metohds that sets the year
     * @param year int
     * @throws IllegalArgumentException if ar is less than one
     */
    public void setYear(int year) throws IllegalArgumentException{
        if (year<1)
            throw new IllegalArgumentException("The year" + year + "is not valid!");
        if(checkIfTrespassing(year))
            months[1]=29;
        this.year = year;
    }

    public Date yesterday() throws IllegalArgumentException{
        if (day == 1 && month == 1) return new Date(31,12,year-1);
        if (day == 1) return new Date(months[month-2],month-1,year);
        return new Date(day-1,month,year);
    }

    public Date tomorrow(){
        if(day == 31 && month == 12) return new Date(1,1,year + 1);
        if(day == months[month-1]) return new Date(1,month+1,year);
        return new Date (day+1,month,year);
    }

    public boolean checkIfTrespassing(int year) {
        return (year%4==0 && year%100!=0) || (year%400==0);
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Date){
            Date d = (Date)o;
            //if(this.equals(o)) return 0;
            if(this.getYear()!=d.getYear()) return this.getYear()-d.getYear();
            if(this.getYear() == d.getYear() && this.getMonth() != d.getMonth()) return this.getMonth()-d.getMonth();
            if(this.getYear() == d.getYear() && this.getMonth() == d.getMonth()) return this.getDay()-d.getDay();
        }
        return 1;
    }

    /**
     * Function that counts the number of days that have passed between two dates
     * @param d1 date
     * @param d2 date
     * @return number of days
     */
    static int getNumberOfDaysBetween(Date d1, Date d2){
        Date max,min;
        if(d1.compareTo(d2)==0)
            return 0;
        else if (d1.compareTo(d2)>0) {
            max = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
            min= new Date(d2.getDay(),d2.getMonth(),d2.getYear());
        } else {
            max = new Date(d2.getDay(), d2.getMonth(), d2.getYear());
            min = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
        }
        int days;
        for(days = 0; !max.equals(min); days= days + 1, max = max.yesterday());

        return days;
    }
}

