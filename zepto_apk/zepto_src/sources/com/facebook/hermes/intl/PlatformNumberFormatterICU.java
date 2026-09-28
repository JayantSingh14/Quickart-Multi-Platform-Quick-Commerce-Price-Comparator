package com.facebook.hermes.intl;

import android.icu.text.UFormat;
import android.icu.util.MeasureUnit;
import com.facebook.hermes.intl.IPlatformNumberFormatter;

/* loaded from: classes3.dex */
public class PlatformNumberFormatterICU implements IPlatformNumberFormatter {

    /* renamed from: a, reason: collision with root package name */
    public UFormat f17655a;

    /* renamed from: b, reason: collision with root package name */
    public android.icu.text.NumberFormat f17656b;

    /* renamed from: c, reason: collision with root package name */
    public LocaleObjectICU f17657c;

    /* renamed from: d, reason: collision with root package name */
    public IPlatformNumberFormatter.Style f17658d;

    /* renamed from: e, reason: collision with root package name */
    public MeasureUnit f17659e;

    /* renamed from: com.facebook.hermes.intl.PlatformNumberFormatterICU$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17660a;

        static {
            int[] iArr = new int[IPlatformNumberFormatter.SignDisplay.values().length];
            f17660a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17660a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17660a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
