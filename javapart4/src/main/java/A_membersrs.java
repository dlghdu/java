
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class A_membersrs {

    public Connection connection()  {
        String url = "jdbc:mysql://localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conn Success!");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("hwaion gam rei");
        System.out.println("[1]join [2]log-in [3]jong-ro");
        System.out.println("would you choose what?");
        return sc.nextInt();
    }

    public void joinmembers(String userid, String password, String name, int age, String phone) {
        String query = "INSERT INTO members(userid, password, name, age, phone) VALUES(?,?,?,?,?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            preparedStatement.setString(1, userid);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, phone);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert Success!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(String userid, String password, String name, int age, String phone) {
        Scanner sc = new Scanner(System.in);
        System.out.println("your id and password");
        String useridd = sc.nextLine();
        String passwordd = sc.nextLine();
        if ( useridd.equals(userid) && passwordd.equals(password)) {
            System.out.println("WELCOME!" + name + " age : " + age + " phone : " + phone);
        }
    }

    public static void main(String[] args) {
        A_membersrs a = new A_membersrs();

        while (true) {
            int menunu = a.printMenu();
            switch (menunu) {
                case 1:
                    a.joinmembers("gogogo","mimi11", "sam", 11, "010-1234-5678");
                    break;
                case 2:
                    a.login("gogogo","mimi11", "sam", 11, "010-1234-5678");
                    break;
                case 3:
                    System.out.println("bie-bye-pi-pie");
                    return;
            }
        }
    }
}
