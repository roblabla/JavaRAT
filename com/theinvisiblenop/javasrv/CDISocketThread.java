package com.theinvisiblenop.javasrv;

public class CDISocketThread implements Runnable {
    private Socket cdiSock;
    public CDISocketThread(Socket thesock) {
        Thread runner = new Thread(this);
        this.cdiSock = thesock;
        runner.start();
    }

    public void run() {
        
        while (true) {
            /* Do the shit */
        }
    }
}
