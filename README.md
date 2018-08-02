# JNISample
Steps followed to create shared library (i.e .so file)

In this Project I have used C++ as Native Language and  G++ as compiler and linker.
First make sure your ubuntu system has G++ Compiler , if not run the below command
sudo apt-get install build-essential.

Steps:
1) Create a Java Class.

2) Implementing a Method in C++

  1.Now, we need to create the implementation of our native method in C++
  
  2.Within C++ the definition and the implementation are usually stored in .h and .cpp files respectively.
  
  3.First, to create the definition of the method, we have to use the -h flag of the Java compiler:
  
     javac -h . HelloWorldJNI.java
     
3)Now, we have to create a new .cpp file for the implementation of the sayHello function. This is where we’ll perform actions that print “Hello World” to console.

 Eg:
      JNIEXPORT void JNICALL Java_HelloWorldJNI_sayHello
  (JNIEnv* env, jobject thisObject) {
    std::cout << "Hello from C++ !!" << std::endl;
}

4)Compiling And Linking

We need to build our shared library from the C++ code and run it!

To do so, we have to use G++ compiler, not forgetting to include the JNI headers from our Java JDK installation.

Ubuntu version:

g++ -c -fPIC -I/usr/lib/jvm/java-8-openjdk-amd64/include -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux HelloWorldJNI.cpp -o HelloWorldJNI.o


Once we have the code compiled for our platform into the file com_baeldung_jni_HelloWorldJNI.o, we have to include it in a new shared library. Whatever we decide to name it is the argument passed into the method System.loadLibrary.

We named ours “native”, and we’ll load it when running our Java code.

The G++ linker then links the C++ object files into our bridged library.

Ubuntu version:

g++ -shared -fPIC -o libnative.so HelloWorldJNI.o -lc
5)
However, we need to add the full path to the directory containing the library we’ve just generated. This way Java will know where to look for our native libs:

"java -cp . -Djava.library.path=<path_to_.so> <class name>"
  
  eg: java -Djava.library.path=/home/lloyddcosta/JNISample/JniSample/src/jnilibs/ HelloWorldJNI where jnilibs is a package name which has .so file
 


Console output:

Hello from C++ !!

 
