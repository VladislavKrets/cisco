package org.cisco;


import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        if (args.length == 0) return;
        switch (args[0]) {
            case "add":
                addNewQuestions();
                break;
            case "test_all":
                testAll();
                break;
            case "test_v4_1":
                testV4N1();
                break;
            case "test_v4_2":
                testV4N2();
                break;
            case "test_v4_3":
                testV4N3();
                break;
            case "test_v4_4":
                testV4N4();
                break;
            case "test_v4_5":
                testV4N5();
                break;
            case "test_v4_6":
                testV4N6();
                break;
            case "test_v4_7":
                testV4N7();
                break;
            case "test_v4_8":
                testV4N8();
                break;
            case "test_v4_9":
                testV4N9();
                break;
            case "test_v4_10":
                testV4N10();
                break;
            case "test_v4_11":
                testV4N11();
                break;
            case "test_v4_12":
                testV4N12();
                break;
            case "test_v4_13":
                testV4N13();
                break;
            case "test_v4_14":
                testV4N14();
                break;
            case "test_v4_15":
                testV4N15();
                break;
            case "test_v4_16":
                testV4N16();
                break;
            case "test_v4_final":
                testV4NFinal();
                break;

        }

    }

    public static void addNewQuestions() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet resultSet;
        BufferedReader reader = new BufferedReader(new FileReader("exams_en"));
        String line;
        boolean isQuestion = true;
        int id = 0;

        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                isQuestion = true;
                continue;
            }
            if (isQuestion) {
                statement.execute(String.format("insert into \'questions\' (\'text\') values (\"%s\");", line));
                resultSet = statement.executeQuery("select last_insert_rowid();");
                System.out.println(resultSet.next());
                id = resultSet.getInt(1);
                isQuestion = false;
                continue;
            } else {
                if (line.endsWith(" - TRUE")) {
                    statement.execute(String.format("insert into \'answers\' (\'question_id\', \'text\', \'is_true\') values (%d, \"%s\", %d);",
                            id, line.replaceAll(" - TRUE", ""), 1));
                } else {
                    statement.execute(String.format("insert into \'answers\' (\'question_id\', \'text\', \'is_true\') values (%d, \"%s\", %d);",
                            id, line, 0));
                }
            }
        }
        statement.close();
    }
    public static void testV4NFinal() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 568 and id <= 627");
        test(questionSet);
    }
    public static void testV4N16() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 548 and id <= 567");
        test(questionSet);
    }

    public static void testV4N15() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 528 and id <= 547");
        test(questionSet);
    }

    public static void testV4N14() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 508 and id <= 527");
        test(questionSet);
    }

    public static void testV4N13() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 489 and id <= 507");
        test(questionSet);
    }

    public static void testV4N12() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 447 and id <= 488");
        test(questionSet);
    }

    public static void testV4N11() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 406 and id <= 446");
        test(questionSet);
    }

    public static void testV4N10() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 364 and id <= 405");
        test(questionSet);
    }

    public static void testV4N9() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 323 and id <= 363");
        test(questionSet);
    }

    public static void testV4N8() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 282 and id <= 322");
        test(questionSet);
    }

    public static void testV4N7() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 241 and id <= 281");
        test(questionSet);
    }

    public static void testV4N6() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 202 and id <= 240");
        test(questionSet);
    }

    public static void testV4N5() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 160 and id <= 201");
        test(questionSet);
    }

    public static void testV4N4() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 138 and id <= 159");
        test(questionSet);
    }

    public static void testV4N3() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 101 and id <= 137");
        test(questionSet);
    }

    public static void testV4N2() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 68 and id <= 100");
        test(questionSet);
    }

    public static void testV4N1() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions where id >= 36 and id <= 67");
        test(questionSet);
    }

    public static void testAll() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:exams");
        statement = connection.createStatement();
        ResultSet questionSet = statement.executeQuery("select * from questions");
        test(questionSet);
    }

    public static void test(ResultSet questionSet) throws IOException, SQLException {
        ResultSet answerSet;
        String question;
        List<Answer> answers = new ArrayList<>();
        String numbers;
        String[] splittedNumbers;
        List<Integer> correctNumbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ;
        while (questionSet.next()) {
            question = questionSet.getString("text");
            answerSet = connection.createStatement().executeQuery(String.format("select * from answers where question_id=%d",
                    questionSet.getInt("id")));
            while (answerSet.next()) {
                answers.add(new Answer(answerSet.getString("text"), answerSet.getInt("is_true")));
            }
            System.out.println(question);
            for (int i = 0; i < answers.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, answers.get(i).getText());
                if (answers.get(i).getIsTrue() == 1) {
                    correctNumbers.add(i);
                }
            }
            numbers = reader.readLine();
            while (true) {
                if (numbers.equalsIgnoreCase("ru")) {
                    try {
                        System.out.println(GoogleTranslate.translate("en", "ru", question));
                        for (int i = 0; i < answers.size(); i++) {
                            System.out.printf("%d) %s%n", i + 1, GoogleTranslate.translate("en", "ru", answers.get(i).getText()));
                        }
                    } catch (IOException e) {
                        System.out.println("Network error");
                    }
                    numbers = reader.readLine();
                    continue;
                }
                if (numbers.matches("\\d( \\d)*")) break;
                System.out.println("Wrong number format, reenter your answer");
                numbers = reader.readLine();
            }
            splittedNumbers = numbers.split(" ");
            if (splittedNumbers.length != correctNumbers.size()) {
                wrongAnswerReact(correctNumbers);
            } else {
                for (String s : splittedNumbers) {
                    if (answers.get(Integer.parseInt(s) - 1).isTrue != 1) {
                        wrongAnswerReact(correctNumbers);
                        break;
                    }
                }
            }
            System.out.println("OK");
            System.out.println("Press enter to continue:");
            answers.clear();
            correctNumbers.clear();
            reader.readLine();
        }
        statement.close();
        System.out.println("This is the end of exam");
        System.out.println("Press enter to close");
        reader.readLine();
    }

    public static void wrongAnswerReact(List<Integer> correctNumbers) {
        System.out.println();
        System.out.println("Wrong answer");
        System.out.print("Correct answers are: ");
        for (Integer i : correctNumbers) {
            System.out.print(i + 1);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static class Answer {
        private String text;
        private Integer isTrue;

        public Answer(String text, Integer isTrue) {
            this.text = text;
            this.isTrue = isTrue;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getIsTrue() {
            return isTrue;
        }

        public void setIsTrue(Integer isTrue) {
            this.isTrue = isTrue;
        }
    }
}
