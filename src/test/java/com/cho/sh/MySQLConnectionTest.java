package com.cho.sh;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySQLConnectionTest {
    
    @Inject
    private DataSource ds;
 
    @Test
    public void testConnection() throws Exception {
 
        try (Connection con = ds.getConnection()) {
 
            System.out.println("\n >>>>>>>>>> Connection 출력 : " + con + "\n");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();  
        encryptor.setAlgorithm("PBEWITHMD5ANDDES");  
        encryptor.setPassword("record");  
        String encryptedPass = encryptor.encrypt("111111");
        String decryptedPass = encryptor.decrypt(encryptedPass);
        System.out.println("Encrypted Password for admin is : "+encryptedPass);  
        System.out.println("Decrypted Password for admin is : "+decryptedPass);    
    }
    
    
}
