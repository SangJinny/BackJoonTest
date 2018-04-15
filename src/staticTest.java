public class staticTest {

    static {
        System.out.println("StaticBlock");


    }

    { System.out.println("initailize");}

    staticTest() {

        System.out.println("생성자");
    }
}
