package com.hamza.Gestion_bank;

import com.hamza.Gestion_bank.entities.UserInfo;
import com.hamza.Gestion_bank.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionBankApplication  implements CommandLineRunner {


	@Autowired
	UserService userInfoService;

	public static void main(String[] args) {
		SpringApplication.run(GestionBankApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//UserInfo userInfo=new UserInfo("hamza","hrebhi07@gmail.com","azerty", "ADMIN_ROLES,USER_ROLES");
		//userInfoService.addUser(userInfo);

	}

}
