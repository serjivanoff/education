package jdbc.executor.dataset;

public class UserDataSet extends DataSet {
    private String name;
    private int age;

    public UserDataSet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDataSet(long id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDataSet)) return false;

        UserDataSet that = (UserDataSet) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null &&
                getId() == that.getId();
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
