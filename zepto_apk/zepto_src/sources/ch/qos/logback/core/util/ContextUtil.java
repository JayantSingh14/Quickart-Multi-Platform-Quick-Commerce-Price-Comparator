package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/* loaded from: classes3.dex */
public class ContextUtil extends ContextAwareBase {
    public ContextUtil(Context context) {
        V(context);
    }

    public static String T1() throws SocketException, UnknownHostException {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (inetAddressNextElement != null && !inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isAnyLocalAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            throw new UnknownHostException();
        }
    }

    public final String U1() {
        try {
            return T1();
        } catch (SecurityException e2) {
            o1("Failed to get local hostname", e2);
            return "UNKNOWN_LOCALHOST";
        } catch (SocketException e3) {
            o1("Failed to get local hostname", e3);
            return "UNKNOWN_LOCALHOST";
        } catch (UnknownHostException e4) {
            o1("Failed to get local hostname", e4);
            return "UNKNOWN_LOCALHOST";
        }
    }
}
