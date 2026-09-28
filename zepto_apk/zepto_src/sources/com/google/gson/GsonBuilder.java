package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.sql.SqlTypesSupport;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class GsonBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Excluder f45241a;

    /* renamed from: b, reason: collision with root package name */
    public final LongSerializationPolicy f45242b;

    /* renamed from: c, reason: collision with root package name */
    public final FieldNamingPolicy f45243c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f45244d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f45245e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f45246f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f45247g;

    /* renamed from: h, reason: collision with root package name */
    public final int f45248h;

    /* renamed from: i, reason: collision with root package name */
    public final int f45249i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f45250j;

    /* renamed from: k, reason: collision with root package name */
    public FormattingStyle f45251k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f45252l;

    /* renamed from: m, reason: collision with root package name */
    public final ToNumberPolicy f45253m;
    public final ToNumberPolicy n;
    public final ArrayDeque o;

    public GsonBuilder() {
        this.f45241a = Excluder.f45296c;
        this.f45242b = LongSerializationPolicy.f45258a;
        this.f45243c = FieldNamingPolicy.f45218a;
        this.f45244d = new HashMap();
        this.f45245e = new ArrayList();
        this.f45246f = new ArrayList();
        this.f45247g = false;
        FormattingStyle formattingStyle = Gson.u;
        this.f45248h = 2;
        this.f45249i = 2;
        this.f45250j = true;
        this.f45251k = Gson.u;
        this.f45252l = true;
        this.f45253m = (ToNumberPolicy) Gson.w;
        this.n = (ToNumberPolicy) Gson.x;
        this.o = new ArrayDeque();
    }

    public final Gson a() {
        TypeAdapterFactory typeAdapterFactoryA;
        TypeAdapterFactory typeAdapterFactoryA2;
        ArrayList arrayList = this.f45245e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f45246f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z = SqlTypesSupport.f45453a;
        DefaultDateTypeAdapter.DateType dateType = DefaultDateTypeAdapter.DateType.f45351b;
        int i2 = this.f45248h;
        int i3 = this.f45249i;
        if (i2 != 2 || i3 != 2) {
            TypeAdapterFactory typeAdapterFactoryA3 = dateType.a(i2, i3);
            if (z) {
                typeAdapterFactoryA = SqlTypesSupport.f45455c.a(i2, i3);
                typeAdapterFactoryA2 = SqlTypesSupport.f45454b.a(i2, i3);
            } else {
                typeAdapterFactoryA = null;
                typeAdapterFactoryA2 = null;
            }
            arrayList3.add(typeAdapterFactoryA3);
            if (z) {
                arrayList3.add(typeAdapterFactoryA);
                arrayList3.add(typeAdapterFactoryA2);
            }
        }
        return new Gson(this.f45241a, this.f45243c, new HashMap(this.f45244d), this.f45247g, this.f45250j, this.f45251k, this.f45252l, this.f45242b, this.f45248h, this.f45249i, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, this.f45253m, this.n, new ArrayList(this.o));
    }

    public GsonBuilder(Gson gson) {
        this.f45241a = Excluder.f45296c;
        this.f45242b = LongSerializationPolicy.f45258a;
        this.f45243c = FieldNamingPolicy.f45218a;
        HashMap map = new HashMap();
        this.f45244d = map;
        ArrayList arrayList = new ArrayList();
        this.f45245e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f45246f = arrayList2;
        this.f45247g = false;
        FormattingStyle formattingStyle = Gson.u;
        this.f45248h = 2;
        this.f45249i = 2;
        this.f45250j = true;
        this.f45251k = Gson.u;
        this.f45252l = true;
        this.f45253m = (ToNumberPolicy) Gson.w;
        this.n = (ToNumberPolicy) Gson.x;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.o = arrayDeque;
        this.f45241a = gson.f45230f;
        this.f45243c = gson.f45231g;
        map.putAll(gson.f45232h);
        this.f45247g = gson.f45233i;
        this.f45250j = gson.f45234j;
        this.f45251k = gson.f45235k;
        this.f45242b = gson.o;
        this.f45248h = gson.f45237m;
        this.f45249i = gson.n;
        arrayList.addAll(gson.p);
        arrayList2.addAll(gson.q);
        this.f45252l = gson.f45236l;
        this.f45253m = gson.r;
        this.n = gson.s;
        arrayDeque.addAll(gson.t);
    }
}
