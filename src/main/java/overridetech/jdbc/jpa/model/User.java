package overridetech.jdbc.jpa.model;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
//специальный класс, объекты которого нужно хранить в базе данных.
@Table(name = "users")
//С ее помощью можно задать имя таблицы в базе, с которой будет связан данный класс
public class User {

    @Id
    //С ее помощью можно задать первичный ключ для таблицы.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //чтобы Hibernate самостоятельно генерировал ID твоих объектов при добавлении их в базу
    //IDENTITY при вставке сущности в таблицу - выдается id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return  "\n" +
                "User: " + "id = " + id + ", " +
                "name = " + name  + ", " +
                "lastName = " + lastName + ", " +
                "age = " + age;
    }
}
