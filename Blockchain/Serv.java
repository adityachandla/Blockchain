package Blockchain;

import java.util.*;
import java.io.*;
import java.net.*;



class Serv{
	public static void main(String args[]) throws IOException{
		ServerSocket ss = new ServerSocket(8080);

		String gen[] = {"Lord of the six kingdoms"};
		Block genesis = new Block(0,gen);
		Block last = genesis;
		while(true){
			Socket s = ss.accept();
			System.out.println("Connection accepted at server");
			DataInputStream inp = new DataInputStream(s.getInputStream());
			DataOutputStream oup = new DataOutputStream(s.getOutputStream());
			String type = inp.readUTF();
			if(type.equals("query")){
				//we validate and send the entire thing
				Block temp = genesis;
				while(temp.next != null){
					temp = temp.next;
					oup.writeUTF(temp.toString());
				}
				oup.writeUTF("end");
			}else if(type.equals("addition")){
				//we add something o the chain
				ArrayList<String> toAdd = new ArrayList<>();
				String data = inp.readUTF();
				while(!data.equals("stop")){
					toAdd.add(data);
					data = inp.readUTF();
				}
				Block n = new Block(last.getHash(),toAdd.toArray(new String[toAdd.size()]));
				last.next = n;
				last = last.next;
			}
		}
	}
}