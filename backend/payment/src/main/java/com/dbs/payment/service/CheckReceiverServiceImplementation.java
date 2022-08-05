package com.dbs.payment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CheckReceiverServiceImplementation implements CheckReceiverService {

	@Override
	public boolean checkReceiverName(String banString) throws IOException {
//		URL url = getClass().getResource("sdnlist.txt");
//		File file = new File(url.getPath());
		File file = new File("./src/main/resources/sdnlist.txt");
//		System.out.println(file.getAbsolutePath());
		BufferedReader br=new BufferedReader(new FileReader(file));
		String st;
		Set<String> data=new HashSet<>();
        while ((st = br.readLine()) != null)
        {
        	List<String> lineData=Arrays.asList(st.split("[-+\\/.,; \"()@]"));
        	lineData=lower(lineData);
        	data.addAll(lineData);
        }
        //Akash-Varada/123@Gmail.Com Helo
		 
        List<String> nameSplit=Arrays.asList(banString.split("[-+\\/.,; \"()@]"));
        nameSplit=lower(nameSplit);
        for(String s:nameSplit)
        {
        	
        	if(!data.contains(s))
        	{
        		return(false);
        	}
        }
        return(true);
	}

	private static List<String> lower(List<String> names) {
		// TODO Auto-generated method stub
		return names.stream().map((name)->name.toLowerCase()).collect(Collectors.toList());
	}
}
