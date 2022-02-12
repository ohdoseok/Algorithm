import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;

public class DataInputOutputTest2 {

    public static void main(String[] args) throws Exception {
        int a = 123456;  //4
        // 100    101    102    103 ==> 리틀 엔디언 OS
        // 103    102    101    100 ==> 빅 엔디언 
        // A     B     C     D
        // D    C    B    A
        //송신용
//        byte[] arr = intToByteArray(a);
        byte[] arr = BigInteger.valueOf(a).toByteArray();
        //수신용
        int newA = new BigInteger(arr).intValue();
//        int newA = byteArrayToInt(arr);
        
        
        System.out.println(newA);
//        int => byteArray
//        byteArray => int
        
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("a.dat")); //통신
        dos.writeInt(a);
        
        DataInputStream dis = new DataInputStream(new FileInputStream("a.dat"));
        
        
        
        System.out.println("end");

    }
    // A(3)     B(2)     C(1)     D(0) => 리틀
    private static int byteArrayToInt(byte[] arr) {
//0        ?     ?    ?    D
//1        0    0    C
//2        0    B
//3        A
//        A     B    C    D
//        비트단위로  |
//        0 | 1| 2 | 3
//        ???????? ? ?     10101010
//        00000000 0 0     11111111
//    &    00000000 0 0    10101010
//        
        int num = (arr[0]  & 0xff) | 
                  ((arr[1] & 0xff) <<8) | 
                  ((arr[2] & 0xff) <<16) | 
                  ((arr[3] & 0xff) <<24) ;
        
//        int num = (arr[3]& 0xff) | 
//                  ((arr[2] & 0xff)<<8) | 
//                  ((arr[1] & 0xff)<<16) | 
//                  ((arr[0] & 0xff)<<24) ;
        return num;
    }
    // A(3)     B(2)     C(1)     D(0) => 리틀
    // A(0)     B(1)     C(2)     D(3) => 엔
    private static byte[] intToByteArray(int a) {
        byte[] arr = new byte[4];
        
        // ABCD
        arr[0] = (byte)a;
        // ABCD => 8비트 이동  0ABC
        arr[1] = (byte)(a>>8);
        arr[2] = (byte)(a>>16);
        arr[3] = (byte)(a>>24);
        
//        arr[3] = (byte)a;
//        // ABCD => 8비트 이동  0ABC
//        arr[2] = (byte)(a>>8);
//        arr[1] = (byte)(a>>16);
//        arr[0] = (byte)(a>>24);
        return arr;
    }

}