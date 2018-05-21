package by.nc.school.dev.example.spring.data.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Mark {

    @Column(name = "mark")
    private int mark;

    private Mark() {}

    public Mark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        return mark == mark1.mark;
    }

    @Override
    public int hashCode() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
