public class HelloWorldJNI {
    static {
        System.loadLibrary("native");
//        System.load("/home/lloyddcosta/IdeaProjects/JniSample/src/native.so");

    }
    private native void sayHello();
    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();

    }

    // Declare a native method sayHello() that receives no arguments and returns void


}
