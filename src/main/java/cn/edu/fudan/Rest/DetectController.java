package cn.edu.fudan.Rest;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by FengSi on 2017/06/06 at 16:06.
 */
@RestController
public class DetectController {

    @RequestMapping("/detect")
    public void detect(@RequestParam(value = "table") String table, @RequestParam(value = "type") String type,
                       @RequestParam(value = "left") String left, @RequestParam(value = "right") String right) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession("root", "10.141.209.110", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("LAB205*");
            session.connect();
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand("source /etc/profile\n " +
                    "spark-submit " +
                    "--master spark://10.141.220.81:7077 " +
                    "--class cn.edu.fudan.WordCount " +
                    "/opt/SparkLearning-1.0-SNAPSHOT-shaded.jar");
            channelExec.setInputStream(null);
            channelExec.setErrStream(System.err);
            channelExec.connect();
            InputStream in = channelExec.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                System.out.println(buf);
            }
            reader.close();
            channelExec.disconnect();
            session.disconnect();
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(table + " " + type + " " + left + " " + right);
    }
}
