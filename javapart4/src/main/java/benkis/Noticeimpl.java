package benkis;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Noticeimpl implements Notice {
    private int USERID;
    private String PASSWORD;
    private String USERNAME;


    public Connection connection() {
        String url = "jdbc:mysql://localhost:3306/Notice";
        String user = "root";
        String password = "akdptmzbdpf10299!!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(int USERID, String PASSWORD, int AGE, String USERNAME, String PHONE) {
        String query = "INSERT INTO USER (USERID, PASSWORD, AGE, USERNAME, PHONE) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            preparedStatement.setInt(1, USERID);
            preparedStatement.setString(2, PASSWORD);
            preparedStatement.setInt(3, AGE);
            preparedStatement.setString(4, USERNAME);
            preparedStatement.setString(5, PHONE);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(int NUMBER, String TITLE, String NEONG, String DATE) {
        String query = "INSERT INTO Content (NUMBER, TITLE, NEONG, DATE) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            preparedStatement.setInt(1, NUMBER);
            preparedStatement.setString(2, TITLE);
            preparedStatement.setString(3, NEONG);
            preparedStatement.setString(4, DATE);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



        @Override
        public int printMenu() {
            Scanner sc = new Scanner(System.in);
            System.out.println("---공지---");
            System.out.println("[1]로그인 [2]회원가입 [3]글 목록 보기");
            System.out.println("[4]글 등록 [5]글 수정 [6]글 삭제");
            System.out.println("[7]로그아웃 [8]회원 탈퇴 [9]프로그램 종료");
            return sc.nextInt();
        }


        @Override
        public void signup() {
            Scanner sc = new Scanner(System.in);
            System.out.println("아이디를 입력해주세요");
            int userid = sc.nextInt();
            System.out.println("비밀번호를 입력해주세요");
            String password = sc.next();
            System.out.println("이름을 입력해주세요");
            String username = sc.next();
            System.out.println("나이를 입력해주세요");
            int age = sc.nextInt();
            System.out.println("번호를 입력해주세요");
            String phone = sc.next();
            USERID += userid;
            PASSWORD += password;
            USERNAME = username;


            System.out.println("회원가입에 성공하였습니다.");
            insertData(userid, password, age, username, phone);

        }

        @Override
        public void login() {
            Scanner sc = new Scanner(System.in);
            System.out.println("아이디를 입력해주세요");
            int userid = sc.nextInt();
            System.out.println("비밀번호를 입력해주세요");
            String password = sc.next();


            if (userid == USERID) {
                if (password.equals(password)) {
                    System.out.println(USERNAME + " 로그인에 성공하였습니다.");
                }
            } else {
                System.out.println("다시 하십시오");
            }
        }

        @Override
        public void riwrite() {
            if (USERID != 0) {
                Scanner sc = new Scanner(System.in);
                System.out.println("몇번째 책갈피인가요");
                int number = sc.nextInt();
                System.out.println("제목을 정해주세요");
                String title = sc.next();
                System.out.println("내용을 적어주세요");
                String neong = sc.next();
                String date = getNowDateTime();
                insertData(number, title, neong, date);
            } else {
                return;
            }
        }

        public String getNowDateTime() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.now().format(formatter);
        }

    @Override
    public void showall() {
        String query = "SELECT NUMBER, TITLE, NEONG, DATE FROM Content";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int NUMBER = resultSet.getInt("NUMBER");
                String TITLE = resultSet.getString("TITLE");
                String NEONG = resultSet.getString("NEONG");
                String DATE = resultSet.getString("DATE");

                System.out.println(NUMBER + " : " + TITLE + " : " + NEONG + " : " + DATE);
                System.out.println("============================");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

