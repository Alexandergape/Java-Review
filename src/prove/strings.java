package prove;

public class strings {

    public static void main(String[] args){
        String string = "   This is just a test for Dave ...     ";
        string += 9;  // 9 is added like string
        System.out.println(string);
        System.out.println("first char on string: " + string.charAt(0));
        System.out.println("Is Dave on string?: " + string.contains("Dave"));  // check if Dave is into string
        System.out.println("Index of 'Dave'" + string.indexOf("Dave"));
        System.out.println("length of string: " + string.length());

        //check if a string is equal to another one
        System.out.println("dog equals cat: " + ("dog".equals("cat")));
        System.out.println("dog equals cat: " + ("dog".equalsIgnoreCase("DoG")));

        System.out.println("compare between cat and dog: " + ("dog".compareTo("cat")));

        System.out.println("replace Dave for Kate " + (string.replace("Dave", "Kate")));

        System.out.println("get a substring: " + (string.substring(5, 10)));

        // split a String
        System.out.println("Separated words");
        for(String str: string.split(" "))
            System.out.print(str + '/');

        System.out.println('\n' + string.trim());

    }
}
