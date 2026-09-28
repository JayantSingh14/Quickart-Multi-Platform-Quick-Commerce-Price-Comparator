package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f45449b = new TypeAdapterFactory() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.f45459a == Time.class) {
                return new SqlTimeTypeAdapter(0);
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f45450a;

    public /* synthetic */ SqlTimeTypeAdapter(int i2) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.j0() == JsonToken.f45483i) {
            jsonReader.T();
            return null;
        }
        String strK0 = jsonReader.K0();
        synchronized (this) {
            TimeZone timeZone = this.f45450a.getTimeZone();
            try {
                try {
                    time = new Time(this.f45450a.parse(strK0).getTime());
                } catch (ParseException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as SQL Time; at path " + jsonReader.s(), e2);
                }
            } finally {
                this.f45450a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            jsonWriter.s();
            return;
        }
        synchronized (this) {
            str = this.f45450a.format((Date) time);
        }
        jsonWriter.j0(str);
    }

    private SqlTimeTypeAdapter() {
        this.f45450a = new SimpleDateFormat("hh:mm:ss a");
    }
}
