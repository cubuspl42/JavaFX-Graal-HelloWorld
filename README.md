# JavaFX-Graal-HelloWorld

This is my attempt to make JavaFX work with GraalVM `native-image` on macOS. It doesn't really work, but you can build the image *and* run it. Then it hangs.

Related Graal issues
--------------------

- https://github.com/oracle/graal/issues/365
- https://github.com/oracle/graal/issues/403
- https://github.com/oracle/graal/issues/766

What does it do
---------------

I tried to find proper values of `-H:ReflectionConfigurationFiles`, `-H:JNIConfigurationFiles` and `--delay-class-initialization-to-runtime`. It was a nightmare.

Usage
-----

First, open the Intellij IDEA project and build it.

Then:
```sh
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
export PATH=/path/to/graalvm-ce-1.0.0-rc12/Contents/Home/bin:$PATH
./build-native-image.sh
./helloworld -Dprism.verbose=true -Djava.library.path=$JAVA_HOME/jre/lib
```

For me, the output is:
```
Prism pipeline init order: es2 sw
Using native-based Pisces rasterizer
Using dirty region optimizations
Not using texture mask for primitives
Not forcing power of 2 sizes for textures
Using hardware CLAMP_TO_ZERO mode
Opting in for HiDPI pixel scaling
Prism pipeline name = com.sun.prism.es2.ES2Pipeline
(X) Got class = class com.sun.prism.es2.ES2Pipeline
Loading ES2 native library ... prism_es2
	succeeded.
GLFactory using com.sun.prism.es2.MacGLFactory
Initialized prism pipeline: com.sun.prism.es2.ES2Pipeline
```

Then it hangs.