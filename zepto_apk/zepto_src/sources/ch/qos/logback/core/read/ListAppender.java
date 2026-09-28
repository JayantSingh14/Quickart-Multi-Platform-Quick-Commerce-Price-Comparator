package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ListAppender<E> extends AppenderBase<E> {

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f13703j = new ArrayList();

    @Override // ch.qos.logback.core.AppenderBase
    public final void T1(Object obj) {
        this.f13703j.add(obj);
    }
}
