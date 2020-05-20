#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

#include <string.h> 
#include <stdlib.h> 
#include <math.h>

#include <iostream>
using namespace std;

int puerto = 5010;
double PI = 3.14159265;
int terminos = 1;

int main(void){

    std::cout << "[ OK ] Entrando" << std::endl;

    int socketUDP, res, clilen; 
    struct sockaddr_in server_addr; 
    socketUDP = socket(AF_INET, SOCK_DGRAM, 0);

    memset(&server_addr, 0, sizeof(server_addr)); 
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = inet_addr("192.168.0.2"); //localhost
    server_addr.sin_port = htons(puerto);

    double fnX[629];
    double fnY[629];

    double bufX[6284];
    double bufY[6284];

    double bufXpt1[629];
    double bufXpt2[629];
    double bufXpt3[629];
    double bufXpt4[629];
    double bufXpt5[629];
    double bufXpt6[629];
    double bufXpt7[629];
    double bufXpt8[629];
    double bufXpt9[629];
    double bufXpt10[629];

    double bufYpt1[629];
    double bufYpt2[629];
    double bufYpt3[629];
    double bufYpt4[629];
    double bufYpt5[629];
    double bufYpt6[629];
    double bufYpt7[629];
    double bufYpt8[629];
    double bufYpt9[629];
    double bufYpt10[629];
   

    std::cout << "[ OK ] - Generando f(x) = x" << std::endl;

    double x, y;
    int i = 0, j = 0;
    for(x=-PI ; x<=PI ; x+=0.01){
        y = -x;
        fnX[i] = x;
        fnY[i] = y;
        i++;
    } 

    sendto(socketUDP, fnX, sizeof(fnX), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));

    int server_len = sizeof(server_addr);
    while (true){
        // Ahora estaremos reciviendo respuestas
        int res;
        recvfrom(socketUDP, (char *)&res, sizeof(int), 0, (struct sockaddr *)&server_addr, (socklen_t *)&server_len);
        std::cout << "[ OK ] Se recibio: " << res << std::endl;
        switch (res){
        case 1:
            //Nos pide fn Parte Y
                std::cout << "[ SEND ] - Enviando f(x) = x parte Y"  << std::endl;
                sendto(socketUDP, fnY, sizeof(fnY), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            break;
        case 2:
            //Pide calcular fourier y enviar parte X
            i = 0; 
            j = 0;
            for(x=-PI ; x<=PI ; x+=0.001){
                y = 0;
                for(int n = 1; n <= terminos; n++){
                    int signo = (int) pow(-1, (n + 1));
                    y += signo * ( sin(n*-x) / n );
                }
                y = y * 2;
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
                    bufXpt1[j] = x;
                    bufYpt1[j] = y;
                }else if(i >= 629 && i < 1258){
                    bufXpt2[j] = x;
                    bufYpt2[j] = y;
                }else if(i >= 1258 && i < 1887){
                    bufXpt3[j] = x;
                    bufYpt3[j] = y;
                }else if(i >= 1887 && i < 2516){
                    bufXpt4[j] = x;
                    bufYpt4[j] = y;
                }else if(i >= 2516 && i < 3145){
                    bufXpt5[j] = x;
                    bufYpt5[j] = y;
                }else if(i >= 3145 && i < 3774){
                    bufXpt6[j] = x;
                    bufYpt6[j] = y;
                }else if(i >= 3774 && i < 4403){
                    bufXpt7[j] = x;
                    bufYpt7[j] = y;
                }else if(i >= 4403 && i < 5032){
                    bufXpt8[j] = x;
                    bufYpt8[j] = y;
                }else if(i >= 5032 && i < 5661){
                    bufXpt9[j] = x;
                    bufYpt9[j] = y;
                }else if(i >= 5661 && i < 6290){
                    bufXpt10[j] = x;
                    bufYpt10[j] = y;
                }
                //bufX[i] = x;
                //bufY[i] = y;
                i++;
                j++;
            }
            sendto(socketUDP, bufXpt1, sizeof(bufXpt1), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt1" << std::endl;
            break;
        case 3:
            sendto(socketUDP, bufXpt2, sizeof(bufXpt2), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt2" << std::endl;
            break;
        case 4:
            sendto(socketUDP, bufXpt3, sizeof(bufXpt3), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt3" << std::endl;
            break;
        case 5:
            sendto(socketUDP, bufXpt4, sizeof(bufXpt4), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt4" << std::endl;
            break;
        case 6:
            sendto(socketUDP, bufXpt5, sizeof(bufXpt5), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt5" << std::endl;
            break;
        case 7:
            sendto(socketUDP, bufXpt6, sizeof(bufXpt6), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt6" << std::endl;
            break;
        case 8:
            sendto(socketUDP, bufXpt7, sizeof(bufXpt7), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt7" << std::endl;
            break;
        case 9:
            sendto(socketUDP, bufXpt8, sizeof(bufXpt8), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt8" << std::endl;
            break;
        case 10:
            sendto(socketUDP, bufXpt9, sizeof(bufXpt9), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt9" << std::endl;
            break;
        case 11:
            sendto(socketUDP, bufXpt10, sizeof(bufXpt10), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte X pt10" << std::endl;
            break;
        case 12:
            sendto(socketUDP, bufYpt1, sizeof(bufYpt1), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt1" << std::endl;
            break;
        case 13:
            sendto(socketUDP, bufYpt2, sizeof(bufYpt2), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt2" << std::endl;
            break;
        case 14:
            sendto(socketUDP, bufYpt3, sizeof(bufYpt3), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt3" << std::endl;
            break;
        case 15:
            sendto(socketUDP, bufYpt4, sizeof(bufYpt4), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt4" << std::endl;
            break;
        case 16:
            sendto(socketUDP, bufYpt5, sizeof(bufYpt5), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt5" << std::endl;
            break;
        case 17:
            sendto(socketUDP, bufYpt6, sizeof(bufYpt6), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt6" << std::endl;
            break;
        case 18:
            sendto(socketUDP, bufYpt7, sizeof(bufYpt7), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt7" << std::endl;
            break;
        case 19:
            sendto(socketUDP, bufYpt8, sizeof(bufYpt8), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt8" << std::endl;
            break;
        case 20:
            sendto(socketUDP, bufYpt9, sizeof(bufYpt9), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt9" << std::endl;
            break;
        case 21:
            sendto(socketUDP, bufYpt10, sizeof(bufYpt10), 0, (struct sockaddr *)&server_addr, sizeof(server_addr));
            std::cout << "[ SEND ] - Enviando FOURIER parte Y pt10" << std::endl;
            terminos++;
            break;

        default:
            break;
        }
    }
}