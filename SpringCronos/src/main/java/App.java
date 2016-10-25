import eas.com.spring.AppConfig;
import eas.com.spring.FileInputStep;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 10/24/2016.
 */
public class App {


    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //Load the spring configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Retrieve bean from container
        FileInputStep fileInputStep = context.getBean("fileInputStep", FileInputStep.class);

        //Use the bean
        System.out.println("Step Name: " + fileInputStep.getName() + " Time: " + sdf.format(new Date()));

        System.out.println("Separator: " + fileInputStep.getSeparatorContentFile().getValue() + " Time: " + sdf.format(new Date()));

        System.out.println("File: " + fileInputStep.getFileInput().getName() + ". Time: " + sdf.format(new Date()));

        System.out.println("File Description: " + fileInputStep.getFileInput().getDescription() + " Time: " + sdf.format(new Date()));

        System.out.println("File Encoder: " + fileInputStep.getFileInput().getFileEncoder().getName() + " Time: " + sdf.format(new Date()));


        //Close the container
        context.close();


    }
}
