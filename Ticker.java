import java.net.URL;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Ticker
{
	String name;
     double holdings;
	String api;
	String[][] b = new String [10][2];

	public Ticker(String linx, String n, double h) throws Exception
	{	
		name = n;
		holdings = h;
		api = linx;
		b = makeArray(getAPI(api));
	}

		
	public String getAPI(String url) throws Exception
	{
		
		StringBuilder sb = new StringBuilder();
		String s;

		Scanner sc = new Scanner(new URL(url).openStream());
		s = sc.nextLine();
		return s;
	}

	public String[][] makeArray(String str)
	{
		String[][] ticks = new String[10][2];
		int i = 0;
		StringTokenizer st = new StringTokenizer(str, "\",\":");
		for(int z = 0; z <3; z++)
		st.nextToken();

		while(st.hasMoreTokens())
		{
		
			ticks[i][0] = st.nextToken();
			ticks[i][1] = st.nextToken();
			i++;
		}

		
		return ticks;
	}

	public double getPrice()
	{
		return Double.parseDouble(b[7][1]);
	}

	public double makeCash()
	{
		double price = Double.parseDouble(b[7][1]);
		double scrill = price * holdings;
		return scrill;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("<html><table border=5>");
		for(int i = 0; i < 8; i++)
		{
			s.append("<tr><td width=150 >").append(b[i][0]).append("</td><td width=150>").append(b[i][1]).append("</td></tr>");
		}
		
		DecimalFormat quatDec = new DecimalFormat("##.0000");
		s.append("<tr style='color: blue;'><td>").append(name).append(" $ = ").append(quatDec.format(makeCash())).append("</td></tr></table></html>");

		return s.toString();
	}

}
