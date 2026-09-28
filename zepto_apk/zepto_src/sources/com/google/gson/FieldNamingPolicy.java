package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final FieldNamingPolicy f45218a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FieldNamingPolicy[] f45219b;

    static {
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.1
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return field.getName();
            }
        };
        f45218a = fieldNamingPolicy;
        f45219b = new FieldNamingPolicy[]{fieldNamingPolicy, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.2
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.c(field.getName());
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.3
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.c(FieldNamingPolicy.b(field.getName(), ' '));
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.4
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.5
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.6
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), Soundex.SILENT_MARKER).toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.7
            @Override // com.google.gson.FieldNamingStrategy
            public final String a(Field field) {
                return FieldNamingPolicy.b(field.getName(), ClassUtils.PACKAGE_SEPARATOR_CHAR).toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String b(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = str.charAt(i2);
            if (!Character.isLetter(cCharAt)) {
                i2++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f45219b.clone();
    }
}
