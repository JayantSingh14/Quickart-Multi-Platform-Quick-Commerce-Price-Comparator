package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: classes3.dex */
public final class LogEventDropped {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20812c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f20813a;

    /* renamed from: b, reason: collision with root package name */
    public final Reason f20814b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f20815a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Reason f20816b = Reason.REASON_UNKNOWN;

        public final LogEventDropped a() {
            return new LogEventDropped(this.f20815a, this.f20816b);
        }
    }

    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* renamed from: a, reason: collision with root package name */
        public final int f20825a;

        Reason(int i2) {
            this.f20825a = i2;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int f() {
            return this.f20825a;
        }
    }

    static {
        new Builder().a();
    }

    public LogEventDropped(long j2, Reason reason) {
        this.f20813a = j2;
        this.f20814b = reason;
    }
}
