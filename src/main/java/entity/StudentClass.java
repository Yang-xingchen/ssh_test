package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class StudentClass {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "c_name", length = 31)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class")
    private Set<Student> students;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "college")
    private College college;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headmaster")
    private Teacher headmaster;

    public College getCollege() {
        return college;
    }

    public StudentClass setCollege(College college) {
        this.college = college;
        return this;
    }

    public Teacher getHeadmaster() {
        return headmaster;
    }

    public StudentClass setHeadmaster(Teacher headmaster) {
        this.headmaster = headmaster;
        return this;
    }

    public StudentClass() {
    }

    public int getId() {
        return id;
    }

    public StudentClass setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentClass setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public StudentClass setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
