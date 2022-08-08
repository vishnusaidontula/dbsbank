package com.dbs.payment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CheckReceiverServiceImplementation implements CheckReceiverService {

	@Override
	public boolean checkReceiverName(String banString) throws IOException {
		File file = new File("./src/main/resources/sdnlist.txt");
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			String st;
			Set<String> data=new HashSet<>();
	        while ((st = br.readLine()) != null)
	        {
	        	List<String> lineData=Arrays.asList(st.split("[-+\\/.,; \"()@]"));
	        	lineData=lower(lineData);
	        	data.addAll(lineData);
	        }
	        List<String> nameSplit=Arrays.asList(banString.split("[-+\\/.,; \"()@]"));
	        nameSplit=lower(nameSplit);
	        for(String s:nameSplit)
	        {
	        	
	        	if(!data.contains(s))
	        	{
	        		return(false);
	        	}
	        }
		}
        return(true);
	}

	private static List<String> lower(List<String> names) {
		return names.stream().map((name)->name.toLowerCase()).collect(Collectors.toList());
	}
}
