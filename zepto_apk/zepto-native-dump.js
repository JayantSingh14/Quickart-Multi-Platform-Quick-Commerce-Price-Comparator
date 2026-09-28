"use strict";

console.log("[*] Zepto native HTTP dump loaded");

function hook(name) {
    var ptr = Module.findExportByName("libc.so", name);
    if (!ptr) {
        console.log("[-] " + name + " not found");
        return;
    }

    console.log("[+] Hooking " + name);

    Interceptor.attach(ptr, {
        onEnter: function (args) {
            try {
                let buf = null;
                let len = 0;

                if (name === "sendto") {
                    buf = args[1];
                    len = args[2].toInt32();
                } else if (name === "writev") {
                    const iov = args[1];
                    const iovcnt = args[2].toInt32();
                    if (iovcnt > 0) {
                        buf = Memory.readPointer(iov);
                        len = Memory.readU32(iov.add(Process.pointerSize));
                    }
                } else if (name === "sendmsg") {
                    const msg = args[1];
                    const iov = Memory.readPointer(msg.add(Process.pointerSize * 2));
                    buf = Memory.readPointer(iov);
                    len = Memory.readU32(iov.add(Process.pointerSize));
                }

                if (!buf || len < 50 || len > 20000) return;

                const data = Memory.readUtf8String(buf, len);

                if (
                    data.includes("graphql") ||
                    data.includes("operationName") ||
                    data.includes("query") ||
                    data.includes("cart") ||
                    data.includes("sku")
                ) {
                    console.log("\n===== PLAINTEXT HTTP PAYLOAD =====");
                    console.log(data);
                    console.log("=================================\n");
                }
            } catch (e) {}
        }
    });
}

hook("writev");
hook("sendmsg");
hook("sendto");
