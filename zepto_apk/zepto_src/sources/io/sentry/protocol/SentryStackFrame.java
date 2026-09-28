package io.sentry.protocol;

import in.juspay.airborne.ota.Constants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLockReason;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes.dex */
public final class SentryStackFrame implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52929a;

    /* renamed from: b, reason: collision with root package name */
    public String f52930b;

    /* renamed from: c, reason: collision with root package name */
    public String f52931c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f52932d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f52933e;

    /* renamed from: f, reason: collision with root package name */
    public String f52934f;

    /* renamed from: g, reason: collision with root package name */
    public String f52935g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f52936h;

    /* renamed from: i, reason: collision with root package name */
    public String f52937i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f52938j;

    /* renamed from: k, reason: collision with root package name */
    public String f52939k;

    /* renamed from: l, reason: collision with root package name */
    public String f52940l;

    /* renamed from: m, reason: collision with root package name */
    public String f52941m;
    public String n;
    public String o;
    public ConcurrentHashMap p;
    public String q;
    public SentryLockReason r;

    public static final class Deserializer implements JsonDeserializer<SentryStackFrame> {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            SentryStackFrame sentryStackFrame = new SentryStackFrame();
            objectReader.k();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                char c2 = 65535;
                switch (strX.hashCode()) {
                    case -1443345323:
                        if (strX.equals("image_addr")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1184392185:
                        if (strX.equals("in_app")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1113875953:
                        if (strX.equals("raw_function")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1102671691:
                        if (strX.equals("lineno")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (strX.equals("module")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (strX.equals("native")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -887523944:
                        if (strX.equals("symbol")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -807062458:
                        if (strX.equals(Constants.PACKAGE_DIR_NAME)) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -734768633:
                        if (strX.equals("filename")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -330260936:
                        if (strX.equals("symbol_addr")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 3327275:
                        if (strX.equals("lock")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 94842689:
                        if (strX.equals("colno")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 410194178:
                        if (strX.equals("instruction_addr")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 1116694660:
                        if (strX.equals("context_line")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                    case 1380938712:
                        if (strX.equals("function")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 1713445842:
                        if (strX.equals("abs_path")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (strX.equals("platform")) {
                            c2 = 16;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        sentryStackFrame.f52940l = objectReader.a1();
                        break;
                    case 1:
                        sentryStackFrame.f52936h = objectReader.f0();
                        break;
                    case 2:
                        sentryStackFrame.q = objectReader.a1();
                        break;
                    case 3:
                        sentryStackFrame.f52932d = objectReader.M0();
                        break;
                    case 4:
                        sentryStackFrame.f52931c = objectReader.a1();
                        break;
                    case 5:
                        sentryStackFrame.f52938j = objectReader.f0();
                        break;
                    case 6:
                        sentryStackFrame.o = objectReader.a1();
                        break;
                    case 7:
                        sentryStackFrame.f52937i = objectReader.a1();
                        break;
                    case '\b':
                        sentryStackFrame.f52929a = objectReader.a1();
                        break;
                    case '\t':
                        sentryStackFrame.f52941m = objectReader.a1();
                        break;
                    case '\n':
                        sentryStackFrame.r = (SentryLockReason) objectReader.o0(iLogger, new SentryLockReason.Deserializer());
                        break;
                    case 11:
                        sentryStackFrame.f52933e = objectReader.M0();
                        break;
                    case '\f':
                        sentryStackFrame.n = objectReader.a1();
                        break;
                    case '\r':
                        sentryStackFrame.f52935g = objectReader.a1();
                        break;
                    case 14:
                        sentryStackFrame.f52930b = objectReader.a1();
                        break;
                    case 15:
                        sentryStackFrame.f52934f = objectReader.a1();
                        break;
                    case 16:
                        sentryStackFrame.f52939k = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryStackFrame.p = concurrentHashMap;
            objectReader.t();
            return sentryStackFrame;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52929a != null) {
            objectWriter.d("filename").e(this.f52929a);
        }
        if (this.f52930b != null) {
            objectWriter.d("function").e(this.f52930b);
        }
        if (this.f52931c != null) {
            objectWriter.d("module").e(this.f52931c);
        }
        if (this.f52932d != null) {
            objectWriter.d("lineno").f(this.f52932d);
        }
        if (this.f52933e != null) {
            objectWriter.d("colno").f(this.f52933e);
        }
        if (this.f52934f != null) {
            objectWriter.d("abs_path").e(this.f52934f);
        }
        if (this.f52935g != null) {
            objectWriter.d("context_line").e(this.f52935g);
        }
        if (this.f52936h != null) {
            objectWriter.d("in_app").i(this.f52936h);
        }
        if (this.f52937i != null) {
            objectWriter.d(Constants.PACKAGE_DIR_NAME).e(this.f52937i);
        }
        if (this.f52938j != null) {
            objectWriter.d("native").i(this.f52938j);
        }
        if (this.f52939k != null) {
            objectWriter.d("platform").e(this.f52939k);
        }
        if (this.f52940l != null) {
            objectWriter.d("image_addr").e(this.f52940l);
        }
        if (this.f52941m != null) {
            objectWriter.d("symbol_addr").e(this.f52941m);
        }
        if (this.n != null) {
            objectWriter.d("instruction_addr").e(this.n);
        }
        if (this.q != null) {
            objectWriter.d("raw_function").e(this.q);
        }
        if (this.o != null) {
            objectWriter.d("symbol").e(this.o);
        }
        if (this.r != null) {
            objectWriter.d("lock").h(iLogger, this.r);
        }
        ConcurrentHashMap concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.p, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
