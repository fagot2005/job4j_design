package socket;

import log.UsageLog4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class EchoServer {
    private static final String hi = "HELLO";
    private static final String exit = "EXIT";
    private static final Pattern DATA_PATTERN = Pattern.compile(".+\\?msg=.+ HTTP/1.1");
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str != null && DATA_PATTERN.matcher(str).matches())  {
                        String argument = str.substring(str.lastIndexOf('=') + 1, str.indexOf(' '));
                        String answer = hi.equalsIgnoreCase(argument) ? hi : argument;
                        if (exit.equalsIgnoreCase(answer)) {
                            answer = "Server stoped!";
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(answer.getBytes());
                        if (exit.equalsIgnoreCase(argument)) {
                            server.close();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("ERROR", e);
        }
    }
}

