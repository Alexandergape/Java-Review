package prove;

public class enumerated_types {

    public enum Day {Monday, Tuesday, Wednesday}

    public static void main(String []args){

        Day favDay = Day.Monday;
        System.out.println("Your favourite day is " + favDay);
        System.out.println(favDay.getClass());

        System.out.println();
        try{
            throw new Exception("Bad exception...");
        }catch (ArithmeticException ex){
            System.out.println("Can't divide by 0");
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally { //if any of the above commands run out
            System.out.println("Clean up");
        }
    }
}
