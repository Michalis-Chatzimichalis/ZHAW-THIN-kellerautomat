package ch.zhaw.it.thin.kellerautomat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Kellerautomat kellerautomat = new Kellerautomat();
        //kellerautomat.calculate(true, "39+42+82+49+**+"); // accepted with result 792
        kellerautomat.calculate(false, "23+12+327+2524++6*+++++"); // accepted with result 88
        kellerautomat.calculate(true, "6 4 + *"); // discarded
        //kellerautomat.calculate(false, "2 * 9 + 7 * 3 * "); // discarded
    }
}
