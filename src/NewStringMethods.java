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
    }
}
