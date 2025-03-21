package MVC.modelo;

public class Login {
    private int id;
    private String user;
    private String password;
    private String role;

    public Login() {}

    public Login(int id) {
        this.id = id;
    }

    public Login(int id, String user, String password, String role) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
