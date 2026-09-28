package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

/* loaded from: classes5.dex */
public class MarkerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final BasicMarkerFactory f57877a;

    static {
        try {
            f57877a = a();
        } catch (Exception e2) {
            Util.c("Unexpected failure while binding MarkerFactory", e2);
        } catch (NoClassDefFoundError unused) {
            f57877a = new BasicMarkerFactory();
        }
    }

    public static BasicMarkerFactory a() {
        try {
            return StaticMarkerBinder.getSingleton().f57910a;
        } catch (NoSuchMethodError unused) {
            return StaticMarkerBinder.f57909b.f57910a;
        }
    }
}
