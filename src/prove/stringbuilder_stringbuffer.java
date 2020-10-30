package prove;

public class stringbuilder_stringbuffer {
    public static void main(String[]args){
// stringbuilder for strings, stringBuffer for threads
        StringBuilder sb = new StringBuilder("I am a string builder");

        System.out.println(sb.capacity());

        sb.append(" Yeah!");
        System.out.println(sb.insert(6, " BIG"));
        System.out.println(sb.replace(6, 9, "wig"));
        System.out.println(sb.substring(6, 10));
        System.out.println(sb.delete(6, 10));
    }
}
