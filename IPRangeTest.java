import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPRangeTest {

    private IPRange ipRange;

    @Before
    public void init() { ipRange = new IPRange(); }

    @Test
    public void testConvertIpToLong() throws Exception {
        assertEquals("тест не пройден",ipRange.convertIpToLong("192.168.0.1"), 3232235521L);
        assertEquals("тест не пройден",ipRange.convertIpToLong("192.168.0.5"), 3232235525L);
    }

    @Test
    public void testConvertLongToIp() throws Exception {
        assertEquals(ipRange.convertLongToIp(3232235521L), "192.168.0.1");
        assertEquals(ipRange.convertLongToIp(3232235525L), "192.168.0.5");
    }

}
