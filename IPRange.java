import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex-notebook on 22.10.2016.
 */
public class IPRange {

    public static void main(String args[])
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            IPRange ipRange = new IPRange(); 
            System.out.println("Введите два  IP адреса");

            String ipInput1 = input.readLine();
            long ip1 = ipRange.convertIpToLong(ipInput1);
            String ipInput2 = input.readLine();
            long ip2 = ipRange.convertIpToLong(ipInput2);

            if (ip1 > ip2)
            {
                long l = ip1;
                ip1 = ip2;
                ip2 = l;
            }

            System.out.println("Диапазон адресов:");
            for (long i = ip1+1; i < ip2; i++)
            {
                System.out.println(ipRange.convertLongToIp(i));
            }
            
        } catch (WrongIPException ee) {System.out.println("The IP is incorrect");}
        catch (IOException e) {System.out.println("An error with input occured");}
          

    }

    long convertIpToLong(String ip) throws WrongIPException
    {
        Pattern p = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
        Matcher m = p.matcher(ip);
        if ((ip == null) || !m.matches()) throw new WrongIPException();
        long result = 0;
        String[] ipStringArray = ip.split("\\.");
        int[] ipArray = new int[ipStringArray.length];
        for (int i = 0; i < 4; i++)
        {
            ipArray[i] = Integer.parseInt(ipStringArray[i]);
        }
        result = (long)( ipArray[0]*Math.pow(256,3)
                + ipArray[1]*Math.pow(256,2)
                + ipArray[2]*Math.pow(256,1)
                + ipArray[3]*Math.pow(256,0));
        return  result;
    }

    String convertLongToIp(long ip)
    {
        if (ip < 0) throw new IllegalArgumentException();
        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }

}
