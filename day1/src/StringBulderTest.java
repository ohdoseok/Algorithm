
public class StringBulderTest {
	public static void main(String[] args) {
		String s = "s";
		
		int a = 10;
		a = a + 19; //연산자
		
		s += "afy" + 3 + true + 'c' +4.5; //String 클래스  연산자 => 메소드 변환
		//계속해서 new StringBuilder하는것!!!!
		
		
		StringBuffer sb = new StringBuffer();// 새로운 객체를 생성하지않는다.원래 string에 변경
		sb.append("afy");
		sb.append(3);
		s = sb.toString();// 이렇게 만드는게 좋음!!
		
		
		
		
		String k = "k";
		k = k + "j";
		k = new StringBuffer(k).append("j").toString();
		//k.concat() 은 메모리 누수가 심함
		
		System.out.println(s);
	}
}
