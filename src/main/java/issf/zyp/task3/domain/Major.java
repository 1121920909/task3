package issf.zyp.task3.domain;

/**
 * @author ZYP
 */
public class Major {
  private int id;
  private String name;
  private String college;

  public Major() {
  }

  @Override
  public String toString() {
    return "Major{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", college='" + college + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }
}
