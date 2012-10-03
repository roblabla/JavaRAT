package com.theinvisiblenop.javasrv;

public class GSocket implements Runnable {
    private Socket socket;
    public GSocket(Socket socket) {
           this.socket = socket;
           Thread thr = new Thread(this);
           thr.start();
    }
    public void run() {
        String line = this.socket.readLine()
        String[] args = line.split(":");
        if (args[0]
    }
}
