package sofka.co;

public class getCategoria {

    private String name;

    public getCategoria(){
    }

    public getCategoria(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }
}