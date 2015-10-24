package com.torch.helloworld;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TorchHelloWorld {
	public String sayHello() throws IOException {
		ProcessBuilder pb = new ProcessBuilder("/home/neha/torch/install/bin/th", "/home/neha/sayHi.lua");
		Process proc = pb.start();
		BufferedReader output = getOutput(proc);
		String op = "Command = " + pb.command() + "\nOutput: ";
		String s = "";
		while (s != null ) {
			s = output.readLine();
			if (s != null) {
				s = s.replaceAll("0m", "");
				s = s.replaceAll("\\[", "");
				op = op + " " + s;
			}
		}
		return op;
	}
	
	private static BufferedReader getOutput(Process p) {
	    return new BufferedReader(new InputStreamReader(p.getInputStream()));
	}
}
