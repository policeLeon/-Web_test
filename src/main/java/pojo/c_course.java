package pojo;

public class c_course {

    private int id ;
    private String name ;
    private int hours ;
    private int sid ;

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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
//    public void Course(int id ,String name ,int hours ,int sid){
//        this.id =
//    }
    public String toString(){
        return "id=" +id+ ",name=" +name+ ",hours=" +hours+ ",sid=" +sid;
    }
}
