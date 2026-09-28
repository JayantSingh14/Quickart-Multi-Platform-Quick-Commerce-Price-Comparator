package com.google.android.play.core.splitinstall.internal;

import androidx.fragment.app.e;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class zzbj {

    /* renamed from: a, reason: collision with root package name */
    public final Object f41965a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f41966b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f41967c;

    public zzbj(Object obj, Field field, Class cls) {
        this.f41965a = obj;
        this.f41966b = field;
        this.f41967c = cls;
    }

    public final Object a() {
        Object obj = this.f41965a;
        Field field = this.f41966b;
        Class cls = this.f41967c;
        try {
            return cls.cast(field.get(obj));
        } catch (Exception e2) {
            String name = field.getName();
            String name2 = obj.getClass().getName();
            String name3 = cls.getName();
            StringBuilder sbV = e.v("Failed to get value of field ", name, " of type ", name2, " on object of type ");
            sbV.append(name3);
            throw new zzbl(sbV.toString(), e2);
        }
    }

    public final void b(Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object obj2 = this.f41965a;
        Field field = this.f41966b;
        try {
            field.set(obj2, obj);
        } catch (Exception e2) {
            String name = field.getName();
            String name2 = obj2.getClass().getName();
            String name3 = this.f41967c.getName();
            StringBuilder sbV = e.v("Failed to set value of field ", name, " of type ", name2, " on object of type ");
            sbV.append(name3);
            throw new zzbl(sbV.toString(), e2);
        }
    }
}
