import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SystemInfoTest {
    private SystemInfo systemInfo;

    @BeforeEach
    public void setUp() {
        systemInfo = new SystemInfo();
    }

    @Test
    public void testGetNumberOfCPUs() {
        int cpuCount = systemInfo.getNumberOfCPUs();
        assertTrue(cpuCount > 0, "The number of CPUs should be greater than zero.");
    }

    @Test
    public void testGetSystemInfo() {
        String info = systemInfo.getSystemInfo();
        assertNotNull(info, "System information should not be null.");
        assertTrue(info.contains("Architecture: "), "System info should include architecture.");
        assertTrue(info.contains("Total Memory: "), "System info should include total memory.");
    }

    @Test
    public void testCanAllocateMemory() {
        boolean canAllocate = systemInfo.canAllocateMemory(1); // Checking for 1 MB
        assertTrue(canAllocate, "System should be able to allocate 1 MB of memory.");
    }
}