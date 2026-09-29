package es.uniovi.ds.lab.vm;

// Versión sin control de errores

public class State {

    private int[] memory = new int[1024];
    private int[] stack = new int[32];

    private int ip = 0;
    private int sp = 0;

    public int getIP() {
        return ip;
    }

    public void setIP(int ip) {
        this.ip = ip;
    }

    public void push(int value) {
        stack[sp++] = value;
    }

    public int pop() {
        return stack[--sp];
    }

    public int read(int address) {
        return memory[address];
    }

    public void write(int address, int value) {
        memory[address] = value;
    }

}
