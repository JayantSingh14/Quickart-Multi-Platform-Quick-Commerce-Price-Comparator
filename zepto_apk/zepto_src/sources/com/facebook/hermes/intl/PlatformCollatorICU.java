package com.facebook.hermes.intl;

import android.icu.text.RuleBasedCollator;
import com.facebook.hermes.intl.IPlatformCollator;

/* loaded from: classes3.dex */
public class PlatformCollatorICU implements IPlatformCollator {

    /* renamed from: a, reason: collision with root package name */
    public RuleBasedCollator f17648a;

    /* renamed from: com.facebook.hermes.intl.PlatformCollatorICU$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17649a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17650b;

        static {
            int[] iArr = new int[IPlatformCollator.CaseFirst.values().length];
            f17650b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17650b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17650b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[IPlatformCollator.Sensitivity.values().length];
            f17649a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17649a[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17649a[2] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17649a[3] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
