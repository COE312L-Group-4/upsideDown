package scene1;
import scene2.*;

import java.awt.*;  
import javax.swing.JFrame;
import scene2.*;

public class MyCanvas extends Canvas{
	String imagepath;
	
	
	public MyCanvas(String imagepath) {
		this.imagepath = imagepath;
	}


	public void paint(Graphics g) {  
		  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(imagepath);  
        g.drawImage(i, 0,0,this);
          
    }
}
