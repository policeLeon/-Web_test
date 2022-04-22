package pojo;

public class s_school {
      private int id;
      private String school_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String toString(){
        return "id="+id+",schoolname="+school_name ;
    }
}
