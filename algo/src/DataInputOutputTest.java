import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DataInputOutputTest {
	public static void main(String[] args) throws Exception {//그냥 던지기
		int a = 10;	//4byte
		int b = 20;	//출력 4byte
		char ch = 'A';//65
		double c = 1.23;
		//Data Input/Output Stream
		
		double bb = 3.4;
		
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("a.dat"));
		//dos.writeInt(a); //4byte
		dos.writeDouble(c); //8byte
//		dos.flush();
//		dos.close();
//		System.out.println("end");
		
		DataInputStream dis = new DataInputStream(new FileInputStream("a.dat"));
//		System.out.println(dis.readDouble());//무조건 8byte읽어온다
		System.out.println(dis.readInt());
		
		
		InputStreamReader rsr = new InputStreamReader(new FileInputStream("a.dat"),"utf-8");
	}
}
