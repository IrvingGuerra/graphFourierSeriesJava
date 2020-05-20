  
PROJECT = client

all: $(PROJECT)

client: client.o
	g++ client.o -o client 
client.o: client.cpp
	g++ -std=c++11 client.cpp -c 

.PHONY: clean

clean:
	rm -f *.o
	rm -f $(PROJECT).class

run:
	./$(PROJECT)