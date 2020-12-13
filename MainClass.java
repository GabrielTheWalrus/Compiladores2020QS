import java.util.Scanner;
public class MainClass{ 
	public static void main(String args[]){
 	Scanner _key = new Scanner(System.in);
	double a;
	double b;
	double c;
	double d;
	String e;
	e = "a";
	a = 0.56;
	b = 2;
	c = a+b*c;
	System.out.println("Programa Teste");
	System.out.println("Digite A");
	a= _key.nextDouble();
	System.out.println("Digite B");
	b= _key.nextDouble();
	if (a==b) {
	c = a+b;}else {
	c = a-b;}

	System.out.println("C e igual a ");
	System.out.println(a);
	d = c*a+b;
	System.out.println("D e igual a ");
	System.out.println(d);
	while (a<d) {
a = a+1;}
	for (a=1; a<=b; a=a+1) {
	b = a;
	}
  }
}
