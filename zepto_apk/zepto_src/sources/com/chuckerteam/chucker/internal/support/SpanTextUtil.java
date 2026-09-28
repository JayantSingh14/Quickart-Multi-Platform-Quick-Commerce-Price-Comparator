package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import com.chuckerteam.chucker.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class SpanTextUtil {

    /* renamed from: a, reason: collision with root package name */
    public final int f16814a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16815b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16816c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16817d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16818e;

    @Metadata
    public static final class ChuckerForegroundColorSpan extends ForegroundColorSpan {
    }

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    @SourceDebugExtension
    public static final class TokenType {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f16819b;

        /* renamed from: c, reason: collision with root package name */
        public static final Set f16820c;

        /* renamed from: d, reason: collision with root package name */
        public static final TokenType f16821d;

        /* renamed from: e, reason: collision with root package name */
        public static final TokenType f16822e;

        /* renamed from: f, reason: collision with root package name */
        public static final TokenType f16823f;

        /* renamed from: g, reason: collision with root package name */
        public static final TokenType f16824g;

        /* renamed from: h, reason: collision with root package name */
        public static final TokenType f16825h;

        /* renamed from: i, reason: collision with root package name */
        public static final TokenType f16826i;

        /* renamed from: j, reason: collision with root package name */
        public static final TokenType f16827j;

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ TokenType[] f16828k;

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f16829l;

        /* renamed from: a, reason: collision with root package name */
        public final Set f16830a;

        @Metadata
        public static final class Companion {
        }

        static {
            TokenType tokenType = new TokenType("STRING", SetsKt.e("\""), 0);
            f16821d = tokenType;
            String[] elements = {"[", "]"};
            Intrinsics.checkNotNullParameter(elements, "elements");
            TokenType tokenType2 = new TokenType("ARRAY", ArraysKt.H(elements), 1);
            f16822e = tokenType2;
            String[] elements2 = {"{", "}"};
            Intrinsics.checkNotNullParameter(elements2, "elements");
            TokenType tokenType3 = new TokenType("OBJECT", ArraysKt.H(elements2), 2);
            f16823f = tokenType3;
            TokenType tokenType4 = new TokenType("KEY_SEPARATOR", SetsKt.e(":"), 3);
            f16824g = tokenType4;
            TokenType tokenType5 = new TokenType("VALUE_SEPARATOR", SetsKt.e(","), 4);
            f16825h = tokenType5;
            String[] elements3 = {"true", "false"};
            Intrinsics.checkNotNullParameter(elements3, "elements");
            TokenType tokenType6 = new TokenType("BOOLEAN", ArraysKt.H(elements3), 5);
            f16826i = tokenType6;
            TokenType tokenType7 = new TokenType("NONE", EmptySet.f53611a, 6);
            f16827j = tokenType7;
            TokenType[] tokenTypeArr = {tokenType, tokenType2, tokenType3, tokenType4, tokenType5, tokenType6, tokenType7};
            f16828k = tokenTypeArr;
            f16829l = EnumEntriesKt.a(tokenTypeArr);
            f16819b = new Companion();
            TokenType[] tokenTypeArrValues = values();
            ArrayList arrayList = new ArrayList(tokenTypeArrValues.length);
            for (TokenType tokenType8 : tokenTypeArrValues) {
                arrayList.add(tokenType8.f16830a);
            }
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CollectionsKt.i(arrayList2, (Iterable) it.next());
            }
            f16820c = CollectionsKt.h0(arrayList2);
        }

        public TokenType(String str, Set set, int i2) {
            this.f16830a = set;
        }

        public static TokenType valueOf(String str) {
            return (TokenType) Enum.valueOf(TokenType.class, str);
        }

        public static TokenType[] values() {
            return (TokenType[]) f16828k.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16831a;

        static {
            int[] iArr = new int[TokenType.values().length];
            try {
                iArr[TokenType.f16826i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TokenType.f16822e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TokenType.f16823f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TokenType.f16824g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TokenType.f16825h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TokenType.f16821d.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TokenType.f16827j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f16831a = iArr;
        }
    }

    public SpanTextUtil(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f16814a = context.getColor(R.color.chucker_json_key_color);
        this.f16815b = context.getColor(R.color.chucker_json_value_color);
        this.f16816c = context.getColor(R.color.chucker_json_digit_and_null_value_color);
        this.f16817d = context.getColor(R.color.chucker_json_elements_color);
        this.f16818e = context.getColor(R.color.chucker_json_boolean_color);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0165 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.text.SpannableStringBuilder a(java.lang.CharSequence r14) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.SpanTextUtil.a(java.lang.CharSequence):android.text.SpannableStringBuilder");
    }
}
