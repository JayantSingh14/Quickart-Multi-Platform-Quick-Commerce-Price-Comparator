package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: classes.dex */
public final class SqlTypesSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f45453a;

    /* renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType f45454b;

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.DateType f45455c;

    /* renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f45456d;

    /* renamed from: e, reason: collision with root package name */
    public static final TypeAdapterFactory f45457e;

    /* renamed from: f, reason: collision with root package name */
    public static final TypeAdapterFactory f45458f;

    /* renamed from: com.google.gson.internal.sql.SqlTypesSupport$1, reason: invalid class name */
    public class AnonymousClass1 extends DefaultDateTypeAdapter.DateType<Date> {
        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
        public final java.util.Date b(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* renamed from: com.google.gson.internal.sql.SqlTypesSupport$2, reason: invalid class name */
    public class AnonymousClass2 extends DefaultDateTypeAdapter.DateType<Timestamp> {
        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
        public final java.util.Date b(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f45453a = z;
        if (z) {
            f45454b = new AnonymousClass1(Date.class);
            f45455c = new AnonymousClass2(Timestamp.class);
            f45456d = SqlDateTypeAdapter.f45447b;
            f45457e = SqlTimeTypeAdapter.f45449b;
            f45458f = SqlTimestampTypeAdapter.f45451b;
            return;
        }
        f45454b = null;
        f45455c = null;
        f45456d = null;
        f45457e = null;
        f45458f = null;
    }
}
