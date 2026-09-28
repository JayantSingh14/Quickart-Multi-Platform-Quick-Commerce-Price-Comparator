package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: classes4.dex */
public final class MessagingClientEvent {

    /* renamed from: a, reason: collision with root package name */
    public final long f44848a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44849b;

    /* renamed from: c, reason: collision with root package name */
    public final String f44850c;

    /* renamed from: d, reason: collision with root package name */
    public final MessageType f44851d;

    /* renamed from: e, reason: collision with root package name */
    public final SDKPlatform f44852e;

    /* renamed from: f, reason: collision with root package name */
    public final String f44853f;

    /* renamed from: g, reason: collision with root package name */
    public final String f44854g;

    /* renamed from: h, reason: collision with root package name */
    public final int f44855h;

    /* renamed from: i, reason: collision with root package name */
    public final int f44856i;

    /* renamed from: j, reason: collision with root package name */
    public final String f44857j;

    /* renamed from: k, reason: collision with root package name */
    public final Event f44858k;

    /* renamed from: l, reason: collision with root package name */
    public final String f44859l;

    /* renamed from: m, reason: collision with root package name */
    public final String f44860m;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f44861a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f44862b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f44863c = "";

        /* renamed from: d, reason: collision with root package name */
        public MessageType f44864d = MessageType.UNKNOWN;

        /* renamed from: e, reason: collision with root package name */
        public SDKPlatform f44865e = SDKPlatform.UNKNOWN_OS;

        /* renamed from: f, reason: collision with root package name */
        public String f44866f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f44867g = "";

        /* renamed from: h, reason: collision with root package name */
        public int f44868h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f44869i = 0;

        /* renamed from: j, reason: collision with root package name */
        public String f44870j = "";

        /* renamed from: k, reason: collision with root package name */
        public Event f44871k = Event.UNKNOWN_EVENT;

        /* renamed from: l, reason: collision with root package name */
        public String f44872l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f44873m = "";

        public final MessagingClientEvent a() {
            return new MessagingClientEvent(this.f44861a, this.f44862b, this.f44863c, this.f44864d, this.f44865e, this.f44866f, this.f44867g, this.f44868h, this.f44869i, this.f44870j, this.f44871k, this.f44872l, this.f44873m);
        }

        public final void b(String str) {
            this.f44872l = str;
        }

        public final void c(String str) {
            this.f44867g = str;
        }

        public final void d(String str) {
            this.f44873m = str;
        }

        public final void e() {
            this.f44871k = Event.MESSAGE_DELIVERED;
        }

        public final void f(String str) {
            this.f44863c = str;
        }

        public final void g(String str) {
            this.f44862b = str;
        }

        public final void h(MessageType messageType) {
            this.f44864d = messageType;
        }

        public final void i(String str) {
            this.f44866f = str;
        }

        public final void j(int i2) {
            this.f44868h = i2;
        }

        public final void k(long j2) {
            this.f44861a = j2;
        }

        public final void l() {
            this.f44865e = SDKPlatform.ANDROID;
        }

        public final void m(String str) {
            this.f44870j = str;
        }

        public final void n(int i2) {
            this.f44869i = i2;
        }
    }

    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        /* JADX INFO: Fake field, exist only in values array */
        MESSAGE_OPEN(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f44877a;

        Event(int i2) {
            this.f44877a = i2;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int f() {
            return this.f44877a;
        }
    }

    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        /* JADX INFO: Fake field, exist only in values array */
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f44882a;

        MessageType(int i2) {
            this.f44882a = i2;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int f() {
            return this.f44882a;
        }
    }

    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        /* JADX INFO: Fake field, exist only in values array */
        IOS(2),
        /* JADX INFO: Fake field, exist only in values array */
        WEB(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f44886a;

        SDKPlatform(int i2) {
            this.f44886a = i2;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int f() {
            return this.f44886a;
        }
    }

    static {
        new Builder().a();
    }

    public MessagingClientEvent(long j2, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i2, int i3, String str5, Event event, String str6, String str7) {
        this.f44848a = j2;
        this.f44849b = str;
        this.f44850c = str2;
        this.f44851d = messageType;
        this.f44852e = sDKPlatform;
        this.f44853f = str3;
        this.f44854g = str4;
        this.f44855h = i2;
        this.f44856i = i3;
        this.f44857j = str5;
        this.f44858k = event;
        this.f44859l = str6;
        this.f44860m = str7;
    }

    public static Builder a() {
        return new Builder();
    }
}
