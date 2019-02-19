# JavaFX-Graal-HelloWorld

This is my attempt to make JavaFX work with GraalVM `native-image` on macOS. It doesn't really work, but you can build the image *and* run it. Then it hangs.

Related Graal issues
--------------------

- https://github.com/oracle/graal/issues/365
- https://github.com/oracle/graal/issues/403
- https://github.com/oracle/graal/issues/766
- https://github.com/oracle/graal/issues/993

So what you actually need to do to build and run JavaFX native image without errors
---------------

- Restart the native-image server before each build (`native-image --server-shutdown-all`)
- Set `-H:ReflectionConfigurationFiles`, so right classes are available via reflection
- Set `-H:JNIConfigurationFiles`, so right classes are available from JNI
- Set `--delay-class-initialization-to-runtime`, so Graal doesn't try to statically initialize the graphical toolkit. This one has ~2600 entries (it may be too much, though). I just kept adding more and more until there were no more build errors... It was a nightmare.
- Patch `com.sun.javafx.logging.JFRLogger`, because SVM doesn't seem to support `com.oracle.jrockit.jfr.*`. It's some shitty private HotSpot API (?). This class seems to be just a logging utility, so I provided an empty implementation.
- Patch `com.sun.glass.ui.Application`/`com.sun.glass.ui.mac.MacApplication`, because SVM doesn't seem to support getting base class static methods via JNI reflection from the child class. (https://github.com/oracle/graal/issues/993)


How to run this experiment
--------------------------

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