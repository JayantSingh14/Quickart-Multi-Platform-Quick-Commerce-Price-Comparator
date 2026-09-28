package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes.dex */
public interface ComponentContainer {
    default Object a(Class cls) {
        return e(Qualified.a(cls));
    }

    Provider b(Qualified qualified);

    default Set c(Qualified qualified) {
        return (Set) d(qualified).get();
    }

    Provider d(Qualified qualified);

    default Object e(Qualified qualified) {
        Provider providerB = b(qualified);
        if (providerB == null) {
            return null;
        }
        return providerB.get();
    }

    default Set f(Class cls) {
        return c(Qualified.a(cls));
    }

    default Provider g(Class cls) {
        return b(Qualified.a(cls));
    }

    Deferred h(Qualified qualified);

    default Deferred i(Class cls) {
        return h(Qualified.a(cls));
    }
}
