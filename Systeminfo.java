mport java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * A utility class to provide system-related information and memory management.
 * This class includes methods to:
 * - Retrieve the number of CPUs on the machine.
 * - Retrieve the system architecture and total memory.
 * - Check if the system can allocate a specified amount of memory.
 * 
 * The class uses Java's Runtime and ManagementFactory for system information.
 */
public class SystemInfo {

    /**
     * Retrieves the number of available CPUs on the current machine.
     *
     * @return the number of available processors (CPUs) as an integer.
     */
    public int getNumberOfCPUs() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Gets the system architecture and the total memory available to the JVM in megabytes.
     *
     * @return a string containing the system architecture and total memory in MB.
     * The format is: "Architecture: [arch], Total Memory: [memory] MB".
     */
    public String getSystemInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        long totalMemoryInMB = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        return "Architecture: " + osBean.getArch() + ", Total Memory: " + totalMemoryInMB + " MB";
    }

    /**
     * Determines if the system has enough free memory to allocate a specified number of megabytes.
     *
     * @param memoryInMB the amount of memory to allocate, in megabytes.
     * @return {@code true} if the system has enough free memory to allocate the specified amount;
     *         {@code false} otherwise.
     */
    public boolean canAllocateMemory(int memoryInMB) {
        long availableMemoryInMB = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        return availableMemoryInMB >= memoryInMB;
    }
}