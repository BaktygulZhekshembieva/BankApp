public class JavaExceptions {
    public static void main(String[] args) throws Exception {

        int a = 5;
        int b = 0;

        try {
            System.out.println(a / b);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println(a / b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("OOOPS!");
        }

        try {
            System.out.println(a / b);
        }catch (Exception e){
            throw new ArithmeticException("We can not divide 0");
        }


    }


}
