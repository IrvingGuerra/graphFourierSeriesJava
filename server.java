import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class server extends JFrame {

    public static final int WindowsX = 800;
    public static final int WindowsY = 600;
    public static final int X = WindowsX / 2;
    public static final int Y = WindowsY / 2;
    public static final double PI = 3.14159265;
    public static DatagramSocket socketUDP;
    public static InetAddress IPAddress;
    public static int port;
    public static Graphics2D g2d;

    public static ByteBuffer res;
    public static DatagramPacket dp;
    public static byte[] receiveFn;
    public static DatagramPacket reply;
    public static double[] sfX;
    public static double[] sfY;

    public class hiloPinta extends Thread {
        public void run() {
            try {
                socketUDP = new DatagramSocket(5010);
                while(true){
                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt1");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(2);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress, port);
                    socketUDP.send(dp);
                
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt1[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt1...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt2");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(3);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt2[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt2...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt3");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(4);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt3[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt3...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt4");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(5);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt4[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt4...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt5");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(6);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt5[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt5...");
                    
                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt6");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(7);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt6[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt6...");
                    
                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt7");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(8);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt7[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt7...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt8");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(9);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt8[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt8...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt9");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(10);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt9[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt9...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte X pt10");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(11);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfXpt10[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio Fourier X pt10...");


                    // 10 PARTES DE Y
                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt1");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(12);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt1[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt1...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt2");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(13);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt2[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt2...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt3");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(14);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt3[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt3...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt4");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(15);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt4[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt4...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt5");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(16);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt5[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt5...");
                    
                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt6");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(17);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt6[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt6...");
                    
                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt7");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(18);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt7[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt7...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt8");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(19);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt8[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt8...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt9");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(20);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt9[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt9...");

                    System.out.println("[ SEND ] Solicitando serie Fourier parte Y pt10");
                    res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    res.putInt(21);
                    dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
                    socketUDP.send(dp);
                    receiveFn = new byte[5032];
                    reply = new DatagramPacket(receiveFn, receiveFn.length);
                    socketUDP.receive(reply);
                    double sfYpt10[] = toDoubleArray(reply.getData());
                    System.out.println("[ OK ] - Se recibio FourierY pt10...");

                    sfX = new double[6290];
                    sfY = new double[6290];
                    int j = 0;
                    for(int i = 0;  i < 6290 ; i++){
                        if(i == 629 
                        || i == 1258 
                        || i == 1887 
                        || i == 2516 
                        || i == 3145 
                        || i == 3774 
                        || i == 4403 
                        || i == 5032 
                        || i == 5661
                        ){
                            j=0;
                        }
                        if(i >= 0 && i < 629){
                            sfX[i] = sfXpt1[j];
                            sfY[i] = sfYpt1[j];
                        }else if(i >= 629 && i < 1258){
                            sfX[i] = sfXpt2[j];
                            sfY[i] = sfYpt2[j];
                        }else if(i >= 1258 && i < 1887){
                            sfX[i] = sfXpt3[j];
                            sfY[i] = sfYpt3[j];
                        }else if(i >= 1887 && i < 2516){
                            sfX[i] = sfXpt4[j];
                            sfY[i] = sfYpt4[j];
                        }else if(i >= 2516 && i < 3145){
                            sfX[i] = sfXpt5[j];
                            sfY[i] = sfYpt5[j];
                        }else if(i >= 3145 && i < 3774){
                            sfX[i] = sfXpt6[j];
                            sfY[i] = sfYpt6[j];
                        }else if(i >= 3774 && i < 4403){
                            sfX[i] = sfXpt7[j];
                            sfY[i] = sfYpt7[j];
                        }else if(i >= 4403 && i < 5032){
                            sfX[i] = sfXpt8[j];
                            sfY[i] = sfYpt8[j];
                        }else if(i >= 5032 && i < 5661){
                            sfX[i] = sfXpt9[j];
                            sfY[i] = sfYpt9[j];
                        }else if(i >= 5661 && i < 6290){
                            sfX[i] = sfXpt10[j];
                            sfY[i] = sfYpt10[j];
                        }
                        j++;
                    }
                    g2d.setColor(Color.RED);
                    graphFN(sfX,sfY, sfX.length);
                    int stop = 2147483647;
                    while(stop!=0){
                        stop--;
                    }
                }
            } catch (SocketException e1) {
                e1.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class hiloBorra extends Thread {
        public void run(){
            int stop = 2147483647;
            while(stop!=0){
                stop--;
            }
            g2d.setColor(Color.WHITE);
            graphFN(sfX,sfY, sfX.length);
        }
    }

    public server() {
        super("Series de Fourier");
        setSize(WindowsX, WindowsY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void drawPoint(double x, double y) {
        Shape l = new Line2D.Double(x, y, x, y);
        g2d.draw(l);
    }

    void setWindow() {
        int x, y;
        for (y = 0; y < WindowsY; y++)
            drawPoint(X, y);
        for (x = 0; x < WindowsX; x++)
            drawPoint(x, Y);
    }

    public void graphFN(double x[], double y[], int size){
        //Graficamos segundo periodo
        for(int i = 0 ; i < size; i++){
            drawPoint((x[i]*50)+X - (2*PI*50),(y[i]*50)+Y);
            i++;
        } 
        for(int i = 0 ; i < size; i++){
            drawPoint((x[i]*50)+X,(y[i]*50)+Y);
            i++;
        } 
        for(int i = 0 ; i < size; i++){
            drawPoint((x[i]*50)+X + (2*PI*50),(y[i]*50)+Y);
            i++;
        } 
    }

    public static double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE / Byte.SIZE;
        double[] doubles = new double[byteArray.length / times];
        for(int i=0;i<doubles.length;i++){
            doubles[i] = ByteBuffer.wrap(byteArray, i*times, times).order(ByteOrder.LITTLE_ENDIAN).getDouble();
        }
        return doubles;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        setWindow();
        try {
            socketUDP = new DatagramSocket(5010);
            System.out.println("[ OK ] - Esperando Fx parte X...");
            receiveFn = new byte[5032];
            reply = new DatagramPacket(receiveFn, receiveFn.length);
            socketUDP.receive(reply);
            double fnX[] = toDoubleArray(reply.getData());
            System.out.println("[ OK ] - Se recibio X ...");
            IPAddress = reply.getAddress();
            port = reply.getPort();

            //Respondemos con 1 
            res = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            res.putInt(1);
            dp = new DatagramPacket(res.array(), res.limit(), IPAddress , port);
            System.out.println("[ SEND ] Confirmando fx parte X");
            socketUDP.send(dp);
            System.out.println("[ OK ] - Esperando Fx parte Y...");
            receiveFn = new byte[5032];
            reply = new DatagramPacket(receiveFn, receiveFn.length);
            socketUDP.receive(reply);
            double fnY[] = toDoubleArray(reply.getData());
            System.out.println("[ OK ] - Se recibio Y...");

            //Ahora graficamos

            graphFN(fnX,fnY, fnX.length);

            socketUDP.close();
            
            hiloPinta elHilo = new hiloPinta();
            hiloBorra elHilo2 = new hiloBorra();
            elHilo.start();
            elHilo2.start();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new server().setVisible(true);
            }
        });
    }
}