import java.net.URL;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.text.DecimalFormat;

public class BtcBasedTicker extends Ticker
{
	private double btcPrice;
	private double coinPrice;
	
	public BtcBasedTicker(String linx, String n, double h, double btcP) throws Exception
	{	
		super(linx, n, h);
		btcPrice = btcP;
	}

	private double coinWorth()
	{
		return btcPrice * coinPrice;
	}

	public double makeCash()
	{
		double scrill = coinPrice * holdings * btcPrice;
		return scrill;
	}

	public String toString()
	{
		coinPrice = Double.parseDouble(b[7][1]);

		StringBuilder s = new StringBuilder();
          s.append("<html><table border=5>");
		for(int i = 0; i < 8; i++)
		{
			s.append("<tr><td width=150>").append(b[i][0]).append("</td><td width=150>").append(b[i][1]).append("</td></tr>");
		}
		DecimalFormat sixDec = new DecimalFormat("##.0000");
		s.append("<tr><td>").append(name).append(" USD $ = ").append(sixDec.format(coinWorth())).append("</td></tr>");
		s.append("<tr style='color: blue;'><td>").append(name).append(" $    = ").append(sixDec.format(makeCash())).append("</td></tr></table></html>");

		return s.toString();
	}




}
