package ch.zhaw.it.thin.kellerautomat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Kellerautomat kellerautomat = new Kellerautomat();
        kellerautomat.calculate(true, "34+62+89+43+***"); //6664
        kellerautomat.calculate(true, "31+78+987+1214++7++++++"); //58
        kellerautomat.calculate(true, "9"); // 9
        kellerautomat.calculate(true, "11+"); // 2
        kellerautomat.calculate(true, "11+11++"); // 4
        kellerautomat.calculate(true, "111++"); // 3
        kellerautomat.calculate(true, "1111*++"); // 3
        kellerautomat.calculate(true, "34+*"); //Invalid
        kellerautomat.calculate(true, "8+9+7*2*"); //Invalid
        kellerautomat.calculate(true, "11+11+"); //Invalid
        kellerautomat.calculate(true, "1*1"); //Invalid
        kellerautomat.calculate(true, "+11"); //Invalid
    }
}
