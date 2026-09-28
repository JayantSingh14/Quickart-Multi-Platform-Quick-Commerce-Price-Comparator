package io.sentry;

import io.sentry.vendor.gson.stream.JsonReader;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class JsonObjectDeserializer {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f51661a = new ArrayList();

    /* renamed from: io.sentry.JsonObjectDeserializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51662a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f51662a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51662a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51662a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f51662a[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f51662a[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f51662a[JsonToken.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f51662a[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f51662a[JsonToken.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f51662a[JsonToken.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f51662a[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface NextValue {
        Object b();
    }

    public interface Token {
        Object getValue();
    }

    public static final class TokenArray implements Token {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f51663a = new ArrayList();

        @Override // io.sentry.JsonObjectDeserializer.Token
        public final Object getValue() {
            return this.f51663a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class TokenMap implements Token {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f51664a = new HashMap();

        @Override // io.sentry.JsonObjectDeserializer.Token
        public final Object getValue() {
            return this.f51664a;
        }
    }

    public static final class TokenName implements Token {

        /* renamed from: a, reason: collision with root package name */
        public final String f51665a;

        public TokenName(String str) {
            this.f51665a = str;
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public final Object getValue() {
            return this.f51665a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class TokenPrimitive implements Token {

        /* renamed from: a, reason: collision with root package name */
        public final Object f51666a;

        public TokenPrimitive(Object obj) {
            this.f51666a = obj;
        }

        @Override // io.sentry.JsonObjectDeserializer.Token
        public final Object getValue() {
            return this.f51666a;
        }
    }

    public final Token a() {
        ArrayList arrayList = this.f51661a;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Token) android.support.v4.media.b.c(1, arrayList);
    }

    public final boolean b() {
        if (this.f51661a.size() == 1) {
            return true;
        }
        Token tokenA = a();
        e();
        if (!(a() instanceof TokenName)) {
            if (!(a() instanceof TokenArray)) {
                return false;
            }
            TokenArray tokenArray = (TokenArray) a();
            if (tokenA == null || tokenArray == null) {
                return false;
            }
            tokenArray.f51663a.add(tokenA.getValue());
            return false;
        }
        TokenName tokenName = (TokenName) a();
        e();
        TokenMap tokenMap = (TokenMap) a();
        if (tokenName == null || tokenA == null || tokenMap == null) {
            return false;
        }
        tokenMap.f51664a.put(tokenName.f51665a, tokenA.getValue());
        return false;
    }

    public final boolean c(NextValue nextValue) {
        Object objB = nextValue.b();
        if (a() == null && objB != null) {
            this.f51661a.add(new TokenPrimitive(objB));
            return true;
        }
        if (a() instanceof TokenName) {
            TokenName tokenName = (TokenName) a();
            e();
            ((TokenMap) a()).f51664a.put(tokenName.f51665a, objB);
            return false;
        }
        if (!(a() instanceof TokenArray)) {
            return false;
        }
        ((TokenArray) a()).f51663a.add(objB);
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void d(final JsonObjectReader jsonObjectReader) throws IOException {
        boolean zB;
        int i2 = AnonymousClass1.f51662a[jsonObjectReader.f51667a.peek().ordinal()];
        ArrayList arrayList = this.f51661a;
        JsonReader jsonReader = jsonObjectReader.f51667a;
        switch (i2) {
            case 1:
                jsonReader.a();
                arrayList.add(new TokenArray());
                zB = false;
                break;
            case 2:
                jsonReader.e();
                zB = b();
                break;
            case 3:
                jsonObjectReader.k();
                arrayList.add(new TokenMap());
                zB = false;
                break;
            case 4:
                jsonObjectReader.t();
                zB = b();
                break;
            case 5:
                arrayList.add(new TokenName(jsonReader.X()));
                zB = false;
                break;
            case 6:
                final int i3 = 0;
                zB = c(new NextValue() { // from class: io.sentry.e
                    @Override // io.sentry.JsonObjectDeserializer.NextValue
                    public final Object b() {
                        switch (i3) {
                            case 0:
                                return jsonObjectReader.f51667a.K0();
                            default:
                                return Boolean.valueOf(jsonObjectReader.f51667a.A());
                        }
                    }
                });
                break;
            case 7:
                zB = c(new NextValue() { // from class: io.sentry.f
                    @Override // io.sentry.JsonObjectDeserializer.NextValue
                    public final Object b() {
                        JsonObjectReader jsonObjectReader2 = jsonObjectReader;
                        this.f52739a.getClass();
                        try {
                            try {
                                return Integer.valueOf(jsonObjectReader2.f51667a.nextInt());
                            } catch (Exception unused) {
                                return Long.valueOf(jsonObjectReader2.f51667a.nextLong());
                            }
                        } catch (Exception unused2) {
                            return Double.valueOf(jsonObjectReader2.f51667a.nextDouble());
                        }
                    }
                });
                break;
            case 8:
                final int i4 = 1;
                zB = c(new NextValue() { // from class: io.sentry.e
                    @Override // io.sentry.JsonObjectDeserializer.NextValue
                    public final Object b() {
                        switch (i4) {
                            case 0:
                                return jsonObjectReader.f51667a.K0();
                            default:
                                return Boolean.valueOf(jsonObjectReader.f51667a.A());
                        }
                    }
                });
                break;
            case 9:
                jsonReader.N();
                zB = c(new g());
                break;
            case 10:
                zB = true;
                break;
            default:
                zB = false;
                break;
        }
        if (zB) {
            return;
        }
        d(jsonObjectReader);
    }

    public final void e() {
        ArrayList arrayList = this.f51661a;
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(arrayList.size() - 1);
    }
}
