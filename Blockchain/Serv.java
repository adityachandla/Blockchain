package Blockchain

import java.util.*;
import java.io.*;
import java.net.*;



class Serv{
	public static void main(String args[]) throws IOException{
		ServerSocket ss = new ServerSocket(8080);

		String gen[] = {"Lord of the six kingdoms"};
		Block genesis = new Block(0,gen);
		while(true){
			Socket s = ss.accept();
			DataInputStream inp = new DataInputStream(s.getInputStream());
			DataOutputStream oup = new DataOutputStream(s.getOutputStream());
			String type = inp.readUTF();
			if(type.equals("query")){
				//we validate and send the entire thing
			}else if(type.equals("addition")){

			}
		}
	}
}