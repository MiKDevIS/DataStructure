import java.util.*;

public class PrefixStatement {
    List<String> strArray = new ArrayList<String>();
    List<String> resultArray = new ArrayList<String>();
    int isIn = 0;
    int flag = 0;
    int counter = 0;
    int resultArraySize = 0;

    public PrefixStatement(String str) {
        arrayBuilder(str);
        prefixStatmentBuilder();
        print();
    }

    public PrefixStatement(Scanner input) {
        this(input.nextLine());
    }

    private void prefixStatmentBuilder() {
        for (int i = 0; i < strArray.size(); i++) {
            String t = strArray.get(i);
            if (t != "") {
                if (t.equals("(")) {
                    isIn++;
                } else if (t.equals(")")) {
                    isIn--;
                } else if (t.equals("+") || t.equals("-")) {
                    counter++;
                    if (isIn > 0) {
                        popTilFlagThenPush(i);
                    } else {
                        flag += counter;
                        counter = 0;
                        popTilFirstThenPush(i);
                    }
                } else if (t.equals("/") || t.equals("*") || t.equals("^")) {
                    counter++;
                    popTilFlagThenPush(i);
                } else {
                    counter++;
                    resultArray.add(strArray.get(i));
                    resultArraySize++;
                }
            }
        }
    }

    private void popTilFlagThenPush(int i) {
        List<String> tempArray = new ArrayList<String>();
        for (int j = flag; j < resultArraySize; j++) {
            tempArray.add(resultArray.get(j));
        }
        for (int j = flag; j < resultArraySize; j++) {
            resultArray.remove(flag);
        }
        resultArray.add(strArray.get(i));
        resultArraySize++;
        for (int j = 0; j < tempArray.size(); j++) {
            resultArray.add(tempArray.get(j));
        }
    }

    private void popTilFirstThenPush(int i) {
        List<String> tempArray = new ArrayList<String>();
        for (int j = 0; j < resultArraySize; j++) {
            tempArray.add(resultArray.get(j));
        }
        for (int j = 0; j < resultArraySize; j++) {
            resultArray.remove(0);
        }
        resultArray.add(strArray.get(i));
        resultArraySize++;
        for (int j = 0; j < tempArray.size(); j++) {
            resultArray.add(tempArray.get(j));
        }
    }

    private void arrayBuilder(String str) {
        String tempStr = "";
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (str.charAt(i) != ' ')
                if (t == '+' || t == '-' || t == '/' || t == '*' || t == '^' || t == '(' || t == ')') {
                    strArray.add(tempStr);
                    strArray.add("" + t);
                    tempStr = "";
                } else
                    tempStr += t;
            if (i == str.length() - 1) {
                strArray.add(tempStr);
            }
        }
    }

    public void print() {
        for (int i = 0; i < resultArray.size() - 1; i++) {
            System.out.print(resultArray.get(i) + ",");
        }
        System.out.print(resultArray.get(resultArray.size() - 1));
    }
}

class PrefixStatementMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your normal statment???\t");
        PrefixStatement ps = new PrefixStatement(input);
    }
}