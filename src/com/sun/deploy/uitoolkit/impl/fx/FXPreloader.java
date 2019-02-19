//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sun.deploy.uitoolkit.impl.fx;

import javafx.application.Preloader.PreloaderNotification;

public class FXPreloader {
    private static final Object lock = new Object();
    private static FXPreloader defaultPreloader = null;

    private FXPreloader() {
    }

    static FXPreloader getDefaultPreloader() {
        synchronized (lock) {
            if (defaultPreloader != null) {
                defaultPreloader = new FXPreloader();
            }
        }

        return defaultPreloader;
    }

    public static void notfiyCurrentPreloaderOnExit() {
    }


    public static void notifyCurrentPreloader(PreloaderNotification var0) {
        System.out.println("FXPreloader::notifyCurrentPreloader");
    }

    public Object getOwner() {
        return null;
    }

    void start() throws Exception {
    }

    public static void hideSplash() {
    }

    void stop() throws Exception {
    }

//    static {
//        Class var0 = FXPreloader.Notifier.class;
//        Class var1 = FXPreloader.UserEvent.class;
//    }
//
//    class FXDispatcher implements Callable<Boolean> {
//        PreloaderEvent pe;
//
//        FXDispatcher(PreloaderEvent var2) {
//            this.pe = var2;
//        }
//
//        private void gotFatalError() {
//            FXPreloader.this.seenFatalError = true;
//            FXApplet2Adapter var1 = (FXApplet2Adapter)FXApplet2Adapter.get();
//            var1.setExitOnIdle(true);
//        }
//
//        public Boolean call() throws Exception {
//            if (FXPreloader.this.seenFatalError) {
//                throw new CancelException("Cancel launch after fatal error");
//            } else {
//                switch(this.pe.getType()) {
//                case 1:
//                    return true;
//                case 3:
//                    DownloadEvent var5 = (DownloadEvent)this.pe;
//                    double var6 = (double)var5.getOverallPercentage() / 100.0D;
//                    FXPreloader.this.fxPreview.handleProgressNotification(new ProgressNotification(var6));
//                    return true;
//                case 5:
//                    AppletInitEvent var1 = (AppletInitEvent)this.pe;
//                    Application var2 = null;
//                    Applet2 var3 = var1.getApplet();
//                    if (var3 != null && var3 instanceof FXApplet2) {
//                        var2 = ((FXApplet2)var3).getApplication();
//                    }
//
//                    switch(var1.getSubtype()) {
//                    case 2:
//                        FXPreloader.this.fxPreview.handleStateChangeNotification(new StateChangeNotification(Type.BEFORE_LOAD));
//                        break;
//                    case 3:
//                        FXPreloader.this.fxPreview.handleStateChangeNotification(new StateChangeNotification(Type.BEFORE_INIT, var2));
//                        break;
//                    case 4:
//                        FXPreloader.this.fxPreview.handleStateChangeNotification(new StateChangeNotification(Type.BEFORE_START, var2));
//                    }
//
//                    return true;
//                case 6:
//                    ErrorEvent var8 = (ErrorEvent)this.pe;
//                    String var9 = var8.getLocation() != null ? var8.getLocation().toString() : null;
//                    Throwable var10 = var8.getException();
//                    String var11 = var8.getValue();
//                    if (var11 == null) {
//                        var11 = var10 != null ? var10.getMessage() : "unknown error";
//                    }
//
//                    this.gotFatalError();
//                    return FXPreloader.this.fxPreview.handleErrorNotification(new ErrorNotification(var9, var11, var10));
//                case 7:
//                    UserDeclinedEvent var12 = (UserDeclinedEvent)this.pe;
//                    String var13 = var12.getLocation();
//                    return FXPreloader.this.fxPreview.handleErrorNotification(FXPreloader.this.new UserDeclinedNotification(var13));
//                case 1000:
//                    PreloaderNotification var4 = ((FXPreloader.UserEvent)this.pe).get();
//                    FXPreloader.this.fxPreview.handleApplicationNotification(var4);
//                    return true;
//                default:
//                    return false;
//                }
//            }
//        }
//    }
//
//    class UserDeclinedNotification extends ErrorNotification {
//        public UserDeclinedNotification(String var2) {
//            super(var2, "User declined to grant permissions to the application.", (Throwable)null);
//        }
//    }
//
//    static class Notifier implements PrivilegedExceptionAction<Void> {
//        PreloaderEvent pe;
//
//        Notifier(PreloaderEvent var1) {
//            this.pe = var1;
//        }
//
//        static void send(PreloaderEvent var0) {
//            try {
//                AccessController.doPrivileged(new FXPreloader.Notifier(var0));
//            } catch (Exception var2) {
//                Trace.ignoredException(var2);
//            }
//
//        }
//
//        public Void run() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CancelException {
//            Applet2Adapter var1 = FXApplet2Adapter.get();
//            if (var1 != null) {
//                Class var2 = Class.forName("com.sun.javaws.progress.Progress");
//                Method var3 = var2.getMethod("get", Applet2Adapter.class);
//                Preloader var4 = (Preloader)var3.invoke((Object)null, var1);
//                var4.handleEvent(this.pe);
//            }
//
//            return null;
//        }
//    }
//
//    static class UserEvent extends PreloaderEvent {
//        public static final int CUSTOM_USER_EVENT = 1000;
//        PreloaderNotification pe;
//
//        UserEvent(PreloaderNotification var1) {
//            super(1000);
//            this.pe = var1;
//        }
//
//        PreloaderNotification get() {
//            return this.pe;
//        }
//    }
}
