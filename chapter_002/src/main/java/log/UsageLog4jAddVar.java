package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jAddVar {
    public static final Logger LOG = LoggerFactory.getLogger(UsageLog4jAddVar.class.getName());

    public static void main(String[] args) {
        String name = "Vitaly";
        int age = 44;
        boolean married = true;
        float weight = 120f;
        short higt = 180;
        double  bankAccauntBalance = 2000000000;
        long bankAccaunt = 260000848;
        char scoolClass = '8';
        LOG.debug("User info name : {}, age : {}, married : {}, weight : {},"
                + " higt : {}, bankAccaunt : {}, bankAccauntBalance : {}, scoolClass : {}",
                name, age, married, weight, higt, bankAccaunt, bankAccauntBalance, scoolClass);
    }

}
