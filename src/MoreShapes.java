import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

class MyPanel extends JPanel{
	ArrayList<Shape> shapeArray=new ArrayList<Shape>();//향상된 배열인 컬렉션의 일종인 ArrayList를 사용하여 Shape객체들을 생성
	
	public MyPanel() {
		Shape s;
		
		s=new Rectangle2D.Float(10, 10, 70, 80);//사각형을 나타내는 객체를 생성하여 배열에 추가
		shapeArray.add(s);
		
		s=new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);//둥근 사각형 생성
		shapeArray.add(s);
		
		s=new Ellipse2D.Float(210, 10, 80, 80);//타원
		shapeArray.add(s);
		
		s=new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);//원호
		shapeArray.add(s);
		
		s=new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);//원호
		shapeArray.add(s);
		
		s=new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);//원호
		shapeArray.add(s);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		//엔티에일리어싱은 도형을 매끄럽게 그리기 위하여 생성한다. 연산 시간은 조금 더 걸리지만 그만큼 그래픽의 품질이 좋아진다.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));//도형을 그리는 두께를 설정
		for(Shape s:shapeArray)//배열에 저장된 Shape객체들을 꺼내서 화면에 그린다.
			g2.draw(s);
	}
}
public class MoreShapes extends JFrame {
	
	public MoreShapes() {
		this.setSize(600, 130);
		this.setTitle("Java 2D Shapes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new MyPanel();
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MoreShapes();

	}

}
