package levelset.gui.Wrappers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Logging {

    public static Logger logger = Logger.getLogger(Logging.class.getName());
    public static String logFileName;
    private static FileHandler fileHandler = null;
    //static Logger globalLogger = Logger.getLogger("global");
    static {
        createNewLog();
      /*  Handler[] handlers ;//= globalLogger.getHandlers();
       /* for(Handler handler : handlers){
            globalLogger.removeHandler(handler);
        //}
        handlers = logger.getHandlers();

        for(Handler handler : handlers){
            logger.removeHandler(handler);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-M-y  HH-mm-ss");
        try{
            Logging.logFileName= "Logs/" + simpleDateFormat.format(Calendar.getInstance().getTime()) + ".log";
            fileHandler = new FileHandler(logFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        Logging.logger.addHandler(fileHandler);
        Logging.logger.setUseParentHandlers(false);
        BriefLogFormatter.init();*/
    }

    public static void createNewLog(){
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers){
            logger.removeHandler(handler);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-M-y  HH-mm-ss");
        try{
            Logging.logFileName= "Logs/" + simpleDateFormat.format(Calendar.getInstance().getTime()) + ".log";
            fileHandler = new FileHandler(logFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        Logging.logger.addHandler(fileHandler);
        Logging.logger.setUseParentHandlers(false);
        logger.info("Marium Ashraf");
        logger.warning("");
        logger.severe("");
       // BriefLogFormatter.init();
    }

    public static void logError(Exception e){
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.severe("Error: " + stringWriter.toString());
        Logging.reportError(stringWriter.toString());
    }

    public static void reportError(String error){
        logger.severe(error);
        //SendEmail.sendTheLog(error);
    }
}
