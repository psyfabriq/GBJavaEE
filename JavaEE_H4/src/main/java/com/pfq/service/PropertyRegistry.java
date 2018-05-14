package com.pfq.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.pfq.utils.OSValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

import static javax.ejb.ConcurrencyManagementType.BEAN;

@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class PropertyRegistry {
	 private final Properties properties = new Properties();
	 
	   @PostConstruct
	    public void applicationStartup() {
	        properties.putAll(System.getProperties());
	        System.out.println("STARTUP !!!!!!!!!!!!!!!");
	        checkUploadFolder();
	        Enumeration<String> enums = (Enumeration<String>) properties.propertyNames();
	        while (enums.hasMoreElements()) {
	          String key = enums.nextElement();
	          String value = properties.getProperty(key);
	          System.out.println(key + " : " + value);
	        }
	    }
	   
	private void checkUploadFolder() {
		String uploadFolder = getProperty("jboss.server.base.dir") + OSValidator.getOSSeparator() + "public_content"
				+ OSValidator.getOSSeparator() + "javaee4";
		if (!Files.exists(Paths.get(uploadFolder))) {
			try {
				Files.createDirectories(Paths.get(uploadFolder));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setProperty("pfq.public.folder", uploadFolder );
		
	}

	    @PreDestroy
	    public void applicationShutdown() {
	        properties.clear();
	    }

	    public String getProperty(final String key) {
	        return properties.getProperty(key);
	    }

	    public String setProperty(final String key, final String value) {
	        return (String) properties.setProperty(key, value);
	    }

	    public String removeProperty(final String key) {
	        return (String) properties.remove(key);
	    }
}
