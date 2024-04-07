import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        //준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        String input = br.readLine();

        //풀이
        new Main().solution();

        //출력

        //정리
        bw.flush();
        br.close();
        bw.close();
    }

    public void solution() {

    }
}
