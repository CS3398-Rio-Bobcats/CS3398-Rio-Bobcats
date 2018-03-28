package ButtonPanel;

/**
 *
 * @author Ayisha Sowkathali
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Class CustomFormatter overrides the format method of the superclass Formatter
 * in order to format the Logger output when writing to a file to a readable
 * format (as opposed to the default XML format)
 */
class CustomFormatter extends Formatter {

    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

    /**
     * format() method overrides the superclass's method in order to obtain a
     * much simpler output
     *
     * @param record refers to the LogRecord to change
     * @return builder.toString(), the String which will be the new format for
     * each log event
     */
    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        builder.append("[").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append("] :");
        builder.append("\n");
        builder.append("\t[").append(record.getLevel()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public String getHead(Handler h) {
        return super.getHead(h);
    }

    @Override
    public String getTail(Handler h) {
        return super.getTail(h);
    }
}
