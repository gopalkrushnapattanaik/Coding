package com.practice.websocket.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
    	try {
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");

        Socket client = server.accept();

        System.out.println("A client connected.");

    	}catch(Exception e) {
    		 System.out.println("error while running server"+e);
    	}
    }
}