package ch.qos.logback.core.sift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbstractAppenderFactoryUsingJoran<E> implements AppenderFactory<E> {

    /* renamed from: a, reason: collision with root package name */
    public final List f13729a;

    public AbstractAppenderFactoryUsingJoran(ArrayList arrayList, HashMap map) {
        this.f13729a = arrayList.subList(1, arrayList.size() - 1);
    }
}
