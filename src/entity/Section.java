package entity;

import entity.enums.Role;
import entity.enums.SectionState;

import java.util.List;
import java.util.UUID;

public class Section {
    private String id = UUID.randomUUID().toString();
    private String name;
    private List<Book> books;
    private SectionState status = SectionState.ENABLED;


    public Section() {
    }

    public Section(String id, String name, List<Book> books, SectionState status) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public SectionState getStatus() {
        return status;
    }

    public void setStatus(SectionState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
    public String toString(User user) {
            if(user.getRole().equals(Role.USER)) {
                return "Section{" +
                        "id='" + id + '\'' +
                        ", name='" + name +
                        '}';
            }
            return "Section{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", status=" + status +
                    '}';
    }
}


