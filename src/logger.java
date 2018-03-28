import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Ayisha Sowkathali
 */
public class logger extends JFrame {
//public class logger {   
    protected static Logger logger = Logger.getLogger(ButtonPanel.class.getName());
    protected static FileHandler fh;

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * @param aLogger the logger to set
     */
    public static void setLogger(Logger aLogger) {
        logger = aLogger;
    }

    /**
     * @return the file handler "fh"
     */
    public static FileHandler getFh() {
        return fh;
    }

    /**
     * @param aFh the fh to set
     */
    public static void setFh(FileHandler aFh) {
        fh = aFh;
    }

    public logger() {
    }

    public logger(String title) {
        super(title);
    }

    /**
     * initLogger() method initializes the Logger environment for the class upon
     * call
     */
    protected void initLogger() {
        getLogger().setUseParentHandlers(false);
        CustomFormatter formatter = new CustomFormatter();
        try {
            setFh(new FileHandler("log.txt"));
            getFh().setFormatter(formatter);
            getLogger().addHandler(getFh());
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "FileHandler threw IOException", e);
        }
    }
    
}
