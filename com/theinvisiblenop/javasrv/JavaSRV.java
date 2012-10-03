package com.theinvisiblenop.javasrv;

import java.net.ServerSocket;
import java.net.Socket;

public class JavaSRV {
    public static main(String[] args) {
        ServerSocket test = new ServerSocket(/* the port */);
        while (true) {
            try {
                Socket newsock = test.accept();
                
            }
        }
    }
}
