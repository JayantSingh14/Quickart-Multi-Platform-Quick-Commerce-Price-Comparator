package com.google.gson.internal.bind;

import android.support.v4.media.b;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final TypeAdapterFactory f45348c = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.f45459a == Date.class) {
                return new DefaultDateTypeAdapter(DateType.f45351b, 2, 2);
            }
            return null;
        }

        public final String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final DateType f45349a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f45350b;

    public static abstract class DateType<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final DateType f45351b = new AnonymousClass1(Date.class);

        /* renamed from: a, reason: collision with root package name */
        public final Class f45352a;

        /* renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType$1, reason: invalid class name */
        public class AnonymousClass1 extends DateType<Date> {
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public final Date b(Date date) {
                return date;
            }
        }

        public DateType(Class cls) {
            this.f45352a = cls;
        }

        public final TypeAdapterFactory a(int i2, int i3) {
            DefaultDateTypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(this, i2, i3);
            TypeAdapterFactory typeAdapterFactory = TypeAdapters.f45411a;
            return new TypeAdapters.AnonymousClass31(this.f45352a, defaultDateTypeAdapter);
        }

        public abstract Date b(Date date);
    }

    public DefaultDateTypeAdapter(DateType dateType, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f45350b = arrayList;
        Objects.requireNonNull(dateType);
        this.f45349a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (JavaVersion.a()) {
            arrayList.add(PreJava9DateFormatProvider.a(i2, i3));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException {
        Date dateB;
        if (jsonReader.j0() == JsonToken.f45483i) {
            jsonReader.T();
            return null;
        }
        String strK0 = jsonReader.K0();
        synchronized (this.f45350b) {
            try {
                Iterator it = this.f45350b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        try {
                            dateB = ISO8601Utils.b(strK0, new ParsePosition(0));
                            break;
                        } catch (ParseException e2) {
                            StringBuilder sbY = b.y("Failed parsing '", strK0, "' as Date; at path ");
                            sbY.append(jsonReader.s());
                            throw new JsonSyntaxException(sbY.toString(), e2);
                        }
                    }
                    DateFormat dateFormat = (DateFormat) it.next();
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strK0);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f45349a.b(dateB);
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.s();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f45350b.get(0);
        synchronized (this.f45350b) {
            str = dateFormat.format(date);
        }
        jsonWriter.j0(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f45350b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
