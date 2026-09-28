package com.facebook.react.bridge;

/* loaded from: classes.dex */
public class DefaultJSExceptionHandler implements JSExceptionHandler {
    @Override // com.facebook.react.bridge.JSExceptionHandler
    public void handleException(Exception exc) {
        if (!(exc instanceof RuntimeException)) {
            throw new RuntimeException(exc);
        }
        throw ((RuntimeException) exc);
    }
}
