package Blockchain;

import java.util.*;
import java.io.*;


class Block{
	int prevHash;
	String[] data;
	Block(int prevHash, String[] data){
		this.prevHash = prevHash;
		this.data = data;
	}

	@Override
	public String toString(){
		return "".join(" ",data);
	}
}