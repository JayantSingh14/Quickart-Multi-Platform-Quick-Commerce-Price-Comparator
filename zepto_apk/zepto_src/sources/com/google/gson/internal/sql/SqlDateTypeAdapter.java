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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* loaded from: classes.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f45447b = new TypeAdapterFactory() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.f45459a == Date.class) {
                return new SqlDateTypeAdapter(0);
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f45448a;

    public /* synthetic */ SqlDateTypeAdapter(int i2) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException {
        Date date;
        if (jsonReader.j0() == JsonToken.f45483i) {
            jsonReader.T();
            return null;
        }
        String strK0 = jsonReader.K0();
        synchronized (this) {
            TimeZone timeZone = this.f45448a.getTimeZone();
            try {
                try {
                    date = new Date(this.f45448a.parse(strK0).getTime());
                } catch (ParseException e2) {
                    throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as SQL Date; at path " + jsonReader.s(), e2);
                }
            } finally {
                this.f45448a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.s();
            return;
        }
        synchronized (this) {
            str = this.f45448a.format((java.util.Date) date);
        }
        jsonWriter.j0(str);
    }

    private SqlDateTypeAdapter() {
        this.f45448a = new SimpleDateFormat("MMM d, yyyy");
    }
}
