package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 31, nullable = false)
    @NotNull
    private String name;

    public Position() {
    }

    public int getId() {
        return id;
    }

    public Position setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return id.equals(position.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Position setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
