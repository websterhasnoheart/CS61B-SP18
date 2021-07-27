public class ListTest {
    public static void main(String[] args) {
        IntList intList = new IntList();

        IntList A = IntList.of(1,2);
        IntList B = IntList.of(3,4);

        intList.catenate(A,B);
    }
}
