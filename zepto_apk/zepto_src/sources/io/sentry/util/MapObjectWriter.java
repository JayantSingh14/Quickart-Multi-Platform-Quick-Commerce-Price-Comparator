package io.sentry.util;

import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonSerializable;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class MapObjectWriter implements ObjectWriter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f53128a;

    public MapObjectWriter(HashMap map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f53128a = arrayDeque;
        arrayDeque.addLast(map);
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter a(long j2) {
        j(Long.valueOf(j2));
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter b(double d2) {
        j(Double.valueOf(d2));
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter c(boolean z) {
        j(Boolean.valueOf(z));
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter d(String str) {
        this.f53128a.add(str);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter e(String str) {
        j(str);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter f(Number number) {
        j(number);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final /* bridge */ /* synthetic */ ObjectWriter h(ILogger iLogger, Object obj) {
        n(iLogger, obj);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter i(Boolean bool) {
        j(bool);
        return this;
    }

    public final void j(Object obj) {
        ArrayDeque arrayDeque = this.f53128a;
        Object objPeekLast = arrayDeque.peekLast();
        if (objPeekLast instanceof List) {
            ((List) objPeekLast).add(obj);
            return;
        }
        if (!(objPeekLast instanceof String)) {
            throw new IllegalStateException("Invalid stack state, expected array or string on top");
        }
        String str = (String) arrayDeque.removeLast();
        Object objPeekLast2 = arrayDeque.peekLast();
        if (objPeekLast2 == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        if (!(objPeekLast2 instanceof Map)) {
            throw new IllegalStateException("Stack element is not a Map.");
        }
        ((Map) objPeekLast2).put(str, obj);
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter k() {
        this.f53128a.addLast(new HashMap());
        return this;
    }

    public final void l(ILogger iLogger, Collection collection) {
        ArrayDeque arrayDeque = this.f53128a;
        arrayDeque.add(new ArrayList());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            n(iLogger, it.next());
        }
        j(arrayDeque.removeLast());
    }

    public final void m(ILogger iLogger, Map map) {
        ArrayDeque arrayDeque = this.f53128a;
        arrayDeque.addLast(new HashMap());
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                arrayDeque.add((String) obj);
                n(iLogger, map.get(obj));
            }
        }
        j(arrayDeque.removeLast());
    }

    public final void n(ILogger iLogger, Object obj) {
        if (obj == null) {
            j(null);
            return;
        }
        if (obj instanceof Character) {
            j(Character.toString(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof String) {
            j((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            j((Boolean) obj);
            return;
        }
        if (obj instanceof Number) {
            j((Number) obj);
            return;
        }
        if (obj instanceof Date) {
            try {
                j(DateUtils.e((Date) obj));
                return;
            } catch (Exception e2) {
                iLogger.b(SentryLevel.ERROR, "Error when serializing Date", e2);
                j(null);
                return;
            }
        }
        if (obj instanceof TimeZone) {
            try {
                j(((TimeZone) obj).getID());
                return;
            } catch (Exception e3) {
                iLogger.b(SentryLevel.ERROR, "Error when serializing TimeZone", e3);
                j(null);
                return;
            }
        }
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(this, iLogger);
            return;
        }
        if (obj instanceof Collection) {
            l(iLogger, (Collection) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            l(iLogger, Arrays.asList((Object[]) obj));
            return;
        }
        if (obj instanceof Map) {
            m(iLogger, (Map) obj);
            return;
        }
        if (obj instanceof Locale) {
            j(obj.toString());
            return;
        }
        if (obj instanceof AtomicIntegerArray) {
            l(iLogger, JsonSerializationUtils.a((AtomicIntegerArray) obj));
            return;
        }
        if (obj instanceof AtomicBoolean) {
            j(Boolean.valueOf(((AtomicBoolean) obj).get()));
            return;
        }
        if (obj instanceof URI) {
            j(obj.toString());
            return;
        }
        if (obj instanceof InetAddress) {
            j(obj.toString());
            return;
        }
        if (obj instanceof UUID) {
            j(obj.toString());
            return;
        }
        if (obj instanceof Currency) {
            j(obj.toString());
            return;
        }
        if (obj instanceof Calendar) {
            m(iLogger, JsonSerializationUtils.c((Calendar) obj));
        } else if (obj.getClass().isEnum()) {
            j(obj.toString());
        } else {
            iLogger.c(SentryLevel.WARNING, "Failed serializing unknown object.", obj);
        }
    }

    @Override // io.sentry.ObjectWriter
    public final void p(boolean z) {
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter t() {
        j(this.f53128a.removeLast());
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter g() {
        return this;
    }
}
