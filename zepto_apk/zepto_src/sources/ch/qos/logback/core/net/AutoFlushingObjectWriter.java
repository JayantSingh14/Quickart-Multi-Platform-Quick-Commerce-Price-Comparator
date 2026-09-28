package ch.qos.logback.core.net;

import java.io.ObjectOutputStream;

/* loaded from: classes3.dex */
public class AutoFlushingObjectWriter implements ObjectWriter {

    /* renamed from: a, reason: collision with root package name */
    public final ObjectOutputStream f13595a;

    /* renamed from: b, reason: collision with root package name */
    public int f13596b = 0;

    public AutoFlushingObjectWriter(ObjectOutputStream objectOutputStream) {
        this.f13595a = objectOutputStream;
    }
}
