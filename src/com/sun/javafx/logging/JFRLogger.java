package com.sun.javafx.logging;

class JFRLogger extends Logger { // PATCH
    private static JFRLogger jfrLogger;

    private JFRLogger() throws Exception {
    }

    public static JFRLogger getInstance() {
        if (jfrLogger == null) {
            try {
                jfrLogger = new JFRLogger();
            }
            catch (Exception e) {
                jfrLogger = null;
            }
        }
        return jfrLogger;
    }

    @Override
    public void pulseStart() {
    }

    @Override
    public void pulseEnd() {
    }

    @Override
    public void renderStart() {
    }

    @Override
    public void renderEnd() {
    }

    @Override
    public void newPhase(String phaseName) {
    }

    @Override
    public void newInput(String input) {
    }
}
