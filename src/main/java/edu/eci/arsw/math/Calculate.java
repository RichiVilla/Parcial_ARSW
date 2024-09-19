package edu.eci.arsw.math;


// Cree una clase de tipo Thread que represente el ciclo de vida de un hilo que calcule una parte de los dígitos requeridos.
public class Calculate extends java.lang.Thread {
    int start;
    int count;
    int n;


   public Calculate(int start, int count, int n) {
        this.start = start;
        this.count = count;
        this.n = n;
    }

    public void run(){
        System.out.println(Main.bytesToHex(PiDigits.getDigits(start, count)));
            int total = start - count; 
            if (start < count){
                total = count - start;
            }
            
            if (count % n == 0){
                int range = count / n;
                while (start <= total){
                    //System.out.println(start + "," + count + "," + range + "," + total);
                    System.out.println(Main.bytesToHex(PiDigits.getDigits(start, range)));
                    start += range;
                    try {
                        join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }


}
