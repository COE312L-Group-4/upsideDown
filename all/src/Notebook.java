import java.io.*;

public class Notebook{

	
    PrintWriter out ;
    BufferedReader br;

	public Notebook(BufferedWriter bw,FileReader fr) {
		super();
		out= new PrintWriter(bw);
		br=new BufferedReader(fr);
	}

	public void write(String s) throws IOException
	{
		out.write(s);
		out.flush();
	}
	public void read() throws IOException
	{
		int i;
		br.mark(25);
		while((i=br.read())!=-1)
		{
			System.out.print((char)i);
		}
		System.out.println("\n");
		br.reset();
	}
	

}
