package com.google.gson;

import android.support.v4.media.b;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class ToNumberPolicy implements ToNumberStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final ToNumberPolicy f45269a;

    /* renamed from: b, reason: collision with root package name */
    public static final ToNumberPolicy f45270b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ToNumberPolicy[] f45271c;

    static {
        ToNumberPolicy toNumberPolicy = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.1
            @Override // com.google.gson.ToNumberStrategy
            public final Number a(JsonReader jsonReader) {
                return Double.valueOf(jsonReader.nextDouble());
            }
        };
        f45269a = toNumberPolicy;
        ToNumberPolicy toNumberPolicy2 = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.2
            @Override // com.google.gson.ToNumberStrategy
            public final Number a(JsonReader jsonReader) {
                return new LazilyParsedNumber(jsonReader.K0());
            }
        };
        f45270b = toNumberPolicy2;
        f45271c = new ToNumberPolicy[]{toNumberPolicy, toNumberPolicy2, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.3
            public static Double b(String str, JsonReader jsonReader) throws MalformedJsonException, NumberFormatException {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!(jsonReader.f45463b == Strictness.f45265a)) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.s());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e2) {
                    StringBuilder sbY = b.y("Cannot parse ", str, "; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonParseException(sbY.toString(), e2);
                }
            }

            @Override // com.google.gson.ToNumberStrategy
            public final Number a(JsonReader jsonReader) throws IOException {
                String strK0 = jsonReader.K0();
                if (strK0.indexOf(46) >= 0) {
                    return b(strK0, jsonReader);
                }
                try {
                    return Long.valueOf(Long.parseLong(strK0));
                } catch (NumberFormatException unused) {
                    return b(strK0, jsonReader);
                }
            }
        }, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.4
            @Override // com.google.gson.ToNumberStrategy
            public final Number a(JsonReader jsonReader) throws IOException {
                String strK0 = jsonReader.K0();
                try {
                    return NumberLimits.b(strK0);
                } catch (NumberFormatException e2) {
                    StringBuilder sbY = b.y("Cannot parse ", strK0, "; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonParseException(sbY.toString(), e2);
                }
            }
        }};
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) f45271c.clone();
    }
}
