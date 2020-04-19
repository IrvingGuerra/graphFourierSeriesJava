client: client.o
	g++ client.o -o client 
client.o: client.cpp
	g++ -std=c++11 client.cpp -c 