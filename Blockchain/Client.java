package Blockchain;

import java.io.*;
import java.net.*;
import java.util.*;


class Client{
	Socket s;
	DataOutputStream oup;
	DataInputStream inp;
	Client(String address,int port){
		try{
			s = new Socket(address,port);
			oup = new DataOutputStream(s.getOutputStream());
			inp = new DataInputStream(s.getInputStream());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	ArrayList<String> get()throws IOException{
		oup.writeUTF("query");
		ArrayList<String> st = new ArrayList<>();
		String t = inp.readUTF();
		while(!t.equals("end")){
			st.add(t);
			t = inp.readUTF();
		}
		return st;
	}

	void put(ArrayList<String> data)throws IOException{
		oup.writeUTF("addition");
		for(String str: data)
			oup.writeUTF(str);
		oup.writeUTF("stop");
	}
}