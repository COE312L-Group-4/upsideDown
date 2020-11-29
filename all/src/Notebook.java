import java.io.*;

public class Notebook extends Object {

	
    PrintWriter out ;
    FileReader fr;

	public Notebook(BufferedWriter bw,FileReader fr) {
		super();
		out= new PrintWriter(bw);
		this.fr=fr;
	}

	public void write(String s) throws IOException
	{
		out.write(s);
		out.flush();
	}
	public void read() throws IOException
	{
		int i;
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
	}
	

	@Override
	public void use(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}
	

}
