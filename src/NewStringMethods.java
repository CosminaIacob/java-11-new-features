import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NewStringMethods {

    public static void main(String[] args) {
        System.out.println("repeat()");
        System.out.println("na ".repeat(5) + "Batman!");
        System.out.println("------------------------");

        System.out.println("isBlank()");
        var noText = "   ";
        System.out.println("".equals(noText.trim()));
        System.out.println(noText.isBlank());
        System.out.println("------------------------");

        System.out.println("strip()");
        var text = "\n\t     text \u2005";
        System.out.println(text.strip());
        System.out.println(text.stripLeading());
        System.out.println(text.stripTrailing());
        System.out.println(text.trim());
        System.out.println(Character.isWhitespace('\u2005'));
        System.out.println("------------------------");

        System.out.println("lines()");
        var multiline = "1\n2\n3\n4";
        multiline.lines().forEach(System.out::println);
        System.out.println("------------------------");

        System.out.println("Optional::isEmpty()");
        var opt = Optional.ofNullable(null);
        System.out.println(opt.isEmpty());
        System.out.println(opt.isPresent());

        System.out.println("Predicate::not");
        Stream<String> strings = Stream.of("string1", "string2", "", "string3");
        strings.filter(Predicate.not(String::isBlank))
                .forEach(System.out::println);
    }
}
