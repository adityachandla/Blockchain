package Blockchain;

import java.io.*;
import java.util.*;



class Main{
	public static void main(String args[]) throws IOException{
		if(args.length < 2)
			return;


		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		while(true){
			System.out.println("Press 1 for query 2 for addition");
			int type = Integer.parseInt(br.readLine());
			Client c;
			if(type == 1){
				//query
				c = new Client(args[0],Integer.parseInt(args[1]));
				System.out.println(c.get());
			}else if(type == 2){
				//addition
				c = new Client(args[0],Integer.parseInt(args[1]));
				System.out.println("write stop to terminate");
				String s = br.readLine().trim();
				ArrayList<String> st = new ArrayList<>();
				while(!s.equals("stop")){
					st.add(s);
					s = br.readLine().trim();
				}
				c.put(st);
			}
		}
	}
}