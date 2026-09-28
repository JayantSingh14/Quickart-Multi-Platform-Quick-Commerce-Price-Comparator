package ch.qos.logback.classic.pattern;

import androidx.fragment.app.e;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public class SyslogStartConverter extends ClassicConverter {

    /* renamed from: h, reason: collision with root package name */
    public SimpleDateFormat f13324h;

    /* renamed from: i, reason: collision with root package name */
    public SimpleDateFormat f13325i;

    /* renamed from: k, reason: collision with root package name */
    public String f13327k;

    /* renamed from: l, reason: collision with root package name */
    public int f13328l;

    /* renamed from: f, reason: collision with root package name */
    public long f13322f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f13323g = null;

    /* renamed from: j, reason: collision with root package name */
    public final Calendar f13326j = Calendar.getInstance(Locale.US);

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        int i2;
        String str;
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        StringBuilder sb = new StringBuilder("<");
        int i3 = this.f13328l;
        Level levelA = iLoggingEvent.a();
        int i4 = levelA.f13240a;
        if (i4 == 5000 || i4 == 10000) {
            i2 = 7;
        } else if (i4 == 20000) {
            i2 = 6;
        } else if (i4 == 30000) {
            i2 = 4;
        } else {
            if (i4 != 40000) {
                throw new IllegalArgumentException("Level " + levelA + " is not a valid level for a printing method");
            }
            i2 = 3;
        }
        sb.append(i3 + i2);
        sb.append(">");
        long j2 = iLoggingEvent.j();
        synchronized (this) {
            try {
                if (j2 / 1000 != this.f13322f) {
                    this.f13322f = j2 / 1000;
                    Date date = new Date(j2);
                    this.f13326j.setTime(date);
                    this.f13323g = String.format("%s %2d %s", this.f13324h.format(date), Integer.valueOf(this.f13326j.get(5)), this.f13325i.format(date));
                }
                str = this.f13323g;
            } catch (Throwable th) {
                throw th;
            }
        }
        sb.append(str);
        sb.append(' ');
        return e.t(sb, this.f13327k, ' ');
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        int i2;
        String hostName;
        String strF = f();
        if (strF == null) {
            d("was expecting a facility string as an option");
            return;
        }
        if ("KERN".equalsIgnoreCase(strF)) {
            i2 = 0;
        } else if ("USER".equalsIgnoreCase(strF)) {
            i2 = 8;
        } else if ("MAIL".equalsIgnoreCase(strF)) {
            i2 = 16;
        } else if ("DAEMON".equalsIgnoreCase(strF)) {
            i2 = 24;
        } else if ("AUTH".equalsIgnoreCase(strF)) {
            i2 = 32;
        } else if ("SYSLOG".equalsIgnoreCase(strF)) {
            i2 = 40;
        } else if ("LPR".equalsIgnoreCase(strF)) {
            i2 = 48;
        } else if ("NEWS".equalsIgnoreCase(strF)) {
            i2 = 56;
        } else if ("UUCP".equalsIgnoreCase(strF)) {
            i2 = 64;
        } else if ("CRON".equalsIgnoreCase(strF)) {
            i2 = 72;
        } else if ("AUTHPRIV".equalsIgnoreCase(strF)) {
            i2 = 80;
        } else if ("FTP".equalsIgnoreCase(strF)) {
            i2 = 88;
        } else if ("NTP".equalsIgnoreCase(strF)) {
            i2 = 96;
        } else if ("AUDIT".equalsIgnoreCase(strF)) {
            i2 = 104;
        } else if ("ALERT".equalsIgnoreCase(strF)) {
            i2 = 112;
        } else if ("CLOCK".equalsIgnoreCase(strF)) {
            i2 = 120;
        } else if ("LOCAL0".equalsIgnoreCase(strF)) {
            i2 = 128;
        } else if ("LOCAL1".equalsIgnoreCase(strF)) {
            i2 = WKSRecord.Service.PROFILE;
        } else if ("LOCAL2".equalsIgnoreCase(strF)) {
            i2 = 144;
        } else if ("LOCAL3".equalsIgnoreCase(strF)) {
            i2 = ModuleDescriptor.MODULE_VERSION;
        } else if ("LOCAL4".equalsIgnoreCase(strF)) {
            i2 = 160;
        } else if ("LOCAL5".equalsIgnoreCase(strF)) {
            i2 = 168;
        } else if ("LOCAL6".equalsIgnoreCase(strF)) {
            i2 = 176;
        } else {
            if (!"LOCAL7".equalsIgnoreCase(strF)) {
                throw new IllegalArgumentException(strF.concat(" is not a valid syslog facility string"));
            }
            i2 = 184;
        }
        this.f13328l = i2;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e2) {
            e("Could not determine local host name", e2);
            hostName = "UNKNOWN_LOCALHOST";
        }
        this.f13327k = hostName;
        try {
            Locale locale = Locale.US;
            this.f13324h = new SimpleDateFormat("MMM", locale);
            this.f13325i = new SimpleDateFormat("HH:mm:ss", locale);
            this.f13651e = true;
        } catch (IllegalArgumentException e3) {
            e("Could not instantiate SimpleDateFormat", e3);
        }
    }
}
