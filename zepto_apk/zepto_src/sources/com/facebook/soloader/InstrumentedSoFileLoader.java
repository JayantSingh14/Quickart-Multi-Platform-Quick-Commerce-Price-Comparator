package com.facebook.soloader;

import com.facebook.soloader.observer.Observer;
import com.facebook.soloader.observer.ObserverHolder;

/* loaded from: classes.dex */
public class InstrumentedSoFileLoader implements SoFileLoader {
    public final void a(int i2, String str) {
        Observer[] observerArr = (Observer[]) ObserverHolder.f20309a.get();
        int i3 = 0;
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.b();
            }
        }
        try {
            System.load(str);
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                Observer[] observerArr2 = (Observer[]) ObserverHolder.f20309a.get();
                if (observerArr2 != null) {
                    int length = observerArr2.length;
                    while (i3 < length) {
                        observerArr2[i3].f();
                        i3++;
                    }
                }
            }
        }
    }
}
