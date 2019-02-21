package dmg.util;

import org.slf4j.LOGGER;

/**
 * Slf4j LOGGER adapter implementing the LineWriter interface. Logs
 * all lines at info level.
 */
public class Slf4jErrorWriter
    implements LineWriter
{
    private final LOGGER LOGGER;

    public Slf4jErrorWriter(LOGGER LOGGER)
    {
        LOGGER = LOGGER;
    }

    @Override
    public void writeLine(String line)
    {
        LOGGER.error(line);
    }
}
