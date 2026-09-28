package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.Stack;

/* loaded from: classes4.dex */
public class TrimmedThrowableData {

    /* renamed from: a, reason: collision with root package name */
    public final String f44460a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44461b;

    /* renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f44462c;

    /* renamed from: d, reason: collision with root package name */
    public final TrimmedThrowableData f44463d;

    public TrimmedThrowableData(String str, String str2, StackTraceElement[] stackTraceElementArr, TrimmedThrowableData trimmedThrowableData) {
        this.f44460a = str;
        this.f44461b = str2;
        this.f44462c = stackTraceElementArr;
        this.f44463d = trimmedThrowableData;
    }

    public static TrimmedThrowableData a(Throwable th, MiddleOutFallbackStrategy middleOutFallbackStrategy) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        TrimmedThrowableData trimmedThrowableData = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            trimmedThrowableData = new TrimmedThrowableData(th2.getLocalizedMessage(), th2.getClass().getName(), middleOutFallbackStrategy.a(th2.getStackTrace()), trimmedThrowableData);
        }
        return trimmedThrowableData;
    }
}
