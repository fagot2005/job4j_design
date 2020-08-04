package inputoutput;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ConditionFactory {
    public static Predicate<Path> newConditions(ArgFoundFileParam argFoundFileParam) {
        String mask = argFoundFileParam.mask().toLowerCase();
        Predicate<Path> result = p -> true;
        if (mask.startsWith("m")) {
            //искать по маске, *.txt
            result = new RegexSearchCondition(RegexSearchCondition.preparePattern(argFoundFileParam.selection()));
        } else if (argFoundFileParam.mask().startsWith("f")) {
            //имя файла целиком
            result = new RegexSearchCondition(argFoundFileParam.selection());
        } else if (argFoundFileParam.mask().startsWith("r")) {
            //регулярное выражение
            result = p -> p.toFile().getName().matches(argFoundFileParam.selection());
        }
        return result;
    }

    private static class RegexSearchCondition implements Predicate<Path> {
        private final Pattern pattern;

        public RegexSearchCondition(String name) {
            this.pattern = Pattern.compile(name);
        }

        @Override
        public boolean test(Path path) {
            return pattern.matcher(path.toFile().getName()).matches();
        }

        private static String preparePattern(String pattern) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (c == '*') {
                    sb.append(".*");
                } else if (c == '.') {
                    sb.append("\\.");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
