import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemInfo {

    /**
     * Returns the number of available CPUs on the machine.
     *
     * @return the number of CPUs
     */
    public int getNumberOfCPUs() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Gets the system architecture and total memory in megabytes.
     *
     * @return a string containing the system architecture and total memory
     */
    public String getSystemInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long totalMemoryInMB = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        return "Architecture: " + osBean.getArch() + ", Total Memory: " + totalMemoryInMB + " MB";
    }

    /**
     * Determines whether the system has enough memory to allocate the specified number of megabytes.
     *
     * @param memoryInMB the amount of memory in megabytes to check
     * @return true if the system can allocate the specified memory, false otherwise
     */
    public boolean canAllocateMemory(int memoryInMB) {
        long availableMemoryInMB = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        return availableMemoryInMB >= memoryInMB;
    }
}