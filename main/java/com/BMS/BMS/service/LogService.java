package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Log;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import java.io.File;
import java.io.IOException;
import java.lang.StackWalker.Option;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 4/7/2021.
 */
@Service
public class LogService {
  private static final Logger logger = LoggerFactory.getLogger(LogService.class);
  private UserRepository userRepository;

  @Value("${logs.info.logs}")
  private boolean saveInfoLogs;

  @Value("${logs.error.logs}")
  private boolean saveErrorLogs;

  @Value("${logs.db.logs}")
  private boolean saveDbLogs;

  public LogService(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void infoLog(String text){
    if(saveInfoLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Info", className, text);
    }
  }

  public void infoLog(String userId, String text){
    if(saveInfoLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Info", userId, className, text);
    }
  }

  public void dbLog(String text){
    if(saveDbLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Database", className, text);
    }
  }

  public void dbLog(String userId, String text){
    if(saveDbLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Database", userId, className, text);
    }
  }

  public void errorLog(String text){
    if(saveErrorLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Error", className, text);
    }
  }
  public void errorLog(String userId, String text){
    if(saveErrorLogs){
      String className = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName() + ".java";
      newLog("Error", userId, className, text);
    }
  }

  private void newLog(String type, String className, String text){
    new Thread(() -> addNewLog(new Log(type, className, text).toString())).start();
  }

  private void newLog(String type, String userId, String className, String text){
    new Thread(() -> addNewLog(new Log(type, userId, className, text, userRepository.findUserById(userId).getDisplayName()).toString())).start();
  }

  private void addNewLog(String newLog){
    Path logFile = createLogFile();
    if (Objects.nonNull(logFile)){
      writeLog(newLog, logFile);
    }
  }

  private Path createLogFile() {
    try{
      Date currentDate = new Date();
      String currentDateAsString = new SimpleDateFormat("dd").format(new Date());
      String fileName = currentDateAsString + "_" + getDayOfWeek(currentDate) + ".txt";
      String mainPath = "C:\\Users\\Ron.Gines\\Documents\\blackwater-logs";
      String yearPath = mainPath + "\\" + Year.now().getValue();
      String fullPath = yearPath + "\\" + YearMonth.now().getMonth();

      createDirectory(mainPath);
      createDirectory(yearPath);
      createDirectory(fullPath);

      String filePath = fullPath + "\\" + fileName;
      File file = new File(filePath);
      file.createNewFile();

      return Paths.get(filePath);
    } catch (Exception e) {
      logger.error("Error creating directory or file: " + e.toString());
      return null;
    }
  }

  private String getDayOfWeek(Date currentDate){
    DateFormat formatter = new SimpleDateFormat("EEEE");
    return formatter.format(currentDate);
  }

  private void createDirectory(String path){
    File newFolder = new File(path);
    newFolder.mkdir();
  }

  private void writeLog(String newLog, Path logFile){
    try{
      Files.write(logFile, newLog.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException ioException){
      logger.error("Failed writing log to file: " + ioException.toString());
    }
  }
}
