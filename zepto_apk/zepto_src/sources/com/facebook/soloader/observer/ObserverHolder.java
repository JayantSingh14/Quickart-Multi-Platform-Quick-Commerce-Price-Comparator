package com.facebook.soloader.observer;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ObserverHolder {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f20309a = new AtomicReference();

    public static void a(Throwable th) {
        Observer[] observerArr = (Observer[]) f20309a.get();
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.c();
            }
        }
    }
}
