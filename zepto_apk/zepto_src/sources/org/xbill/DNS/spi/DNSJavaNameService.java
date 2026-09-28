package org.xbill.DNS.spi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import lombok.Generated;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AAAARecord;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.PTRRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.ReverseMap;
import org.xbill.DNS.TextParseException;
import sun.net.spi.nameservice.NameService;

/* loaded from: classes5.dex */
public class DNSJavaNameService implements NameService {
    private static final String DOMAIN_PROPERTY = "sun.net.spi.nameservice.domain";
    private static final String NAMESERVERS_PROPERTY = "sun.net.spi.nameservice.nameservers";
    private static final String PREFER_V6_PROPERTY = "java.net.preferIPv6Addresses";

    @Generated
    private static final Logger log = LoggerFactory.b(DNSJavaNameService.class);
    private boolean addressesLoaded;
    private InetAddress[] localhostAddresses;
    private Name localhostName;
    private InetAddress[] localhostNamedAddresses;
    private final boolean preferV6 = Boolean.getBoolean(PREFER_V6_PROPERTY);

    public DNSJavaNameService() throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.localhostName = null;
        this.localhostNamedAddresses = null;
        this.localhostAddresses = null;
        int i2 = 0;
        this.addressesLoaded = false;
        String property = System.getProperty(NAMESERVERS_PROPERTY);
        String property2 = System.getProperty(DOMAIN_PROPERTY);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            String[] strArr = new String[stringTokenizer.countTokens()];
            while (stringTokenizer.hasMoreTokens()) {
                strArr[i2] = stringTokenizer.nextToken();
                i2++;
            }
            try {
                Lookup.setDefaultResolver(new ExtendedResolver(strArr));
            } catch (UnknownHostException unused) {
                log.c(NAMESERVERS_PROPERTY);
            }
        }
        if (property2 != null) {
            try {
                Lookup.setDefaultSearchPath(property2);
            } catch (TextParseException unused2) {
                log.c(DOMAIN_PROPERTY);
            }
        }
        try {
            Method declaredMethod = Class.forName("java.net.InetAddressImplFactory").getDeclaredMethod(CLConstants.CRED_SUB_TYPE_MANDATE_CREATE, null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            Class<?> cls = Class.forName("java.net.InetAddressImpl");
            Method method = cls.getMethod("getLocalHostName", null);
            method.setAccessible(true);
            this.localhostName = Name.fromString((String) method.invoke(objInvoke, null));
            Method method2 = cls.getMethod("lookupAllHostAddr", String.class);
            method2.setAccessible(true);
            this.localhostNamedAddresses = (InetAddress[]) method2.invoke(objInvoke, this.localhostName.toString());
            this.localhostAddresses = (InetAddress[]) method2.invoke(objInvoke, "localhost");
            this.addressesLoaded = true;
        } catch (Exception e2) {
            log.j("Could not obtain localhost", e2);
        }
    }

    public String getHostByAddr(byte[] bArr) throws UnknownHostException {
        Name nameFromAddress = ReverseMap.fromAddress(InetAddress.getByAddress(bArr));
        Record[] recordArrRun = new Lookup(nameFromAddress, 12).run();
        if (recordArrRun != null) {
            return ((PTRRecord) recordArrRun[0]).getTarget().toString();
        }
        throw new UnknownHostException("Unknown address: " + nameFromAddress);
    }

    public InetAddress[] lookupAllHostAddr(String str) throws UnknownHostException {
        try {
            Name name = new Name(str);
            if (this.addressesLoaded) {
                if (name.equals(this.localhostName)) {
                    return this.localhostNamedAddresses;
                }
                if ("localhost".equalsIgnoreCase(str)) {
                    return this.localhostAddresses;
                }
            }
            Record[] recordArrRun = this.preferV6 ? new Lookup(name, 28).run() : null;
            if (recordArrRun == null) {
                recordArrRun = new Lookup(name, 1).run();
            }
            if (recordArrRun == null && !this.preferV6) {
                recordArrRun = new Lookup(name, 28).run();
            }
            if (recordArrRun == null) {
                throw new UnknownHostException(str);
            }
            InetAddress[] inetAddressArr = new InetAddress[recordArrRun.length];
            for (int i2 = 0; i2 < recordArrRun.length; i2++) {
                Record record = recordArrRun[i2];
                if (record instanceof ARecord) {
                    inetAddressArr[i2] = ((ARecord) record).getAddress();
                } else {
                    inetAddressArr[i2] = ((AAAARecord) record).getAddress();
                }
            }
            return inetAddressArr;
        } catch (TextParseException unused) {
            throw new UnknownHostException(str);
        }
    }
}
