package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
