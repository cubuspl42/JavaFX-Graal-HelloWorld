package com.sun.glass.utils;

import java.util.HashSet;

public class NativeLibLoader { // PATCH
    private static final HashSet<String> loaded = new HashSet<String>();

    public static synchronized void loadLibrary(String libname) {
        if (!loaded.contains(libname)) {
            loadLibraryInternal(libname);
            loaded.add(libname);
        }
    }

    private static void loadLibraryInternal(String libraryName) {
        System.loadLibrary(libraryName);
    }
}
