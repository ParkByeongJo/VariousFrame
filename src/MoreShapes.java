import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

class MyPanel extends JPanel{
	ArrayList<Shape> shapeArray=new ArrayList<Shape>();//���� �迭�� �÷����� ������ ArrayList�� ����Ͽ� Shape��ü���� ����
	
	public MyPanel() {
		Shape s;
		
		s=new Rectangle2D.Float(10, 10, 70, 80);//�簢���� ��Ÿ���� ��ü�� �����Ͽ� �迭�� �߰�
		shapeArray.add(s);
		
		s=new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);//�ձ� �簢�� ����
		shapeArray.add(s);
		
		s=new Ellipse2D.Float(210, 10, 80, 80);//Ÿ��
		shapeArray.add(s);
		
		s=new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);//��ȣ
		shapeArray.add(s);
		
		s=new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);//��ȣ
		shapeArray.add(s);
		
		s=new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);//��ȣ
		shapeArray.add(s);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		//��Ƽ���ϸ������ ������ �Ų����� �׸��� ���Ͽ� �����Ѵ�. ���� �ð��� ���� �� �ɸ����� �׸�ŭ �׷����� ǰ���� ��������.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));//������ �׸��� �β��� ����
		for(Shape s:shapeArray)//�迭�� ����� Shape��ü���� ������ ȭ�鿡 �׸���.
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
