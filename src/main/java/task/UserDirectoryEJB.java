package task;

import javax.ejb.Stateless;
import java.io.File;

@Stateless
public class UserDirectoryEJB {
    public String getString() {
        String s88 = File.separator;
        File dir = new File("D:" + s88 + "Обучение" + s88 + "workinstudy"
                + s88 + "test5" + s88 + "testTwoJavaEE");
        String s = "";
        String z = "---";
        return recursivePass(z, s, dir);
    }

    public static String recursivePass(String z, String s, File dir) {
        File[] files = dir.listFiles();
        s += ("<p>" + z + "{" + dir.getName() + "}" + "</p>");
        for (File file : files) {
            if (file.isFile()) {
                String st = z + "------/";
                s += ("<p>" + st  + "{" + file.getName() + "}" +  "</p>");
            } else {
                s = recursivePass(z + "------/", s, file);
            }
        }
        return s;
    }
}
