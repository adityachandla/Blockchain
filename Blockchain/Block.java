package Blockchain;

import java.util.*;
import java.io.*;


class Block{
	int prevHash;
	String[] data;
	Block next;
	Block(int prevHash, String[] data){
		this.prevHash = prevHash;
		this.data = data;
		next = null;
	}

	int getHash(){
		return Integer.hashCode(Arrays.hashCode(data)+prevHash);
	}

	@Override
	public String toString(){
		return String.format("(%s)","".join(",",data));
	}
}