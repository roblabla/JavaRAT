package com.theinvisiblenop.javacdi;

import java.util.Vector;
import java.util.Iterator;
import javax.script.*;

public class ClientManager implements Runnable {
    private Vector<String> jobQueue;
    private ScriptEngine engine;
    private boolean running = true;
    public ClientManager(String engineName) {
        ScriptEngineManager factory = new ScriptEngineManager();
        this.engine = factory.getEngineByExtension(engineName);
        Thread thr = new Thread(this);
    }
    public void run() {
        while (running) {
            while (jobQueue.size() == 0)
                wait();
            Iterator itr = jobQueue.iterator();
            while (itr.hasNext()) {
                String next = itr.next();
                println(next);
                itr.remove();
            }
        }
    }

    public synchronized void addToQueue(String str) {
        while (jobQueue.size() == jobQueue.capacity())
            // This is a 1s sleep... not efficient at all.
            // Should use something else than a Vector, it would work better methinks.
            sleep(1000);
        jobQueue.add(str);
        notify();
    }
}
