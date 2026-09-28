package com.google.android.gms.internal.ads;

import android.webkit.ConsoleMessage;

/* loaded from: classes4.dex */
final /* synthetic */ class zzcip {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f26341a;

    static {
        int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
        f26341a = iArr;
        try {
            iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f26341a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f26341a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f26341a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f26341a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
