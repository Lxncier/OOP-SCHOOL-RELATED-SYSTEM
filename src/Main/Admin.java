package Main;

class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
