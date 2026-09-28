package com.google.firebase.components;

/* loaded from: classes.dex */
public final class Preconditions {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
