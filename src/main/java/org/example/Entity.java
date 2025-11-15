import java.util.Objects;

public class Entity {
    // كل الكائنات تعتمد على نوعها فقط، الإحداثيات داخل Square
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        return this.getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }
}




